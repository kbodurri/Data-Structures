package ce210.stack;

import ce210.lists.*;

public class LinkedStack<T> {
  private SNode<T> top;
  private int size;

  public LinkedStack() {
    top = null;
    size = 0;
  }

  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return (size<1);
  }

  public void push(T elem) {
    SNode<T> x = new SNode<T>(top, elem);
    top = x;
    size++;
  }
  
  public T pop() {
    SNode<T> oldtop;
    if(isEmpty()) {
      System.out.println("Stack is empty");
    }
    oldtop = top;
    top = top.getNext();
    oldtop.setNext(null);
    size--;
    return oldtop.getElement();
  }

  public T top() {
    if(isEmpty()) {
      System.out.println("Stack is empty");
      return null;
    }
    return top.getElement();
  }

  public String toString() {
    String str="";
    SNode<T> n = top;
    str = n.getElement().toString()+"\n";
    while((n = n.getNext()) != null) {
      str += n.getElement().toString()+"\n";
    }
    return str;
  }

}
