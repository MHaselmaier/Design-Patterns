package tree.binary.visitor;

import tree.binary.BinaryNode;
import tree.binary.LeafNode;

/**
 * Der <source>OpCounterVisitor</source> z�hlt die Anzahl der Operatoren
 * bzw. Bin�rKnoten.
 * 
 * Verwendungsbeispiel:
 * <pre>
 *    INode<String>  root = ...;
 *    
 *    OpCounterVisitor<E> visitor = new OpCounterVisitor<>();
 *    root.accept(visitor);
 *    double anzahlOperatoren = visitor.getOpCount();
 * </pre>
 * 
 * 
 * @author Hettel
 *
 * @param <T>
 */
public class OpCounterVisitor<T> implements INodeVisitor<T> 
{
	private int counter = 0;
	
	public OpCounterVisitor() 
	{
		super();
	}

	/**
	 * Liefert die Anzahl der Operatoren bzw. Bin�rknoten zur�ck
	 * 
	 * @return Anzahl
	 */
	public int getOpCount()
	{
		return this.counter;
	}

	@Override
	public void visitNode(BinaryNode<T> node) 
	{
	  this.counter++;
		node.getLeft().accept(this);
		node.getRight().accept(this);
	}

	@Override
	public void visitNode(LeafNode<T> node) 
	{
		return;
	}
}
