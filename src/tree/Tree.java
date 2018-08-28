package tree;

import java.util.Iterator;

import tree.binary.INode;
import tree.binary.visitor.EvaluationVisitor;
import tree.iterator.TreeIteration;
import tree.iterator.TreeIteration.Strategy;

/**
 * Die Klasse <code>Tree</code> bildet eine <i>Bridge</i> zur einer konkreten
 * Implementierung einer Hierarchie. Die Klasse benutzt intern nur das Interface
 * <code>INode</code>. Nach außen sind nur der <code>Tree</code>-Typ und
 * der generische Datengegeben <code>E<code> sichtbar, so dass die
 * Implementierung der Hierarchie dem Benutzter nicht bekannt ist und
 * gegebenenfalls ausgetaucht werden kann.
 * 
 * Die Klasse <code>Tree</code> implementiert das <code>Iterable</code>-Interface.
 * Dadurch ist z.B. eine Traversierung der Hierarchie durch die Java-Standardmechanismus
 * möglich.
 * 
 * Beispiele
 * <pre>
 *    Tree<String>  tree = ...;
 *    for( Sring str : tree )
 *    {
 *        System.out.println( str );
 *    }
 * </pre>
 * 
 * @see INode
 * @see java.lang.Iterable
 * 
 * @author Jörg Hettel
 */

public class Tree<E> implements Iterable<E>
{
  private INode<E> node = null;
  private Iterator<E> iterator = null;

  public Tree(INode<E> node)
  {
    super();
    assert( node != null );
    this.node = node;
    this.configIteration(Strategy.InOrder);
  }

  /**
   * Liefert das Datenelement des Kontens zurück.
   * 
   * @return Datenelement
   */
  public E getElement()
  {
    return node.getElement();
  }

  /**
   * Liefert den linken Kindknoten.
   *
   * @return Knoten oder <tt>null</tt> falls kein Kindknoten vorhanden ist
   */
  public Tree<E> getLeft()
  {
    INode<E> left = this.node.getLeft();
    if (left != null)
    {
      return new Tree<E>(this.node.getLeft());
    }
    else
    {
      return null;
    }
  }

  /**
   * Liefert den rechten Kindknoten.
   *
   * @return Knoten <tt>null</tt> falls kein Kindknoten vorhanden ist
   */
  public Tree<E> getRight()
  {
    INode<E> right = this.node.getRight();
    if (right != null)
    {
      return new Tree<E>(this.node.getRight());
    }
    else
    {
      return null;
    }
  }

  public void configIteration(Strategy iterationStrategy)
  {
    this.iterator = TreeIteration.getIterator(iterationStrategy, this);
  }

  /**
   * Factory-Method für einen Iterator. Der Iterator implementiert das
   * <source>java.util.Iterator<source> Interface
   * 
   * @see java.util.Iterator
   * @return Iterator
   */
  @Override
  public Iterator<E> iterator()
  {
    return this.iterator;
  }
  
  
  /**
   * Die Methode Evaluiert den Baum mit Hilfe eines <source>EvaluationVisitors</source>
   * 
   * @see EvaluationVisitor
   * @return Arithmetischer Wert
   */
  public double evaluate()
  {
    EvaluationVisitor<E> visitor = new EvaluationVisitor<>();
    
    this.node.accept(visitor);
    
    return visitor.getResult();
  }
}
