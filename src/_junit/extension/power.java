package _junit.extension;

import org.junit.Assert;
import org.junit.Test;

import simple.ExpressionEvaluator;
import tree.Tree;
import tree.binary.INode;
import tree.interpreter.ExpressionPrecedenceParser;
import tree.utils.Tokenizer;

public class power
{
	@Test
	public void test01()
	{
		String expr = "2 ^ 3";
		double result = 8.0;
		test(expr, result);
	}
	
	@Test
	public void test02()
	{
		String expr = "1 + 2^3";
		double result = 9.0;
		test(expr, result);
	}
	
	@Test
	public void test03()
	{
		String expr = "2^3 + 1";
		double result = 9.0;
		test(expr, result);
	}
	
	@Test
	public void test04()
	{
	    String expr = "2 ^ 3 ^ 1 ^ 2";
	    double result = 64.0;
	    test( expr, result);
	}
	
	@Test
	public void test05()
	{
	    String expr = "2^3   ^    1^2";
	    double result = 64.0;
	    test( expr, result);
	}
	
	@Test
	public void test06()
	{
	    String expr = "2^3/4";
	    double result = 2.0;
	    test( expr, result);
	}
	
	@Test
	public void test07()
	{
	    String expr = "3 ^ (4-2)";
	    double result = 9.0;
	    test( expr, result);
	}
	
	@Test
	public void test08()
	{
	    String expr = "2 ^ (3 ^ (4-2) - 2 ^ 2)";
	    double result = 32.0;
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