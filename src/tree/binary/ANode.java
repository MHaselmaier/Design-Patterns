package tree.binary;



/**
 * Die abstrakte Basisklasse <code>INode</code> verwaltet
 * den Knoteninhalt.
 *
 * <p>Implementiert das Interface <tt>INode</tt> </p>
 * <p> Abgeleitete Klassen sind <tt>BinaryNode</tt> und  <tt>LeafNode</tt></p>
 * @param <E>
 * @see BinaryNode
 * @see LeafNode
 * 
 * @author Jörg Hettel
 */

public abstract class ANode<E> implements INode<E>
{
    private E element;
    
    protected ANode(E element)
    {
        super();
        this.element = element;
    }
    
    
    @Override
    public E getElement()
    {
        return this.element;
    }
}
