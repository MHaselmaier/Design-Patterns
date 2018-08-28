package tree.binary;

import tree.binary.visitor.INodeVisitor;

/**
 * Repäsentiert einen Blattknoten eines Binärbaums
 * 
 * @author Hettel
 *
 * @param <E>
 * @see ANode
 * @see INode
 */
public class LeafNode<E> extends ANode<E>
{
    public LeafNode(E element)
    {
        super(element);
    }

    @Override
    public INode<E> getLeft()
    {
      return null;
    }

    @Override
    public INode<E> getRight()
    {
      return null;
    }
    
    @Override
    public void accept(INodeVisitor<E> visitor) 
    {
      visitor.visitNode(this);  
    }
}
