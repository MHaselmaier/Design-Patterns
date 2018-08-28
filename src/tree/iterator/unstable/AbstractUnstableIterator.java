package tree.iterator.unstable;

import java.util.Iterator;
import java.util.Stack;

import tree.Tree;

/**
 * Die abstrakte Klasse <code>tree.iterator.unstable.AbstractUnstableIterator</code> 
 * ist die Basisklasse für alle Iterator-Implementierungen, die eine nicht-stabile
 * Iteration über eine <code>Tree</code>-Datenhierarchie erlauben. <br/>
 * Nicht-Stabil bedeutet, dass der Iterator keine Kopie der Datenstruktur erzeugt,
 * sonder möglichst immer direkt auf der Datenhierarchie traversiert.  
 * 
 * In der Template-Method <code>getNextElement</code> wird die Art und Weise
 * der Traversierung festgelegt.
 * 
 * @param <E>
 * @see java.util.Iterator
 * @see tree.iterator.stable.AbstractStableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */

public abstract class AbstractUnstableIterator<E> implements Iterator<E>
{
  protected Tree<E> root = null;
  protected Stack<Tree<E>> vistitedTreeNodes = new Stack<>(); 
  
  protected AbstractUnstableIterator(Tree<E> root)
  {
    super();
    assert( root != null );
    this.root = root;
  }

  @Override
  public boolean hasNext()
  {
    return (root != null);
  }

  @Override
  public E next()
  {
    return getNextElement();
  }

  @Override
  public void remove()
  {
    throw new UnsupportedOperationException("remove not supported");
  }
  
  // Template Method
  protected abstract E getNextElement();
}
