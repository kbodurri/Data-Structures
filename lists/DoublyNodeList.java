package ce210.lists;

/** 
 * Generic Doubly Node List class without sentinel node.
 */

public class DoublyNodeList<T> {
  private int nofElements;
  private DNode<T> head, tail;

  public DoublyNodeList() {
    nofElements = 0 ;
    head = tail = null;
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
    return (v == head);
  }

  /**
   * Checks whether the provided node is the last  node in list.
   */
  public boolean isLast(DNode<T> v) {
    return (v == tail);
  }

  /**
   * Returns the first node of the list.
   */
  public DNode<T> first() {
    if(isEmpty()) {
      System.out.println("List is empty");
    }
    return head;
  }

  /**
   * Returns the first node of the list.
   */
  public DNode<T> last() {
    if( isEmpty() ) {
      System.out.println("List is empty");
      
    }
    return tail;
  }
  
  private DNode<T> addFirstNode(T element) {
    if( head != null || tail != null ) 
      return null;
    DNode<T> q = new DNode<T>(null, null, element);
    head = tail = q;
    nofElements++;
    return q;
  }
  
  private T deleteLastNode() {
    if( size() == 1 ) {
      DNode<T> q = head;
      head.setNext(null);
      tail.setPrev(null);
      head = tail = null;
      nofElements--;
      return q.getElement();
    }
    return null;    
  }

  /**
   * Inserts element at the beginning of the list.
   */
  public DNode<T> insertFirst(T element) {
    if( isEmpty() ) {
      return addFirstNode(element);
    }
    return insertBefore(head, element);
  }

  /**
   * Inserts element at the end of the list.
   */
  public DNode<T> insertLast(T element) {
    if( isEmpty() ) {
      return addFirstNode(element);
    }
    return insertAfter(tail, element);
  }

  /**
   * Inserts element before node 'p'. We assume that node p is a valid node in list.
   */
  public DNode<T> insertBefore(DNode<T> p, T element) {    
    DNode<T> q;
    if(p==head) {
      q = new DNode<T>(null, head, element);
      head.setPrev(q);
      head = q;
    }
    else {
      q = new DNode<T>(p.getPrev(), p, element);
      p.getPrev().setNext(q);
      p.setPrev(q);
    }
    nofElements++;
    return q;
  }

  /**
   * Inserts element after node 'p'. We assume that node p is a valid node in list.
   */
  public DNode<T> insertAfter(DNode<T> p, T element) {
    DNode<T> q;
    if(p==tail) {
      q = new DNode<T>(tail, null, element );
      tail.setNext(q);
      tail = q;
    }
    else {
      q = new DNode<T>(p, p.getNext(), element);
      p.getNext().setPrev(q);
      p.setNext(q);
    }
    nofElements++;
    return q;
  }
  
  /**
   * Delete node at the given position.
   */  
  public T delete(int pos) {
    DNode<T> q;
    int i=0;
    if( pos >= size() || pos < 0 ) 
      return null;
    for( i=0, q=head; q!=null && i<pos; q=q.getNext(), i++) {  }
    return delete(q);
    
  }

  /**
   * Delete node 'p' from the list.
   */
  public T delete(DNode<T> p) {
    if(size() <= 1) {
      return deleteLastNode();
    }
    
    DNode<T> pPrev=null, pNext=null;
    if( p!=head )
      p.getPrev().setNext(p.getNext());
    if( p!=tail )      
      p.getNext().setPrev(p.getPrev());
      
    if(p==head) head = head.getNext();
    if(p==tail) tail = tail.getPrev();

    nofElements--;
    p.setNext(null);
    p.setPrev(null);

    return p.getElement();
  }
  
  /**
   * Catenate list with list 's'.
   */
  public void catenate(DoublyNodeList<T> s) {
    if(s.isEmpty()) {
      return;
    }
    
    if(isEmpty()) {
      head = s.first();
    }
    else {
      s.first().setPrev(tail);
      tail.setNext(s.first());
    }

    tail = s.last();
    nofElements += s.size();
    s.reset();
  }
  
  /**
   * Set the list empty.
   */
  protected void reset() {
    head = tail = null;
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
    while( p != null ) {
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
