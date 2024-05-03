package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
 import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import bsh.ParseException;

public class ExternalFileTest {
	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void initSetup() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir")+
				"//src/test/resources/configFiles/config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		fin.close();
	}
	
	@BeforeMethod
	public void setup() {
		String strBrowser = prop.getProperty("browser");
		System.out.println("Browser name ..."+strBrowser);
			if(strBrowser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			if(strBrowser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		}
	@Test(dataProvider = "logindata")
	public void validLogin(String strUsr, String strPwd) {	
			driver.get(prop.getProperty("url"));
			driver.findElement(By.cssSelector(readObjPath("userName"))).sendKeys(strUsr);
			driver.findElement(By.name(readObjPath("userPwd"))).sendKeys(strPwd);
			driver.findElement(By.className(readObjPath("loginBtn"))).click(); 
			boolean isValid = driver.findElement(By.cssSelector(readObjPath("successMsg"))).isDisplayed();
			AssertJUnit.assertTrue(isValid);
			
	  }
	
	/*@DataProvider(name = "logindata")
	public Object[][] getData(){
		String path = System.getProperty("user.dir")+
				"//src/test/resources/testData/loginData.csv";
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(path));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String cols[];
		ArrayList<Object> dataList = new ArrayList<Object>();
		try {
			while((cols = reader.readNext()) != null) {
				Object record[] = {cols[0],cols[1]};
				dataList.add(record);
			}
			reader.close();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return dataList.toArray(new Object[dataList.size()][]);
		
	}*/
	
	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException, ParseException, org.json.simple.parser.ParseException{
		String path = System.getProperty("user.dir")+
				"//src/test/resources/testData/loginData.json";
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject jsonObj = (JSONObject)obj;
		JSONArray userArray = (JSONArray)jsonObj.get("userLogins");
		String arr[][] = new String[userArray.size()][];
		for (int i = 0; i < userArray.size(); i++ ) {
			JSONObject user = (JSONObject)userArray.get(i);
			String strUser = (String)user.get("username");
			String strPwd = (String)user.get("password");
			String record[] = {strUser, strPwd};
			arr[i] = record;
			
		}
		return arr;
	}
		
	
	
	public String readObjPath(String ObjName){
		String ObjPath = "";
		String path = System.getProperty("user.dir")+
				"//src/test/resources/testData/loginObjects.xlsx";
		FileInputStream fin;
		XSSFWorkbook workbook = null;
		try {
			fin = new  FileInputStream(path);
			workbook = new XSSFWorkbook(fin);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet loginSheet = workbook.getSheet("loginPage");
		int numRows = loginSheet.getLastRowNum();
		for(int i=1; i<=numRows; i++) {
			XSSFRow row = loginSheet.getRow(i);
			
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(ObjName)) {
				ObjPath = row.getCell(1).getStringCellValue();
			}
		}
		return ObjPath;
}
}
