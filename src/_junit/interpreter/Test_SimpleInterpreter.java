package _junit.interpreter;


import org.junit.Assert;

import simple.ExpressionEvaluator;
import tree.utils.Tokenizer;

public class Test_SimpleInterpreter extends Test_Interpreter
{
  protected void test(String expr, double value)
  {
    String[] tokens = Tokenizer.tokenize(expr);   
    try
    {
      double res = ExpressionEvaluator.getValue(tokens);
      Assert.assertEquals(value, res, 0.0000001);
    }
    catch(Exception exce)
    {
      Assert.assertTrue(false);
    }    
  }
}
