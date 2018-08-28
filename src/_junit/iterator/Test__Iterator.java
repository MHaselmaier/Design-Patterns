package _junit.iterator;


import static org.junit.Assert.assertTrue;


import org.junit.Test;

import tree.Tree;
import tree.iterator.TreeIteration.Strategy;
import _junit.iterator.binaryTree.IBinaryTree;
import _junit.iterator.binaryTree.SampleTree1;
import _junit.iterator.binaryTree.SampleTree2;
import _junit.iterator.binaryTree.SampleTree3;
import _junit.iterator.binaryTree.SampleTree4;
import _junit.iterator.binaryTree.SampleTree5;
import _junit.iterator.binaryTree.SampleTree6;
import _junit.iterator.binaryTree.SampleTree7;

public abstract class Test__Iterator
{
  abstract protected Strategy getIteratorStrategy(Tree<String> tree);
  abstract protected String getIterationResult(IBinaryTree treeBuilder);

   
  private void test(IBinaryTree treeBuilder)
  {
    Tree<String> tree = treeBuilder.getTree();
    tree.configIteration( getIteratorStrategy(tree) );  
    StringBuilder strBuilder = new StringBuilder();

    for( String s : tree )
    {
      strBuilder.append(s);
    }
    
    String str = strBuilder.toString();
    
    assertTrue( str.equals( getIterationResult(treeBuilder) ) );
  }
  
  
  @Test
  public void testTree1()
  {
    test( new SampleTree1() );
  }
  
  @Test
  public void testTree2()
  {
    test( new SampleTree2() );
  }
  
  @Test
  public void testTree3()
  {
    test( new SampleTree3() );
  }
  
  @Test
  public void testTree4()
  {
    test( new SampleTree4() );
  }
  
  @Test
  public void testTree5()
  {
    test( new SampleTree5() );
  }
  
  @Test
  public void testTree6()
  {
    test( new SampleTree6() );
  }
  
  @Test
  public void testTree7()
  {
    test( new SampleTree7() );
  }
  
}
