package ce210.trees;

public class AVLNode<K extends Comparable,E> extends BSTNode<K,E> {
  private int height;
  
  public AVLNode(K k, E e, AVLNode<K,E> p, AVLNode<K,E> l, AVLNode<K,E> r) {
    super(k,e,p,l,r);
    height = 1;
  }
  
  public AVLNode(AVLNode<K,E> p, AVLNode<K,E> l, AVLNode<K,E> r) {
    this( null, null, p, l, r );
  }
  
  public int getHeight() {
    return height;
  }
  
  public void setHeight(int h) {
    height = h;
  }
}
