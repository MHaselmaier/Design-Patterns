package demo;

import java.util.Arrays;

import simple.ExpressionEvaluator;
import tree.Tree;
import tree.binary.INode;
import tree.binary.visitor.OpCounterVisitor;
import tree.interpreter.ExpressionPrecedenceParser;
import tree.iterator.TreeIteration.Strategy;
import tree.utils.Tokenizer;

public class Main
{

  public static void main(String[] args)
  {
    String expr = "-7 + 3^ 3 + 2*(7 - 3) + 6/(4 - 1) + 0.1 + (-30.1)";

    System.out.println("Auswertung von: " + expr );
    System.out.println();

    String[] tokens = Tokenizer.tokenize(expr);
    System.out.println(Arrays.toString(tokens));
    System.out.println("Variante 1");
    System.out.println("Ergebnis: " + ExpressionEvaluator.getValue(tokens) );
    System.out.println();

    ExpressionPrecedenceParser parser = new ExpressionPrecedenceParser(tokens);
    INode<String> root = parser.getExpressionTree();
    Tree<String> tree = new Tree<>(root);

    System.out.println("Variante 2");
    System.out.println("Ergebnis: " + tree.evaluate() );
    tree.configIteration(Strategy.InOrder);
    System.out.print("In order  (unstable Iterator)  :   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();
    tree.configIteration(Strategy.InOrderStable);
    System.out.print("In order (stable Iterator)     :   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    tree.configIteration(Strategy.PreOrder);
    System.out.print("Pre order  (unstable Iterator) :   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    tree.configIteration(Strategy.PreOrderStable);
    System.out.print("Pre order (stable Iterator)    :   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    tree.configIteration(Strategy.PostOrder);
    System.out.print("Post order  (unstable Iterator):   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    tree.configIteration(Strategy.PostOrderStable);
    System.out.print("Post order (stable Iterator)   :   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    tree.configIteration(Strategy.LevelOrder);
    System.out.print("Level order (unstable Iterator):   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    tree.configIteration(Strategy.LevelOrderStable);
    System.out.print("Level order (stable Iterator)  :   ");
    for( String str : tree )
    {
      System.out.print( str );
    }
    System.out.println();

    OpCounterVisitor<String> visitor = new OpCounterVisitor<>();
    root.accept(visitor);
    System.out.println("Anzahl der Operatoren: " + visitor.getOpCount() );
  }

}
