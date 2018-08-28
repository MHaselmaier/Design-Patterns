package _junit.iterator;


import tree.Tree;
import tree.iterator.TreeIteration.Strategy;
import _junit.iterator.binaryTree.IBinaryTree;

public class Test_PostOrderIteratorStable extends Test__Iterator
{
  protected Strategy getIteratorStrategy(Tree<String> tree)
  {
    return Strategy.PostOrderStable;
  }
  
  protected String getIterationResult(IBinaryTree treeBuilder)
  {
    return treeBuilder.getPostOrder();
  }
}
