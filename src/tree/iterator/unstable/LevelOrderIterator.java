package tree.iterator.unstable;


import java.util.LinkedList;
import java.util.Queue;

import tree.Tree;

/**
 * Die Klasse <code>LevelOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.unstable.AbstractIterator</code>. 
 * 
 * In der Template-Method <code>getNextElement</code> wird der Baum
 * in <i>level order</i> traversiert. Besuchte aber noch nicht ausgegebene Elemente 
 * werden in einem Stack hinterlegt. Die Traversierung ist somit nicht "stabil".
 * 
 * @see java.util.Iterator
 * @see tree.iterator.unstable.AbstractUnstableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */
public class LevelOrderIterator<E> extends AbstractUnstableIterator<E>
{  
  public Queue<Tree<E>> queue = new LinkedList<Tree<E>>();  
  
  public LevelOrderIterator(Tree<E> root)
  {
    super(root);
    this.queue.add(root);
  }
  
  @Override
  public boolean hasNext()
  {
    return (this.queue.isEmpty() == false );
  }

  @Override
  protected E getNextElement()
  {
    Tree<E> node = this.queue.poll();
    E element = node.getElement();
    
    if( node.getLeft() != null )
    {
      Tree<E> left = node.getLeft();
      this.queue.add(left);
    }
    
    if( node.getRight() != null )
    {
      Tree<E> right = node.getRight();
      this.queue.add(right);
    }
    
    return element;
  }
 
}
