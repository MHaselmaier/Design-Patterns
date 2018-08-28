package tree.binary;

import tree.binary.visitor.INodeVisitor;


/**
 * Repäsentiert einen inneren Knoten eines Binärbaums
 * 
 * @author Hettel
 *
 * @param <E>
 * @see ANode
 * @see INode
 */
public class BinaryNode<E> extends ANode<E>
{
  private INode<E> left;
  private INode<E> right;

  public BinaryNode(E element, INode<E> left, INode<E> right)
  {
    super(element);
    this.left = left;
    this.right = right;
  }
  
  @Override
  public INode<E> getLeft()
  {
    return this.left;
  }

  @Override
  public INode<E> getRight()
  {
    return this.right;
  }  
  
  @Override
  public void accept(INodeVisitor<E> visitor)
  {
    visitor.visitNode(this);
  }

}
