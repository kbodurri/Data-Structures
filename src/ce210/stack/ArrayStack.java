package ce210.stack;

public class ArrayStack<T> {

  public static final int defaultCapacity = 1000;
  private int capacity;
  private T STACK[];
  private int top = -1;

  public ArrayStack() {
    this(defaultCapacity);
  }

  public ArrayStack(int cap) {
    capacity = cap;
    STACK = (T[]) new Object[cap];
  }

  public int size() {
    return (top+1);
  }

  public boolean isEmpty() {
    return (top<0);
  }

  public void push(T obj){
    if(size() == capacity) {
      System.out.println("Stack is full. Unable to push.");
      return;
    }
    STACK[++top] = obj;
  }

  public T top() {
    if( isEmpty()) {
      System.out.println("Stack is empty");
      return null;
    }
    return STACK[top];
  }
  
  public T pop() {
    T elem;
    if(isEmpty()) {
      System.out.println("Stack s empty");
      return null;
    }
    elem = STACK[top];
    STACK[top--] = null;
    return elem;
  }
  
  public String toString() {
    String str="";
    for(int i=top; i>=0; i--) {
      str += STACK[i].toString()+"\n";
    }
    return str;
  }

}
