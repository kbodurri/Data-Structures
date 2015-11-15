package ce210.lists;

/**
 * Generic node class used in Doubly Node Lists.
 */

public class DNode<T> {

  private DNode<T> prev, next;
  private T element;

  /**
   * @param nodePrev The previous node this node points to.
   * @param nodeNext The next node this node points to.
   * @param newElement The generic element to store in node.
   */
  public DNode(DNode<T> nodePrev, DNode<T> nodeNext, T nodeElement) {
    prev = nodePrev;
    next = nodeNext;
    element = nodeElement;
  }

  /**
   * Returns the stored element in node.
   */
  public T getElement() {
    return element;
  }

  /**
   * Returns the previous node.
   */
  public DNode<T> getPrev() {
    return prev;
  }

  /**
   * Returns the next node.
   */
  public DNode<T> getNext() {
    return next;
  }

  /**
   * Stores a new element in node
   */
  public void setElement(T newElement) {
    element = newElement;
  }

  /**
   * Sets the pointer to the previous node to 'newPrev'.
   */
  public void setPrev(DNode<T> newPrev) {
    prev = newPrev;
  }

  /**
   * Sets the pointer to the next node to 'newNext'.
   */
  public void setNext(DNode<T> newNext) {
    next = newNext;
  }

}

