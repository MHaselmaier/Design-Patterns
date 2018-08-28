package tree.iterator.stable;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



import tree.Tree;

/**
 * Die Klasse <code>LevelOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.stable.AbstractIterator</code>. 
 * 
 * In der Template-Method <code>readTreeContent</code> wird der Baum
 * in <i>level order</i> traversiert. Die ausgelesenen Elemente werden in der
 * internen Liste hinterlegt.
 * 
 * @param <T>
 * @see java.util.Iterator
 * @see tree.iterator.stable.AbstractStableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */

public class LevelOrderIterator<T> extends AbstractStableIterator<T> 
{
	public LevelOrderIterator(Tree<T> root) 
	{
		super(root);
	}
	
	protected void readTreeContent(Tree<T> node, List< T > content)
	{	
		Queue<Tree<T>> queue = new LinkedList<Tree<T>>();	
		queue.add( node );
		
		while( queue.isEmpty() == false )
		{
			Tree<T> n = queue.remove();

			if( n.getLeft() != null )
				queue.add( n.getLeft() );
			if( n.getRight() != null )
				queue.add( n.getRight() );
						
			content.add( n.getElement() );
		}
	}

}
