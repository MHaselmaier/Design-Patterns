package _junit.interpreter;


import org.junit.Assert;


import tree.binary.INode;
import tree.binary.LeafNode;
import tree.interpreter.ExpressionPrecedenceParser;
import tree.utils.Tokenizer;

public class Test_TreeInterpreter extends Test_Interpreter
{
  
 
  
  protected void test(String expr, double value)
  {
    String[] tokens = Tokenizer.tokenize(expr);
    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    
    INode<String> root = parser.getExpressionTree();
    
    try
    {
      double res = evaluate(root);
      Assert.assertEquals(value, res, 0.0000001);
    }
    catch(Exception exce)
    {
      Assert.assertTrue(false);
    }    
  }
  
  private double evaluate(INode<String> root) throws Exception
  {   
    if( root instanceof LeafNode )
    { 
      String element = root.getElement();
      return Double.parseDouble(element);
    }
    
    double left = evaluate( root.getLeft() );
    double right = evaluate( root.getRight() );
    if( root.getElement().equals("*") )
    {
      return left*right;
    }
    else if( root.getElement().equals("/") )
    {
      return left/right;
    }
    else if( root.getElement().equals("+") )
    {
      return left+right;
    }
    else if( root.getElement().equals("-") )
    {
      return left-right;
    }
    else
    {
      throw new Exception("Falsches Baumformat");
    }
  }
 
}
