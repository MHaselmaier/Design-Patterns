package _junit.iterator.binaryTree;


import tree.Tree;
import tree.binary.BinaryNode;
import tree.binary.INode;
import tree.binary.LeafNode;

public  class SampleTree3 implements IBinaryTree
{
  @Override
  public Tree<String> getTree()
  {
    // Ausdruck: (3 + 4*2) + 5*(7 - 2);
    //
    //         +
    //       /   \
    //      /     \
    //     /       \
    //    +         *   
    //   / \       / \
    //  3   *     5   -
    //     / \       / \
    //    4   2     7   2
    //
    INode<String> n1    = new LeafNode<String>("3");
    INode<String> n2    = new LeafNode<String>("4");
    INode<String> n3    = new LeafNode<String>("2");
    INode<String> n4    = new LeafNode<String>("5");
    INode<String> n5    = new LeafNode<String>("7");
    INode<String> n6    = new LeafNode<String>("2");
    
    INode<String> b1 = new BinaryNode<String>("*",n2, n3);   // 4*2
    INode<String> b2 = new BinaryNode<String>("+",n1, b1);   // 3 + 4*2
    
    INode<String> b3 = new BinaryNode<String>("-",n5, n6);   // 7-2
    INode<String> b4 = new BinaryNode<String>("*",n4, b3);   // 3 + 4*2
    
    INode<String> root = new BinaryNode<String>("+", b2, b4);
    
    Tree<String> tree = new Tree<>(root);
    
    return tree;
  }

  @Override
  public String getInOrder()
  {
    return "3+4*2+5*7-2";
  }

  @Override
  public String getLevelOrder()
  {
    return "++*3*5-4272";
  }

  @Override
  public String getPostOrder()
  {
    return "342*+572-*+";
  }

  @Override
  public String getPreOrder()
  {
    return "++3*42*5-72";
  } 
 
}
