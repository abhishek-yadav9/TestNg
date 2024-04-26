package parallelscript;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test
  public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test31 in SampleOne..." +id);		  
  }
  @Test
  public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test32 in SampleOne..." +id);		  
  }
  @Test
  public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test33 in SampleOne..." +id);		  
  }
  @Test
  public void testFour() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test34 in SampleOne..." +id);		  
  }
}
