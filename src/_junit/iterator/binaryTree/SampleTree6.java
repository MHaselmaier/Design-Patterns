package _junit.iterator.binaryTree;


import tree.Tree;
import tree.binary.BinaryNode;
import tree.binary.INode;
import tree.binary.LeafNode;

public  class SampleTree6 implements IBinaryTree
{
  @Override
  public Tree<String> getTree()
  {
    // Ausdruck: 3+5+7+8;
    // 
    //        +
    //       / \
    //      +   8
    //     / \    
    //    +   7   
    //   / \     
    //  3   5   
    //
    INode<String> n1    = new LeafNode<String>("3");
    INode<String> n2    = new LeafNode<String>("5");
    INode<String> n3    = new LeafNode<String>("7");
    INode<String> n4    = new LeafNode<String>("8");
    
    INode<String> b1 = new BinaryNode<String>("+",n1, n2);
    INode<String> b2 = new BinaryNode<String>("+", b1, n3);
    INode<String> root = new BinaryNode<String>("+", b2, n4);
    
    Tree<String> tree = new Tree<>(root);
    
    return tree;
  }

  @Override
  public String getInOrder()
  {
    return "3+5+7+8";
  }

  @Override
  public String getLevelOrder()
  {
    return "++8+735";
  }

  @Override
  public String getPostOrder()
  {
    return "35+7+8+";
  }

  @Override
  public String getPreOrder()
  {
    return "+++3578";
  } 
 
}
