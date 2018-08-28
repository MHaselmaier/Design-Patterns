package _junit.iterator;


import tree.Tree;
import tree.iterator.TreeIteration.Strategy;
import _junit.iterator.binaryTree.IBinaryTree;

public class Test_InOrderIteratorUnStable extends Test__Iterator
{
  protected Strategy getIteratorStrategy(Tree<String> tree)
  {
    return Strategy.InOrder;
  }
  
  protected String getIterationResult(IBinaryTree treeBuilder)
  {
    return treeBuilder.getInOrder();
  }
}
