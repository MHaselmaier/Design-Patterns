package tree.iterator.unstable;


import java.util.Stack;

import tree.Tree;

/**
 * Die Klasse <code>PostOrderIterator</code> ist eine konkrete Implementierung
 * von <code>tree.iterator.unstable.AbstractIterator</code>.
 *
 * In der Template-Method <code>getNextElement</code> wird der Baum
 * in <i>post order</i> traversiert. Besuchte aber noch nicht ausgegebene Elemente
 * werden in einem Stack hinterlegt. Die Traversierung ist somit nicht "stabil".
 *
 * @see java.util.Iterator
 * @see tree.iterator.unstable.AbstractUnstableIterator
 * @see Tree
 *
 * @author Jörg Hettel
 */
public class PostOrderIterator<E> extends AbstractUnstableIterator<E>
{
  private Stack<Boolean> visitRightChild = new Stack<>();

  public PostOrderIterator(Tree<E> root)
  {
    super(root);

    if( this.vistitedTreeNodes.empty() )
    {
      pushAllLeftNodesOnStack(this.root);
    }
  }

  protected E getNextElement()
  {
    if( this.vistitedTreeNodes.peek() == null || this.visitRightChild.peek() )
    {
      Tree<E> node = this.vistitedTreeNodes.pop();
      this.visitRightChild.pop();
      if( this.vistitedTreeNodes.empty() )
      {
        this.root = null;
      }
      return node.getElement();
    }
    else
    {
      if( this.visitRightChild.pop() )
        assert false;

      this.visitRightChild.push(true);
      Tree<E> node = this.vistitedTreeNodes.peek().getRight();

      this.pushAllLeftNodesOnStack(node);
      return getNextElement();
    }

  }

  private void pushAllLeftNodesOnStack(Tree<E> node)
  {
    if( node != null )
    {
      this.vistitedTreeNodes.push(node);
      this.visitRightChild.push(false);
      this.pushAllLeftNodesOnStack(node.getLeft());
    }
  }

}
