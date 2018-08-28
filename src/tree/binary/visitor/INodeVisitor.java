package tree.binary.visitor;

import tree.binary.BinaryNode;
import tree.binary.LeafNode;

/**
 * Das Interface <source>INodeVisitor</source> ist die Schnittstelle für
 * ein Visitor-Pattern, das auf die <source>INode</source>-Hierarchie angewendet
 * worden ist.
 * 
 * @author Hettel
 *
 * @see INode
 * @see BinaryNode
 * @see LeafNode
 * @param <T>
 */
public interface INodeVisitor<T> 
{
	/**
	 * Besuchsmethode für <source>BinaryNode</source>
	 * 
	 * @param node
	 */
	public void visitNode(BinaryNode<T> node);
	
	 /**
   * Besuchsmethode für <source>LeafNode</source>
   * 
   * @param node
   */
	public void visitNode(LeafNode<T> node);
}
