package ce210.trees;

/* Uses BSTNode<T>
 */

public class BinarySearchTree<K extends Comparable,E> {
  protected BSTNode<K,E> lastInsertedNode;
  private BSTNode<K,E> Root;
  private BSTNode<K,E> lastDeletedNode;
  private int size;
  
  public enum BSTNodeChildType { LEFT, RIGHT };

  public BinarySearchTree() {
    Root = null;
    lastDeletedNode = null;
    size = 0;
  }

  public BinarySearchTree(BSTNode<K,E> o) {
    Root = o;
    lastDeletedNode = null;
    size = 1;
  }

  public BinarySearchTree(K k, E e) {
    Root = new BSTNode<K,E>(k, e, null, null, null);
    lastDeletedNode = null;
    size = 1;
  }
  
  public BSTNode<K,E> getLastDeletedNode() {
    return lastDeletedNode;
  }

  public int size() {
    return size;
  }

  public void setSize(int s) {
    size = s;
  }

  public BSTNode<K,E> root() {
    return Root;
  }
  
  public void setRoot(BSTNode<K,E> newRoot) {
    Root = newRoot;
  }

  public boolean isRoot(BSTNode<K,E> v) {
    return (v==Root);
  }

  public boolean isLeft(BSTNode<K,E> v) {
    if( v == Root ) {
      System.out.println("You are at root element.");
      return false;
    }
    return (v==v.getParent().getLeft());
  }

  public boolean isRight(BSTNode<K,E> v) {
    if( v == Root ) {
      System.out.println("You are at root element.");
      return false;
    }
    return (v==v.getParent().getRight());
  }

  public void exchangeElements(BSTNode<K,E> v, BSTNode<K,E> w) {
    K tempKey = v.getKey();
    E tempElement = v.getElement();
    v.setKey(w.getKey());
    v.setElement(w.getElement());
    w.setKey(tempKey);
    w.setElement(tempElement);
  }

  public BSTNode<K,E> getSibling(BSTNode<K,E> v) {
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
  
  public void addLeaf(BSTNode<K,E> v, K k, E e, BSTNodeChildType type ) {
    if( type == BSTNodeChildType.LEFT ) {
      if( v.getLeft() != null ) {
        System.out.println("This kind of child exists!");
        return;
      }
      lastInsertedNode = new BSTNode<K,E>(k,e,v,null,null);
      v.setLeft( lastInsertedNode );
      size++;
    } 
    else {
      if( v.getRight() != null ) {
        System.out.println("This kind of child exists!");
        return;
      }
      lastInsertedNode = new BSTNode<K,E>(k,e,v,null,null);
      v.setRight( lastInsertedNode );
      size++;
    }
  }
  
  public void addLeaf(BSTNode<K,E> v, BSTNode<K,E> newNode, BSTNodeChildType type) {
    if( type == BSTNodeChildType.LEFT ) {
      if( v.getLeft() != null ) {
        System.out.println("This kind of child exists!");
        return;
      }
      v.setLeft( newNode );
      newNode.setParent(v);
      lastInsertedNode = newNode;
      size++;
    } 
    else {
      if( v.getRight() != null ) {
        System.out.println("This kind of child exists!");
        return;
      }
      v.setRight( newNode );
      newNode.setParent(v);
      lastInsertedNode = newNode;
      size++;
    }
  }
  
  public E deleteNode(BSTNode<K,E> v) {
    if( v.getLeft()!=null && v.getRight()!=null ) {
      System.out.println("Unable to delete node");
      return null;
    }
    lastDeletedNode = v;
    if(isRoot(v)){
      BSTNode<K,E> notNullSonofv = (v.getLeft()!=null ? v.getLeft() : v.getRight());
      Root = notNullSonofv;
      if( Root != null ) Root.setParent(null);    
    }
    else {
      BSTNode<K,E> parentOfv = v.getParent();
      BSTNode<K,E> notNullSonofv = (v.getLeft()!=null ? v.getLeft() : v.getRight());
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
  
  /** 
   * Returns the node that either contains the specified key
   * or the node that we should add a new node with the specified 
   * key below it.
   */
  public BSTNode<K,E> findNode(K key, BSTNode<K,E> v) {
    K nodeKey = v.getKey();
    int compareResult = key.compareTo(nodeKey);
    if( compareResult < 0 ) {
      if(v.getLeft() == null)
        return v;
      else 
        return findNode(key, v.getLeft());
    }
    else if( compareResult > 0 ) {
      if(v.getRight() == null)
        return v;
      else 
        return findNode(key, v.getRight());
    }
    else {
      return v;
    }
  }
  
  public E findInfo(K key, BSTNode<K,E> v) {
    BSTNode<K,E> node = findNode(key, v);
    if( node.getKey().compareTo(key) == 0 ) {
      return node.getElement();
    }
    return null;
  }
  
  public BSTNode<K,E> insertItem(K key, E e) {
    if( size() == 0 ) {
      setRoot(new BSTNode(key, e, null, null, null));
      setSize(1);
      return root();
    }
    
    BSTNode<K,E> insNode = findNode(key, root());
    K keyOfinsNode = insNode.getKey();
    int compareResult = key.compareTo(keyOfinsNode);
    
    /* Key already exists */
    if( compareResult == 0 ) 
      return null;
    if( compareResult < 0 ) {
      addLeaf( insNode, key, e, BSTNodeChildType.LEFT );
      return insNode.getLeft();
    }
    else {
      addLeaf( insNode, key, e, BSTNodeChildType.RIGHT );
      return insNode.getRight();
    }
  }
  
  public BSTNode<K,E> insertItem(BSTNode<K,E> newNullPointerNode) {
    if( size() == 0 ) {
      setRoot(newNullPointerNode);
      setSize(1);
      return root();
    }
    
    BSTNode<K,E> insNode = findNode(newNullPointerNode.getKey(), root());
    K keyOfinsNode = insNode.getKey();
    int compareResult = newNullPointerNode.getKey().compareTo(keyOfinsNode);
    
    /* Key already exists */
    if( compareResult == 0 ) 
      return null;
    if( compareResult < 0 ) {
      addLeaf( insNode, newNullPointerNode, BSTNodeChildType.LEFT );
      return insNode.getLeft();
    }
    else {
      addLeaf( insNode, newNullPointerNode, BSTNodeChildType.RIGHT );
      return insNode.getRight();
    }
  }
  
  /**
   * Deletes the tree node with the specified key, if such a node exists.
   * Returns the neighbouring node.
   */
  public BSTNode<K,E> deleteItem(K key) {
    if( size() == 0 ) 
      return null;
    
    BSTNode<K,E> delNode = findNode(key, root());
    K keyOfdelNode = delNode.getKey();
    int compareResult = key.compareTo(keyOfdelNode);
    
    /* Item was not found */
    if( compareResult != 0 ) 
      return null;
    BSTNode<K,E> returnNode = null;
    if( delNode.getLeft() == null || delNode.getRight() == null ) {
      if( delNode.getLeft() != null ) 
        returnNode = delNode.getLeft();
      else if( delNode.getRight() != null ) 
        returnNode = delNode.getRight();
      else 
        returnNode = delNode.getParent();
      deleteNode(delNode);
      return returnNode;
    }
    else {
      BSTNode<K,E> cursor = delNode.getRight();
      BSTNode<K,E> tmp, parentDelNode;
      while( (tmp = cursor.getLeft()) != null ) 
        cursor = tmp;
      exchangeElements(cursor, delNode);
      parentDelNode = cursor.getParent();
      deleteNode(cursor);
      return parentDelNode;
    }
  }
  
  public String dotString(BSTNode<K,E> node) {
    String str = node.getKey() + " [shape=circle, color=";
    String color = "black";
    if( lastInsertedNode == node ) color = "blue";
    str += color +"]\n";
    if(node.getLeft()!=null) {
      str += node.getKey() +" -> "+ node.getLeft().getKey() + "\n";
      str += dotString(node.getLeft());
    }
    if(node.getRight()!=null) {
      str += node.getKey() +" -> "+ node.getRight().getKey() + "\n";
      str += dotString(node.getRight());
    }
    return str;
  }
  
  public String dotString() {
    String str = "digraph BinarySearchTree {\n" + dotString(root()) + "}\n";
    return str;
  }
  
}
