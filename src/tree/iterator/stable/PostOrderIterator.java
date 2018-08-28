package tree.iterator.stable;

import java.util.List;

import tree.Tree;


/**
 * Die Klasse <code>PostOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.stable.AbstractIterator</code>. 
 * 
 * In der Template-Method <code>readTreeContent</code> wird der Baum
 * in <i>post order</i> traversiert. Die ausgelesenen Elemente werden in der
 * internen Liste hinterlegt.
 * 
 * @param <T>
 * @see java.util.Iterator
 * @see tree.iterator.stable.AbstractStableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */ 
public class PostOrderIterator<T> extends AbstractStableIterator<T> 
{
	public PostOrderIterator(Tree<T> root) 
	{
		super(root);
	}

	
	protected void readTreeContent(Tree<T> node, List< T > content)
	{	
		if( node == null ) return;
		
    Tree<T> left  = node.getLeft();
    Tree<T> right = node.getRight();
		
		if( left != null )
		{
		  readTreeContent(left, content  );
		}
		
		if( right != null )
		{
		  readTreeContent(right, content  );
			
		}
		
		content.add( node.getElement() );
		
		return;
	}

}
