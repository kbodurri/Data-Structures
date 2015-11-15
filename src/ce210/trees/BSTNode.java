package ce210.trees;

public class BSTNode<K extends Comparable,E> {
  private K key;
  private E element;
  private BSTNode<K,E> left, right, parent;

  public BSTNode(K k, E e, BSTNode<K,E> p, BSTNode<K,E> l, BSTNode<K,E> r) {
    setKey(k);
    setElement(e);
    setParent(p);
    setLeft(l);
    setRight(r);
  }
  
  public BSTNode(BSTNode<K,E> p, BSTNode<K,E> l, BSTNode<K,E> r) {
    this( null, null, p, l, r );
  }
 
  public K getKey() {
    return key;
  }

  public void setKey(K k) {
    key = k;
  }
  
  public E getElement() {
    return element;
  }

  public void setElement(E e) {
    element = e;
  }

  public BSTNode<K,E> getLeft() {
    return left;
  }

  public void setLeft(BSTNode<K,E> l) {
    left = l;
  }

  public BSTNode<K,E> getRight() {
    return right;
  }

  public void setRight(BSTNode<K,E> r) {
    right = r;
  }

  public BSTNode<K,E> getParent() {
    return parent;
  }

  public void setParent(BSTNode<K,E> p) {
    parent = p;
  }

  public String toString() {
    String str = "["+getKey().toString()+", "+getElement().toString()+"]\n";
    /*if( getLeft() != null ) {
      str += getLeft().toString();
    }
    if( getRight() != null ) {
      str += getRight().toString();
    }*/
    return str;    
  }
  
  public String dotString() {
    String str = key + " [shape=circle, color=black]\n";
    if(left!=null)
      str += key +" -> "+ left.getKey();
    if(right!=null)
      str += key +" -> "+ right.getKey();
    str += left.dotString();
    str += right.dotString();
    return str;
  }

}
