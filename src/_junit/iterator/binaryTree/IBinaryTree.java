package _junit.iterator.binaryTree;

import tree.Tree;


public interface IBinaryTree
{
  public Tree<String> getTree();
  public String getInOrder();
  public String getLevelOrder();
  public String getPostOrder();
  public String getPreOrder();
}
