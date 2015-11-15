package ce210.trees;

public class LinkedBinaryTree<T> {
  private BTNode<T> Root;
  private int size;
  static boolean Left = true;
  static boolean Right = false;
  
  public enum BTNodeChildType { LEFT, RIGHT };

  public LinkedBinaryTree() {
    Root = null;
    size = 0;
  }

  public LinkedBinaryTree(BTNode<T> o) {
    Root = o;
  }

  public LinkedBinaryTree(T o) {
    Root = new BTNode<T>(o, null, null, null);
    size = 1;
  }

  public int size() {
    return size;
  }

  public void setSize(int s) {
    size = s;
  }

  public BTNode<T> root() {
    return Root;
  }

  public boolean isRoot(BTNode<T> v) {
    return (v==Root);
  }

  public boolean isLeft(BTNode<T> v) {
    if( v== Root ) {
      System.out.println("You are at root element.");
      return false;
    }
    return (v==v.getParent().getLeft());
  }

  public boolean isRight(BTNode<T> v) {
    if( v== Root ) {
      System.out.println("You are at root element.");
      return false;
    }
    return (v==v.getParent().getRight());
  }

  public void exchangeElements(BTNode<T> v, BTNode<T> w) {
    T temp = v.getElement();
    v.setElement(w.getElement());
    w.setElement(temp);
  }

  public BTNode<T> getSibling(BTNode<T> v) {
    if((v==null) || isRoot(v)) {
      System.out.println("No sibling.");
      return null;
    }
    if(isRight(v)) {
      return v.getParent().getLeft();
    }
    else {
      return v.getParent().getRight();
    }
  }
  
  public void addLeaf(BTNode<T> v, T o, BTNodeChildType type ) {
    if( type == BTNodeChildType.LEFT ) {
      if( v.getLeft() != null ) {
        System.out.println("This kind of child exists!");
        return;
      }
      v.setLeft( new BTNode<T>(o,v,null,null));
      size++;
    } 
    else {
      if( v.getRight() != null ) {
        System.out.println("This kind of child exists!");
        return;
      }
      v.setRight( new BTNode<T>(o,v,null,null));
      size++;
    }
  }
  
  public T deleteNode(BTNode<T> v) {
    if( v.getLeft()!=null && v.getRight()!=null ) {
      System.out.println("Unable to delete node");
      return null;
    }
    if(isRoot(v)){
      BTNode<T> notNullSonofv = (v.getLeft()!=null ? v.getLeft() : v.getRight());
      Root = notNullSonofv;
      if( Root != null ) Root.setParent(null);    
    }
    else {
      BTNode<T> parentOfv = v.getParent();
      BTNode<T> notNullSonofv = (v.getLeft()!=null ? v.getLeft() : v.getRight());
      if( isLeft(v) )
        parentOfv.setLeft(notNullSonofv);
      else 
        parentOfv.setRight(notNullSonofv);
      if(notNullSonofv != null) 
        notNullSonofv.setParent(parentOfv);
    }
    size--;
    v.setLeft(null);
    v.setRight(null);
    v.setParent(null);
    return v.getElement();
  }

  public String toString() {
    return Root.toString();    
  }
 
}
