package ce210.fifo;

import ce210.lists.*;

public class FiFo<T> {
  protected int nofElements;
  protected SNode<T> head, rear;

  public FiFo() {
    nofElements = 0;
    head = null;
    rear = null;
  }

  public int size() {
    return nofElements;
  }

  public boolean isEmpty() {
    return (nofElements < 1);
  }

  public void enqueue(T obj) {
    SNode<T> x = new SNode<T>(null, obj);
    if(isEmpty()) {
      rear = head = x;
      nofElements++;
    }
    else {
      rear.setNext(x);
      rear = x;
      nofElements++;
    }
  }

  public T dequeue() {
    SNode<T> temp;

    if(isEmpty()) {
      System.out.println("FiFo is empty.");
      return null;
    }
    temp = head;
    head = head.getNext();
    temp.setNext(null);
    nofElements--;
    if(nofElements==0) {
      rear = null;
    }
    return temp.getElement();
  }

  public T first() {
    if(isEmpty()) {
      System.out.println("FiFo is emptt.");
    }
    return head.getElement();
  }

  public String toString() {
    if(isEmpty()) {
      return "Empty FiFo";
    }
    else {
      SNode<T> n = head;
      String str = "";
      str += n.getElement().toString()+"\n";
      while( (n=n.getNext()) != null ) {
        str += n.getElement().toString()+"\n";
      }
      return str;
    }
  }

}
