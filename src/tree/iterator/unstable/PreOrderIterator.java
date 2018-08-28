package tree.iterator.unstable;


import tree.Tree;

/**
 * Die Klasse <code>PreOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.unstable.AbstractIterator</code>. 
 * 
 * In der Template-Method <code>getNextElement</code> wird der Baum
 * in <i>pre order</i> traversiert. Besuchte aber noch nicht ausgegebene Elemente 
 * werden in einem Stack hinterlegt. Die Traversierung ist somit nicht "stabil".
 * 
 * @see java.util.Iterator
 * @see tree.iterator.unstable.AbstractUnstableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */
public class PreOrderIterator<E> extends AbstractUnstableIterator<E>
{  
  public PreOrderIterator(Tree<E> root)
  {
    super(root);
    
    if( this.vistitedTreeNodes.empty() )
    {
      this.vistitedTreeNodes.push(this.root);
    }
  }

  protected E getNextElement()
  {
    Tree<E> node = this.vistitedTreeNodes.pop();
    E element = node.getElement();
    
    if( node.getRight() != null )
    {
      Tree<E> right = node.getRight();
      this.vistitedTreeNodes.push(right);
    }
    
    if( node.getLeft() != null )
    {
      Tree<E> left = node.getLeft();
      this.vistitedTreeNodes.push(left);
    }
    
    if( this.vistitedTreeNodes.empty() )
    {
      this.root = null;
    }
    
    return element;
  }
 
}
