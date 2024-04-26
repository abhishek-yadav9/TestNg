package testScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test(groups = "featureOne")
  public void testOne() {
	  System.out.println("Test 1 in SampleTwo");
  }
  
  @Test(groups = "featureTwo")
  public void testTwo() {
	  System.out.println("Test 2 in SampleTwo");
  }
  
  @Test(groups = "featureThree")
  public void testThree() {
	  System.out.println("Test 3 in SampleTwo");
  }
  
  @Test
  public void testFour() {
	  System.out.println("Test 4 in SampleTwo");
  }
}
