package _junit.interpreter;


import org.junit.Test;

public abstract class Test_Interpreter
{
  
  @Test
  public void test01a()
  {
    String expr = "3 + 7";
    double result = 10.0;
    test( expr, result);
  }
  
  @Test
  public void test01b()
  {
    String expr = "3 - 7";
    double result = -4.0;
    test( expr, result);
  }
  
  @Test
  public void test01c()
  {
    String expr = "3 * 7";
    double result = 21.0;
    test( expr, result);
  }
  
  @Test
  public void test01d()
  {
    String expr = "20 / 8";
    double result = 2.5;
    test( expr, result);
  }
  
  @Test
  public void test02()
  {
    String expr = "3 + 7*2";
    double result = 17.0;
    test( expr, result);
  }
  
  @Test
  public void test03()
  {
    String expr = "3*2 + 7";
    double result = 13.0;
    test( expr, result);
  }
  
  @Test
  public void test04()
  {
    String expr = "3 + 7 + 2 + 1 + 3";
    double result = 16.0;
    test( expr, result);
  }
  
  @Test
  public void test04a()
  {
    String expr = "3+7   +   2+1+3";
    double result = 16.0;
    test( expr, result);
  }
  
  @Test
  public void test05()
  {
    String expr = "3*7/3";
    double result = 7.0;
    test( expr, result);
  }
  
  @Test
  public void test06()
  {
    String expr = "3 + (7-2)";
    double result = 8.0;
    test( expr, result);
  }
  
  @Test
  public void test07()
  {
    String expr = "3*(2+3) - 2*(7-6)";
    double result = 13.0;
    test( expr, result);
  }
  
  @Test
  public void test08()
  {
    String expr = "2*(3 + 2*(7-3)/2 - 1)";
    double result = 12.0;
    test( expr, result);
  }
  
  @Test
  public void test09()
  {
    String expr = "(((3+1)))";
    double result = 4.0;
    test( expr, result);
  }
  
  @Test
  public void test10()
  {
    String expr = "2*(2 + 3*(4 -(2*1)) + 4/2)";
    double result = 20.0;
    test( expr, result);
  }
  
  
  @Test
  public void test11()
  {
    String expr = "(2 + 3)*5";
    double result = 25.0;
    test( expr, result);
  }
  
  @Test
  public void test12()
  {
    String expr = "((2 + 3)*5)";
    double result = 25.0;
    test( expr, result);
  }
  
  @Test
  public void test13()
  {
    String expr = "(2 + 3)*5 + 2 + 2*2";
    double result = 31.0;
    test( expr, result);
  }
  
  @Test
  public void test14()
  {
    String expr = "(8/2)/2";
    double result = 2.0;
    test( expr, result);
  }
  
  @Test
  public void test14a()
  {
    String expr = "8/2/2";
    double result = 2.0;
    test( expr, result);
  }
  
  @Test
  public void test15()
  {
    String expr = "8-2-2";
    double result = 4.0;
    test( expr, result);
  }
  
  abstract protected void test(String expr, double value);
}
