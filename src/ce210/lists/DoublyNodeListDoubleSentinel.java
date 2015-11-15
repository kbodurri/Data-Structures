package ce210.lists;

/** 
 * Generic Doubly Node List class with two sentinel nodes.
 */

public class DoublyNodeListDoubleSentinel<T> {
  private int nofElements;
  private DNode<T> head, tail;

  public DoublyNodeListDoubleSentinel() {
    nofElements = 0;
    head = new DNode<T>(null, null, null);
    tail = new DNode<T>(null, null, null);
    head.setNext(tail);
    tail.setPrev(head);
  }
  
  /**
   * Returns the number of stored elements in list.
   */
  public int size() {
    return nofElements;
  }

  /**
   * Checks whether the list is empty.
   */
  public boolean isEmpty() {
    return (nofElements < 1);
  }

  /**
   * Checks whether the provided node is the first node in list.
   */
  public boolean isFirst(DNode<T> v) {
    return (v.getPrev() == head );
  }

  /**
   * Checks whether the provided node is the last node in list.
   */
  public boolean isLast(DNode<T> v) {
    return (v.getNext() == tail );
  }

  /**
   * Returns the first node of the list.
   */
  public DNode<T> first() {
    if(isEmpty()) {
      System.out.println("List is empty");
      return head;
    }
    else {
      return head.getNext();
    }
  }

  /**
   * Returns the first node of the list.
   */
  public DNode<T> last() {
    if( isEmpty() ) {
      System.out.println("List is empty");
      return tail;
    }
    else {
      return tail.getPrev();
    }
  }

  /**
   * Inserts element at the beginning of the list.
   */
  public DNode<T> insertFirst(T element) {
    return insertAfter(head, element);
  }

  /**
   * Inserts element at the end of the list.
   */
  public DNode<T> insertLast(T element) {
    return insertBefore(tail, element);
  }

  /**
   * Inserts element before node 'p'. We assume that node p is a valid node in list.
   */
  public DNode<T> insertBefore(DNode<T> p, T element) {
    nofElements++;
    DNode<T> q;
    if(p==head) {
      q = new DNode<T>(head, head.getNext(), element);
      head.getNext().setPrev(q);
      head.setNext(q);
    }
    else {
      //System.out.println("head!=p");
      q = new DNode<T>(p.getPrev(), p, element);
      p.getPrev().setNext(q);
      p.setPrev(q);
    }
    return q;
  }

  /**
   * Inserts element after node 'p'. We assume that node p is a valid node in list.
   */
  public DNode<T> insertAfter(DNode<T> p, T element) {
    nofElements++;
    DNode<T> q;
    if(p==tail) {
      q = new DNode<T>(tail.getPrev(), tail, element );
      tail.getPrev().setNext(q);
      tail.setPrev(q);
    }
    else {
      q = new DNode<T>(p, p.getNext(), element);
      p.getNext().setPrev(q);
      p.setNext(q);
    }
    return q;
  }

  /**
   * Delete node 'p' from the list.
   */
  public T delete(DNode<T> p) {
    if( p == head || p == tail ) {
      System.out.println("Unable to delete head or tail of list.");
      return null;
    }
    nofElements--;
    DNode<T> pPrev = p.getPrev();
    DNode<T> pNext = p.getNext();
    pPrev.setNext(pNext);
    pNext.setPrev(pPrev);

    p.setNext(null);
    p.setPrev(null);

    return p.getElement();
  }
  
  /**
   * Delete node at the given position.
   */
  public T delete(int pos) {
    if( pos < 0 ) {
      System.out.println("Unable to delete element at negative position "+pos);
      return null;
    }
    if( pos >= size() ) {
      System.out.println("Unable to delete element at position "+pos+" > size:"+size());
      return null;
    }
    DNode<T> curr = null;
    int i;
    for(i=0, curr=head.getNext(); i<pos; i++) {
      curr = curr.getNext();
    }
    return delete(curr);    
  }
  
  /**
   * Catenate list with list 's'.
   */
  public void catenate(DoublyNodeListDoubleSentinel<T> s) {
    if(s.isEmpty()) {
      return;
    }
    
    if(isEmpty()) {
      head = s.first().getPrev();
    }
    else {
      s.first().setPrev(tail.getPrev());
      tail.getPrev().setNext(s.first());
    }

    tail = s.last().getNext();
    nofElements += s.size();
    s.reset();
    
  }
  
  /**
   * Set the list empty.
   */
  protected void reset() {
    head = tail;
    nofElements = 0;
  }
  
  /**
   * Returns a <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/String.html"> java.lang.String </a> representation of the list contents. 
   * Method is based on the toString method of the elements' class.
   */
  public String toString() {
    String str = "";
    if( isEmpty() ) {
      str = "List is empty\n";
      return str;
    }
    DNode<T> p = first();
    while( p != tail ) {
      str += p.getElement().toString() + "\n";
      p = p.getNext();
    }
    return str;
  }

  /**
   * Print the elements of the list in standard output.
   */
  public void printList() {
    System.out.println("\n----- Size: "+size()+" --------");
    System.out.println( toString() );
  }

  
}
