package tree.iterator.unstable;


import tree.Tree;

/**
 * Die Klasse <code>InOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.unstable.AbstractIterator</code>. 
 * 
 * In der Template-Method <code>getNextElement</code> wird der Baum
 * in <i>in order</i> traversiert. Besuchte aber noch nicht ausgegebene Elemente 
 * werden in einem Stack hinterlegt. Die Traversierung ist somit nicht "stabil".
 * 
 * @see java.util.Iterator
 * @see tree.iterator.unstable.AbstractUnstableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */

public class InOrderIterator<E> extends AbstractUnstableIterator<E>
{  
  public InOrderIterator(Tree<E> root)
  {
    super(root);
    
    if( this.vistitedTreeNodes.empty() )
    {
      this.pushAllLeftNodesOnStack(this.root);
    }
  }

  protected E getNextElement()
  {
    Tree<E> node = this.vistitedTreeNodes.pop();
    E element = node.getElement();
    
    if( node.getRight() != null )
    {
      Tree<E> right = node.getRight();
      this.pushAllLeftNodesOnStack(right);
    }
    
    if( this.vistitedTreeNodes.empty() )
    {
      this.root = null;
    }
    
    return element;
  }
  
  private void pushAllLeftNodesOnStack(Tree<E> node)
  {
    if( node != null )
    {
      this.vistitedTreeNodes.push(node);
      this.pushAllLeftNodesOnStack(node.getLeft());
    }
  }
}
