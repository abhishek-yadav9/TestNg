package testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
  @Test
  public void validLogin() {
	  WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		//driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("input[name='username'")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
  }
}
