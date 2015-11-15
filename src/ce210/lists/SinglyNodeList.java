package ce210.lists;

/** 
 * Generic Singly Node List class without sentinel node.
 */
public class SinglyNodeList<T> {
  protected int nofElements;
  protected SNode<T> head, tail;

  public SinglyNodeList() {
    nofElements = 0;
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
  public boolean isFirst(SNode<T> v) {
    return v == head;
  }

  /**
   * Returns the first node of the list.
   */
  public SNode<T> first() {
    if( isEmpty() ) {
      System.out.println("List is empty");
    }
    return head;
  }

  /**
   * Returns the last node of the list.
   */
  public SNode<T> last() {
    if( isEmpty() ) {
      System.out.println("List is empty");
    }
    return tail;
  }
  
  /**
   * Inserts element at the end of the list.
   */
  public SNode<T> insertLast(T element) {
    if(!isEmpty()) {
      return insertAfter( last(), element );
    }
    else {
      return insertFirst(element);
    }
  }

  /**
   * Inserts element after node 'p'. We assume that node p is a valid node in list.
   */
  public SNode<T> insertAfter(SNode<T> p, T element) {
    if( isEmpty() ) {
      System.out.println("List is empty. Not allowed to use \"insertAfter\" function");
      return null;
    }
    nofElements++;
    SNode<T> q = new SNode<T>(p.getNext(), element);
    if( p.getNext() == null ) {
      tail = q;
    }
    p.setNext(q);
    return q;
  }

  /**
   * Insets element at the beginning of the list.
   */
  public SNode<T> insertFirst(T element) {
    /* when the list is empty head == null
     */
    SNode<T>  q = new SNode<T>(head, element);
    head = q;
    if(nofElements == 0 ) {
      tail = head;
    }
    nofElements++;
    return q;
  }

  /**
   * Delete the node list after node 'p'. We assume that node p is a valid node in list.
   */
  public T deleteAfter(SNode<T> p) {
    if( p == tail ) {
      System.out.println("Unable to delete after the last element");
      return null;
    }
    SNode<T> pNext = p.getNext();
    nofElements--;
    p.setNext(pNext.getNext());
    if(pNext == tail) {
      tail = p;
    }
    pNext.setNext(null);
    return pNext.getElement();
  }
  
  /**
   * Delete the first node.
   */
  public T deleteFirst() {
    if( nofElements == 0 ) {
      System.out.println("Cannot delete first element from an empty list");
      return null;
    }
    nofElements--;
    SNode<T> first = head;
    head = first.getNext();
    if( head == null || head.getNext() == null ) {
      tail = head;
    }
    first.reset();
    return first.getElement();    
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
    SNode<T> curr = null, prev =null;
    int i;
    for(i=0, curr=head; i<pos; prev=curr, curr = curr.getNext(), i++) {
      if(curr==null) {
        System.out.println("Something really nasty happened, while trying to delete pos:"+pos+"! \nReturning..");
        return null;
      }
    }
    return deleteAfter(prev);    
  }
  
  /**
   * Delete the last node of the list.
   */
  public T deleteLast() {
    return delete(size()-1);
  }

  /**
   * Catenate list with list 's'.
   */
  public void catenate(SinglyNodeList<T> s) {
    if(s.isEmpty()) {
      return;
    }
    if(isEmpty()) 
      head = s.first();
    else
      tail.setNext(s.first());
    

    tail = s.last();
    nofElements += s.size();
    s.setEmpty();
  }
  
  /**
   * Returns a <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/String.html"> java.lang.String </a> representation of the list contents. 
   * Method is based on the toString method of the elements' class.
   */
  public String toString() {
	String str="";
    if( isEmpty() ) {
      str = "List is empty\n";
      return str;
    }
    SNode<T> p = first();
    while( p != null ) {
      str += p.getElement().toString()+"\n";
      p = p.getNext();
    }
    return str;
  }
  
  /**
   * Print the elements of the list in standard output.
   */
  public void printList() {
    System.out.println( toString() );
  }

  /**
   * Set the list empty.
   */
  public void setEmpty() {
    head = tail = null;
    nofElements = 0;
  }

}
