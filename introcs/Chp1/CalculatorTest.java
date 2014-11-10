import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CalculatorTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testAddition() {
    Calculator calc = new Calculator();
    // 3 + 4 = 7
    int expected = 7;
    int actual = calc.add(3, 4);
    assertEquals("adding 3 and 4", expected, actual);
  }
  
  public void testDivision() {
    Calculator calc = new Calculator();
    //Divide by 0 should not work
    try {
      calc.divide(2, 0);
      fail("Should have thrown an exception!");
    }
    catch (ArithmeticException e) {
      // Good, that's what we expect
      System.out.println("Threw an Arithmetic Exception");
    }
  }
}
