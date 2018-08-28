package _junit.extension;

import org.junit.Assert;
import org.junit.Test;

import simple.ExpressionEvaluator;
import tree.Tree;
import tree.binary.INode;
import tree.interpreter.ExpressionPrecedenceParser;
import tree.utils.Tokenizer;

public class algebraicsign
{
	@Test
	public void test01a()
	{
	    String expr = "-3 + 7.5";
	    double result = 4.5;
	    test( expr, result);
	}
	  
	@Test
	public void test01b()
	{
	    String expr = "+3.3 - -7";
	    double result = 10.3;
	    test( expr, result);
	}
	  
	@Test
	public void test01c()
	{
	    String expr = "3 * -7.3";
	    double result = -21.9;
	    test( expr, result);
	}
	  
	@Test
	public void test01d()
	{
	    String expr = "-4.25 / 0.25";
	    double result = -17;
	    test( expr, result);
	}
	  
	@Test
	public void test02()
	{
	    String expr = "3.1 + -7.2*-2";
	    double result = 17.5;
	    test( expr, result);
	}
	  
	@Test
	public void test03()
	{
	    String expr = "3.1*+2.6 + -7";
	    double result = 1.06;
	    test( expr, result);
	}
	  
	@Test
	public void test04()
	{
	    String expr = "-3.5 + +7.4 + -2.05 + +1.025 + -3.005";
	    double result = -0.13;
	    test( expr, result);
	}
	  
	@Test
	public void test04a()
	{
	    String expr = "-3.5++7.4   +-   2.05++1.025+-3.005";
	    double result = -0.13;
	    test( expr, result);
	}
	  
	@Test
	public void test05()
	{
	    String expr = "-3.5*7.2/-3.5";
	    double result = 7.2;
	    test( expr, result);
	}
	  
	@Test
	public void test06()
	{
	    String expr = "-3.3 + (+7.4-2.3)";
	    double result = 1.8;
	    test( expr, result);
	}
	  
	@Test
	public void test07()
	{
	    String expr = "-3.1*(2+3.4) - 2*(-7.2-6)";
	    double result = 9.66;
	    test( expr, result);
	}
	  
	protected void test(String expr, double value)
	{
		String[] tokens = Tokenizer.tokenize(expr);
		ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);

		INode<String> root = parser.getExpressionTree();

		Tree<String> tree = new Tree<>(root);

		try
		{
			double res = tree.evaluate();
			Assert.assertEquals(value, res, 0.0000001);
		}
		catch (Exception exce)
		{
			Assert.assertTrue(false);
		}

		try
		{
			Assert.assertEquals(value, ExpressionEvaluator.getValue(tokens), 0.0000001);
		}
		catch (Exception exce)
		{
			Assert.assertTrue(false);
		}
	}
}
