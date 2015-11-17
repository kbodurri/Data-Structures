package ce210.trees;

public class BTNode<T> {
  private T element;
  private BTNode<T> left, right, parent;

  public BTNode(T o, BTNode<T> u, BTNode<T> v, BTNode<T> w) {
    setElement(o);
    setParent(u);
    setLeft(v);
    setRight(w);
  }
  
  public BTNode(BTNode<T> u, BTNode<T> v, BTNode<T> w) {
    this( null, u, v, w );
  }
 
  public T getElement() {
    return element;
  }

  public void setElement(T o) {
    element = o;
  }

  public BTNode<T> getLeft() {
    return left;
  }

  public void setLeft(BTNode<T> v) {
    left = v;
  }

  public BTNode<T> getRight() {
    return right;
  }

  public void setRight(BTNode<T> v) {
    right = v;
  }

  public BTNode<T> getParent() {
    return parent;
  }

  public void setParent(BTNode<T> v) {
    parent = v;
  }

  public String toString() {
    String str = getElement().toString();
    if( getLeft() != null ) {
      str += getLeft().toString();
    }
    if( getRight() != null ) {
      str += getRight().toString();
    }
    return str;    
  }
  
  public String dotString() {
    String str = element + " [shape=circle, color=black]\n";
    if(left!=null) {
      str += element +" -> "+ left.getElement()+"\n";
      str += left.dotString();
    }
    if(right!=null) {
      str += element +" -> "+ right.getElement()+"\n";
      str += right.dotString();
    }
    return str;
  }

}
