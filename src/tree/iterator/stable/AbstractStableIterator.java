package tree.iterator.stable;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.Tree;


/**
 * Die abstrakte Klasse <code>tree.iterator.stable.AbstractStableIterator</code> 
 * ist die Basisklasse f�r alle Iterator-Implementierungen, die eine stabile
 * Iteration �ber eine <code>Tree</code>-Datenhierarchie erlauben. <br/>
 * Stabil bedeutet, dass der Iterator bei seiner Erzeugung die Datenhierarchie
 * ausliest und intern speichert.  
 * 
 * In der Template-Method <code>readTreeContent</code> wird die Art und Weise
 * der Traversierung festgelegt.
 * 
 * @param <T> Datentyp der Knotenelemente von <code>Tree</code>
 * @see Iterator
 * @see AbstractStableIterator
 * @see Tree
 * 
 * @author J�rg Hettel
 */

public abstract class AbstractStableIterator<T> implements Iterator<T> 
{
	private List< T > content = new ArrayList< T >();
	private Iterator<T> itr = null;
	
	protected AbstractStableIterator(Tree<T> root) 
	{
		super();
		assert( root != null );
		this.readTreeContent(root, content);
		this.itr = this.content.iterator();
	}

	
	@Override
	public boolean hasNext() 
	{
		return this.itr.hasNext();
	}

	@Override
	public T next() 
	{
		return this.itr.next();
	}

	@Override
	public void remove() 
	{
		throw new UnsupportedOperationException();
	}
	
	// Template Method
	abstract protected void readTreeContent(Tree<T> node, List< T > content);
}
