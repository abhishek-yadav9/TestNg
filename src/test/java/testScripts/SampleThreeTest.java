package testScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test(groups = "featureOne")
	  public void testOne() {
		  System.out.println("Test 1 in SampleThree");
	  }
	  
	  @Test(groups = "featureTwo")
	  public void testTwo() {
		  System.out.println("Test 2 in SampleThree");
	  }
	  
	  @Test(groups = "featureThree")
	  public void testThree() {
		  System.out.println("Test 3 in SampleThree");
	  }
	  
	  @Test
	  public void testFour() {
		  System.out.println("Test 4 in SampleThree");
	  }
}
