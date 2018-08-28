package tree.iterator;

import java.util.Iterator;

import tree.Tree;

/**
 * Die Klasse <code>TreeIteration</code> realisiert eine Factory zur Erzeugung von
 * Iteratoren. 
 * 
 * In der Template-Method <code>getNextElement</code> wird der Baum
 * in <i>in order</i> traversiert. Besuchte aber noch nicht ausgegebene Elemente 
 * werden in einem Stack hinterlegt. Die Traversierung ist somit nicht "stabil".
 * 
 * @see java.util.Iterator
 * @see tree.iterator.unstable.AbstractUnstableIterator
 * @see tree.iterator.stable.AbstractStableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */
public class TreeIteration
{
  /**
   * Unterstützte Iterationsarten.
   *
   */
	public static enum Strategy{ InOrder, PostOrder, PreOrder, LevelOrder, InOrderStable, PostOrderStable, PreOrderStable, LevelOrderStable  };
	
	// Es können keine Objekte erzeugt werden.
	private TreeIteration() 
	{
		super();
	}
	
  /**
   * Liefert ein Iterator-Objekt zurück.
   *
   * @param strategy  Bestimmt die Art des Iterators: <i>stabel</i> oder <i>unstable</i> und die Traversierungsart 
   * @param tree   Parameter für den Baum, der zu traversieren ist
   * @return Iterator<E>
   */
	public static <E> Iterator<E> getIterator(Strategy strategy, Tree<E> tree)
	{
	  // Alterantive Implementierung
	  // Ist damit zu rechnen, dass neue Iteratoren dazukommen, könnte man hier auch
	  // mit einer Map arbeiten und die zu ladenden Klassen z.B. in eine Resource- oder
	  // XML-Datei auslagern.
	  switch( strategy )
	  {
	    case InOrder          : return new tree.iterator.unstable.InOrderIterator<>(tree);
	    case InOrderStable    : return new tree.iterator.stable.InOrderIterator<>(tree);
	    case LevelOrder       : return new tree.iterator.unstable.LevelOrderIterator<>(tree);
	    case LevelOrderStable : return new tree.iterator.stable.LevelOrderIterator<>(tree);
	    case PostOrder        : return new tree.iterator.unstable.PostOrderIterator<>(tree);
	    case PostOrderStable  : return new tree.iterator.stable.PostOrderIterator<>(tree);
	    case PreOrder         : return new tree.iterator.unstable.PreOrderIterator<>(tree);
	    case PreOrderStable   : return new tree.iterator.stable.PreOrderIterator<>(tree); 
	    default               : return new tree.iterator.stable.LevelOrderIterator<>(tree);
	  }
	}

}
