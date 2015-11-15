package ce210.trees;

public class RedBlackNode<K extends Comparable,E> extends BSTNode<K,E> {

  private RedBlackColor color;
  
  public RedBlackNode(K k, E e, RedBlackNode<K,E> p, RedBlackNode<K,E> l, RedBlackNode<K,E> r) {
    super(k,e,p,l,r);
    color = RedBlackColor.RED;
  }
  
  public RedBlackNode(RedBlackNode<K,E> p, RedBlackNode<K,E> l, RedBlackNode<K,E> r) {
    this( null, null, p, l, r );
    color = RedBlackColor.RED;
  }
  
  public RedBlackColor getColor() {
    return color;
  }
  
  public void setColor(RedBlackColor c) {
    color = c;
  }
  
  public String dotString() {
    String str = getKey() + " [shape=circle, color=black]\n";
    if(getLeft()!=null)
      str += getKey() +" -> "+ getLeft().getKey();
    if(getRight()!=null)
      str += getKey() +" -> "+ getRight().getKey();
    str += getLeft().dotString();
    str += getRight().dotString();
    return str;
  }
}
