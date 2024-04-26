package parallelscript;

import org.testng.annotations.Test;

public class SampleFourTest {
  @Test
  public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test41 in SampleOne..." +id);		  
  }
  @Test
  public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test42 in SampleOne..." +id);		  
  }
  @Test
  public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test43 in SampleOne..." +id);		  
  }
  @Test
  public void testFour() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test44 in SampleOne..." +id);		  
  }
}
