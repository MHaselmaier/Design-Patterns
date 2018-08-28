package tree.binary;

import tree.binary.visitor.INodeVisitor;



/**
 * Das Interface <code>INode</code> bildet den Basistyp für die
 * Konstruktion eines Binärbaums. 
 *
 * <p> Implementierende Klasse ist <tt>ANode</tt> </p>
 * @param <E>
 * @see ANode
 * @see BinaryNode
 * @see LeafNode 
 * 
 * @author Jörg Hettel
 */
public interface INode<E>
{
  /**
   * Liefert das Datenelement des Kontens zurück.
   *
   * @return Datenelement
   */
    E  getElement();
    
    /**
     * Liefert den linken Kindknoten.
     *
     * @return Knoten oder <tt>null</tt> falls kein Kindknoten vorhanden ist
     */
    INode<E> getLeft();
    
    /**
     * Liefert den rechten Kindknoten.
     *
     * @return Knoten <tt>null</tt> falls kein Kindknoten vorhanden ist
     */
    INode<E> getRight();
    
    /**
     * <i>Regsitrierungsmethode</i> für einen Visitor, der
     * die Datenstruktur traversieren möchte
     * 
     * @see tree.binary.visitor.INodeVisitor
     */
    public void accept(INodeVisitor<E> visitor);
}
