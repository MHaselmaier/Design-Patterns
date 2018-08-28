package _junit.iterator.binaryTree;


import tree.Tree;
import tree.binary.BinaryNode;
import tree.binary.INode;
import tree.binary.LeafNode;

public  class SampleTree1 implements IBinaryTree
{
  @Override
  public Tree<String> getTree()
  {
    // Ausdruck: 3 + 5;
    //
    //    +      
    //   / \     
    //  3   5   
    //
    INode<String> l    = new LeafNode<String>("3");
    INode<String> r    = new LeafNode<String>("5");
    INode<String> root = new BinaryNode<String>("+",l, r);
    
    Tree<String> tree = new Tree<>(root);
    
    return tree;
  }

  @Override
  public String getInOrder()
  {
    return "3+5";
  }

  @Override
  public String getLevelOrder()
  {
    return "+35";
  }

  @Override
  public String getPostOrder()
  {
    return "35+";
  }

  @Override
  public String getPreOrder()
  {
    return "+35";
  } 
 
}
