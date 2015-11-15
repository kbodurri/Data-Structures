package ce210.lists;

/**
 * Generic node class used in Singly Node Lists.
 */

public class SNode<T> {
  private SNode<T> next;
  private T element;

  /**
   * @param nodeNext The next node this node points to.
   * @param newElement The generic element to store in node.
   */
  public SNode(SNode<T> nodeNext, T newElement) {
    next = nodeNext;
    element = newElement;
  }
  
  /**
   * Returns the stored element in node.
   */
  public T getElement() {
    return element;
  }

  /**
   * Returns the next node.
   */
  public SNode<T> getNext() {
    return next;
  }

  /**
   * Stores a new element in node
   */
  public void setElement(T newElement) {
    element = newElement;
  }

  /**
   * Sets the pointer to the next node to 'newNext'.
   */
  public void setNext(SNode<T> newNext) {
    next = newNext;
  }
  
  /**
   * equals to setNext(null)
   */
  public void reset() {
    next = null;
  }

  /**
   * equals to a) setNext(null) and b) element=null.
   */
  public void purge() {
    reset();
    element = null;
  }
}