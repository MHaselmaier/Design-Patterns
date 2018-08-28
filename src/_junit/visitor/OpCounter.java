package _junit.visitor;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.binary.INode;
import tree.binary.visitor.OpCounterVisitor;
import tree.interpreter.ExpressionPrecedenceParser;
import tree.utils.Tokenizer;

public class OpCounter
{
  @Test
  public void test1()
  {
    String expr = "3 + 4*2 - 4/2";

    String[] tokens = Tokenizer.tokenize(expr);
    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    INode<String> root = parser.getExpressionTree();

    OpCounterVisitor<String> visitor = new OpCounterVisitor<>();
    root.accept(visitor);

    int num = visitor.getOpCount();

    assertEquals(4, num);
  }

  @Test
  public void test2()
  {
    String expr = "3 + 4*(5-2)";

    String[] tokens = Tokenizer.tokenize(expr);
    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    INode<String> root = parser.getExpressionTree();

    OpCounterVisitor<String> visitor = new OpCounterVisitor<>();
    root.accept(visitor);

    int num = visitor.getOpCount();

    assertEquals(3, num);
  }

  @Test
  public void test3()
  {
    String expr = "3 + 4*(5-2) + (3-2)";

    String[] tokens = Tokenizer.tokenize(expr);
    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    INode<String> root = parser.getExpressionTree();

    OpCounterVisitor<String> visitor = new OpCounterVisitor<>();
    root.accept(visitor);

    int num = visitor.getOpCount();

    assertEquals(5, num);
  }

  @Test
  public void test4()
  {
    String expr = "3 + (4*(5-2)) - (3-2)";

    String[] tokens = Tokenizer.tokenize(expr);
    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    INode<String> root = parser.getExpressionTree();

    OpCounterVisitor<String> visitor = new OpCounterVisitor<>();
    root.accept(visitor);

    int num = visitor.getOpCount();

    assertEquals(5, num);
  }

  @Test
  public void test5()
  {
    String expr = "2*2*3 - 4/2/2";

    String[] tokens = Tokenizer.tokenize(expr);
    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    INode<String> root = parser.getExpressionTree();

    OpCounterVisitor<String> visitor = new OpCounterVisitor<>();
    root.accept(visitor);

    int num = visitor.getOpCount();

    assertEquals(5, num);
  }
}
