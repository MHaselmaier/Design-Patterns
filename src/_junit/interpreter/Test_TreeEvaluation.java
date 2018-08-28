package _junit.interpreter;


import org.junit.Assert;



import tree.Tree;
import tree.binary.INode;
import tree.interpreter.ExpressionPrecedenceParser;
import tree.utils.Tokenizer;

public class Test_TreeEvaluation extends Test_Interpreter
{
  
 
  
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
    catch(Exception exce)
    {
      Assert.assertTrue(false);
    }    
  }

}
