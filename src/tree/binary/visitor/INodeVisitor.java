package tree.binary.visitor;

import tree.binary.BinaryNode;
import tree.binary.LeafNode;

/**
 * Das Interface <source>INodeVisitor</source> ist die Schnittstelle f�r
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
	 * Besuchsmethode f�r <source>BinaryNode</source>
	 * 
	 * @param node
	 */
	public void visitNode(BinaryNode<T> node);
	
	 /**
   * Besuchsmethode f�r <source>LeafNode</source>
   * 
   * @param node
   */
	public void visitNode(LeafNode<T> node);
}
