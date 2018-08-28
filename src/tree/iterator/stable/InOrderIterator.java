package tree.iterator.stable;


import java.util.List;

import tree.Tree;

/**
 * Die Klasse <code>InOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.stable.AbstractIterator</code>. 
 * 
 * In der Template-Method <code>readTreeContent</code> wird der Baum
 * in <i>in order</i> traversiert. Die ausgelesenen Elemente werden in der
 * internen Liste hinterlegt.
 * 
 * @param <T>
 * @see java.util.Iterator
 * @see tree.iterator.stable.AbstractStableIterator
 * @see Tree
 * 
 * @author Jörg Hettel
 */

public class InOrderIterator<T> extends AbstractStableIterator<T> 
{
	public InOrderIterator(Tree<T> root) 
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
      readTreeContent(left, content );
    }
    
    content.add(node.getElement() );
    
    if( right != null ) 
    {
      
      readTreeContent(right, content );
    }
    
    return;
	}

}
