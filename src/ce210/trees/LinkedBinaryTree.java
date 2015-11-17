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
  
  public boolean isEmpty() {
    if(size == 0)
      return true;
    else 
      return false;
  }

  public void setSize(int s) {
    size = s;
  }

  public BTNode<T> root() {
    return Root;
  }  
  
  public boolean setRoot(BTNode<T> newRoot) {
    if( isEmpty() ) {
      Root = newRoot;
      return true;
    }
    return false;
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
  
  public boolean addLeaf(BTNode<T> v, T o, BTNodeChildType type ) {
    if( type == BTNodeChildType.LEFT ) {
      if( v.getLeft() != null ) {
        //System.out.println("This kind of child exists!");
        return false;
      }
      v.setLeft( new BTNode<T>(o,v,null,null));
      size++;
      return true;
    } 
    else {
      if( v.getRight() != null ) {
        //System.out.println("This kind of child exists!");
        return false;
      }
      v.setRight( new BTNode<T>(o,v,null,null));
      size++;
      return true;
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
  
  public void insertRandom(T o, java.util.Random rand) {
    if( root() == null ) {
      setRoot( new BTNode<T>( o, null, null, null) );
      return;
    }
    insertRandomNode( root(), o, rand);
  }
  
  public void insertRandomNode(BTNode<T> curr, T o, java.util.Random rand) {
    BTNodeChildType type = null;
    boolean search_left;
    if( rand.nextBoolean() == true ) {
      type = BTNodeChildType.LEFT;
      search_left = true;
    } else {
      type = BTNodeChildType.RIGHT;
      search_left = false;
    }
    
    System.out.println("Insert item "+o+" to node "+curr.getElement());
    
    if( !addLeaf(curr, o, type) ) {      
      type = (type == BTNodeChildType.LEFT ? BTNodeChildType.RIGHT : BTNodeChildType.LEFT);
      if( !addLeaf(curr, o, type) ) {
        if( search_left == true && curr.getLeft() != null ) {
          insertRandomNode(curr.getLeft(), o, rand);
        }
        else if( curr.getRight() != null ) {
          insertRandomNode(curr.getRight(), o, rand);
        }
      }
    }    
  }

  public String toString() {
    return Root.toString();    
  }
  
  public String dotString() {
    String str = "digraph LinkedBinaryTree {\n" + root().dotString() + "}\n";
    return str;
  }

 public String  toStringPreOrder(BTNode<T> node){
	String str = "";
	if (node != null){
		str += node.getElement() + "\n";
		str += toStringPreOrder(node.getLeft());
		str += toStringPreOrder(node.getRight());
	}
	
	return str;
 }

 public String toStringPostOrder(BTNode<T> node){
 	String str = "";
	
	if (node != null){
		str += toStringPostOrder(node.getLeft());
		str += toStringPostOrder(node.getRight());
		str += node.getElement() + "\n";
	}
	
	return str;
 }

 public String toStringInOrder(BTNode<T> node) {
	String str = "";

	if (node != null){
		str += toStringInOrder(node.getLeft());
		str += node.getElement() + "\n";	
		str += toStringInOrder(node.getRight());	
	}
	
	return str;
 }
	
}
