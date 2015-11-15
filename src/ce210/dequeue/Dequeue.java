package ce210.dequeue;

import ce210.lists.*;

public class Dequeue<T> {

  DNode<T> head, rear;
  int size;

  public Dequeue() {
    head = new DNode<T>(null, null, null);
    rear = new DNode<T>(head, null, null);
    head .setNext(rear);
    size = 0;
  }
  
  public boolean isEmpty() {
    return(size<1);
  }

  public T pop() {
    if(isEmpty()) {
      System.out.println("Dequeue is empty.");
      return null;
    }
    DNode<T> first = head.getNext();
    DNode<T> second = first.getNext();
    head.setNext(second);
    second.setPrev(head);
    first.setNext(null); 
    first.setPrev(null);
    size--;
    return first.getElement();
  }

  public void push(T o) {
    DNode<T> second = head.getNext();
    DNode<T> first = new DNode<T>(head, second, o);
    second.setPrev(first);
    head.setNext(first);
    size++;
  }

  public T eject() {
    if(isEmpty()) {
      System.out.println("Dequeue is empty.");
      return null;
    }
    DNode<T> last = rear.getPrev();
    DNode<T> secondtolast = last.getPrev();
    rear.setPrev(secondtolast);
    secondtolast.setNext(rear);
    last.setPrev(null);
    last.setNext(null);
    size--;
    return last.getElement();
  }

  public void inject(T o) {
    DNode<T> secondtolast = rear.getPrev();
    DNode<T> last = new DNode<T>(secondtolast, rear, o);
    secondtolast.setNext(last);
    rear.setPrev(last);
    size++;
  }

  public T first() {
    if(isEmpty()) {
      System.out.println("Dequeue is empty.");
      return null;
    }
    return rear.getNext().getElement();
  }

  public T last() {
    if( isEmpty() ) {
      System.out.println("Dequeue is empty.");
      return null;
    }
    return rear.getPrev().getElement();
  }
  
  public String toString() {        
    if( isEmpty() ) {
      return "Dequeue is Empty";
    }
    else {
      String str = "";
      DNode<T> p = head;      
      while( (p = p.getNext()) != rear ) {        
        str += p.getElement().toString() + "\n";
      }
      return str;
    }
  }


}
