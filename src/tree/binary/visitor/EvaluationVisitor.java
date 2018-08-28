package tree.binary.visitor;

import java.util.Stack;

import tree.binary.BinaryNode;
import tree.binary.LeafNode;


/**
 * Der <source>EvaluationVisitor</source> führt eine arithmetische Auswertung
 * eines Syntaxbaums durch. Der Vistor geht dabei selbst rekursiv vor, d.h.
 * traversiert selbständig über die Baumstruktur.
 * 
 * Verwendungsbeispiel:
 * <pre>
 *    INode<String>  root = ...;
 *    
 *    EvaluationVisitor<E> visitor = new EvaluationVisitor<>();
 *    root.accept(visitor);
 *    double ergebnis = visitor.getResult();
 * </pre>
 * 
 * Man beachte, dass die zugrunde liegende Hierarchie mit <source>String</source>
 * typisiert sein muss!
 * 
 * @author Hettel
 *
 * @param <T>
 */
public class EvaluationVisitor<E> implements INodeVisitor<E> 
{
	private Stack<Double> stack = new Stack<Double>();
	
	public EvaluationVisitor() 
	{
		super();
	}

	/**
	 * Liefert den arithmetischen Wert des Syntaxbaums
	 * 
	 * @return Wert
	 */
	public double getResult()
	{
		return this.stack.get(0).doubleValue();
	}
	

	@Override
	public void visitNode(BinaryNode<E> node) 
	{
	  String operator = checkAndConvert( node.getElement() );
	  
		node.getLeft().accept(this);
		node.getRight().accept(this);
		
		double i1 = this.stack.pop().doubleValue();
    double i2 = this.stack.pop().doubleValue();
		
    	if( operator.equals("^") == true)
    	{
    		this.stack.push(  new Double(Math.pow(i2, i1)) );
    	}
    	else if( operator.equals("*") == true )
		{
			this.stack.push(  new Double( i1*i2 ) );
		}
		else if( operator.equals("+") == true )
		{
			this.stack.push(  new Double( i1+i2 ) );
		}
		else if( operator.equals("-") == true )
		{
			this.stack.push(  new Double( i2-i1 ) );
		}
		else if( operator.equals("/") == true )
		{
			this.stack.push(  new Double( i2/i1 ) );
		}
	}


	@Override
	public void visitNode(LeafNode<E> node) 
	{
		String element = checkAndConvert( node.getElement() );
		Double value = Double.parseDouble(element);
		
		this.stack.push( value );
	}
	
	private String checkAndConvert(Object element)
	{
	  if( element instanceof String )
	    return (String) element;
	  else
	    throw new UnsupportedOperationException("Visitor: "  + this.getClass().getName() + " not applicable!"); 
	}
}
