package ce210.trees;

public class RedBlackTree<K extends Comparable,E> extends BinarySearchTree<K,E> {

  public RedBlackTree() {
    super();
  }

  public RedBlackTree(RedBlackNode<K,E> o) {
    super((BSTNode<K,E>)o);
    o.setColor(RedBlackColor.BLACK);
  }

  public RedBlackTree(K k, E e) {
    RedBlackNode<K,E> node = new RedBlackNode(k,e, null, null, null);
    super.setRoot(node);
    super.setSize(1);
  }
  
  public void echangeElements(BSTNode<K,E> v, BSTNode<K,E> w) {
    RedBlackColor colorV = ((RedBlackNode)v).getColor();
    RedBlackColor colorW = ((RedBlackNode)w).getColor();
    ((RedBlackNode)v).setColor(colorW);
    ((RedBlackNode)w).setColor(colorV);
    super.exchangeElements(v,w);
  }
  
  private boolean setBlack(BSTNode<K,E> v) {
    if(v==null) {
      System.err.println("Attemping to set black a null node.");
      return false;
    }
    ((RedBlackNode)v).setColor(RedBlackColor.BLACK);
    return true;
  }
  
  private boolean setRed(BSTNode<K,E> v) {
    if(v==null) {
      System.err.println("Attemping to set red a null node.");
      return false;
    }
    ((RedBlackNode<K,E>)v).setColor(RedBlackColor.RED);
    return true;
  }
  
  private boolean isBlack(BSTNode<K,E> v) {
    if(v==null)
      return true;
    return (((RedBlackNode<K,E>)v).getColor() == RedBlackColor.BLACK);
  }
  
  private boolean isRed(BSTNode<K,E> v) {
    if(v==null)
      return false;
    return (((RedBlackNode<K,E>)v).getColor() == RedBlackColor.RED);
  }
  
  private RedBlackColor getColor(BSTNode<K,E> v) {
    if(v==null) 
      return RedBlackColor.BLACK;
    return ((RedBlackNode<K,E>)v).getColor();
  }
  
  private boolean hasOneRedSon(BSTNode<K,E> v) {
    if(v==null) {
      System.err.println("Node is NULL and has no children!");
      return false;
    }
    return (isRed(v.getLeft()) && isBlack(v.getRight())) || (isRed(v.getRight()) && isBlack(v.getLeft()));
  }
  
  private BSTNode<K,E> getRedSon(BSTNode<K,E> v) {
    if(v==null) {
      System.out.println("Node is NULL and has no children!");
      return null;
    }
    return (isRed(v.getLeft())) ? v.getLeft() : v.getRight();
  }
  
  private void insertionRebalance(BSTNode<K,E> v) {
    if(v==null) {
      System.err.println("Node is empty and cannot be rebalanced!");
      return;
    }
    
    BSTNode<K,E> u = null, w=v;
    v = v.getParent();
    while(isRed(v)) {
      // sibling of node v is black
      if( isBlack(getSibling(v))) {
        
        //rotation simple or double
        u=w; w=v;
        v=v.getParent();
        v=reconstruct(v,w,u);
        setRed(v.getLeft());
        setRed(v.getRight());
        setBlack(v);
      }
      // sibling of node v is red
      else {
        setBlack(v);
        setBlack(getSibling(v));
        v=v.getParent();
        if(isRoot(v))
          break;
        setRed(v);
        u=w; w=v;
        v=v.getParent();
      }
    }
  }
  
  private void deletionRebalance(BSTNode<K,E> y) {
    if(y==null) {
      System.err.println("Node is empty and cannot be rebalanced!");
      return;
    }
    
    BSTNode<K,E> sibling = y.getLeft() != null ? y.getLeft() : y.getRight();
    BSTNode<K,E> childOfSibling;
    
    while(y!=null) {
      if(isBlack(sibling)) {
        RedBlackColor parentColor = getColor(y);
        if(hasOneRedSon(sibling)) {
          y=reconstruct(y,sibling, getRedSon(sibling));
          setBlack(y.getLeft());
          setBlack(y.getRight());
          if(parentColor == RedBlackColor.BLACK)
            setBlack(y);
          else
            setRed(y);
          return;
        }

        setBlack(y);
        if(sibling!=null)
          setRed(sibling);
        if(parentColor==RedBlackColor.RED)
          return;
        else {
          if( isRoot(y)) 
            return;
          sibling = getSibling(y);
          y = y.getParent();
        }
      }
      else {
        BSTNode<K,E> newSibling;
        if(isLeft(sibling)) {
          newSibling = sibling.getRight();
          childOfSibling = sibling.getLeft();
        }
        else {
          newSibling = sibling.getLeft();
          childOfSibling = sibling.getRight();
        }
        setBlack(reconstruct(y,sibling, childOfSibling));
        setRed(getSibling(childOfSibling));
        sibling = newSibling;
      }
    }
  }
  
  private BSTNode<K,E> reconstruct(BSTNode<K,E> v, BSTNode<K,E> w, BSTNode<K,E> u) {
    if( isLeft(w) && isLeft(u) ) {
      if( !isRoot(v) ) {
        if( isLeft(v) )
          v.getParent().setLeft(w);
        else
          v.getParent().setRight(w);
        w.setParent(v.getParent());
      }
      else {
        setRoot(w);
        w.setParent(null);
      }
      v.setLeft(w.getRight());
      if(w.getRight() != null)
        w.getRight().setParent(v);
      w.setRight(v);
      v.setParent(w);
      return w;
    }
    else if(isRight(w) && isRight(u)) {
      if( !isRoot(v) ){
        if( isRight(v) )
          v.getParent().setRight(w);
        else
          v.getParent().setLeft(w);
        w.setParent(v.getParent());
      }
      else {
        setRoot(w);
        w.setParent(null);
      }
      v.setRight(w.getLeft());
      if(w.getLeft() != null)
        w.getLeft().setParent(v);
      w.setLeft(v);
      v.setParent(w);
      return w;
    }
    else if( isLeft(u) ) {
      v.setRight(u.getLeft());
      if(u.getLeft() != null)
        u.getLeft().setParent(v);
      w.setLeft(u.getRight());
      if(u.getRight() != null)
        u.getRight().setParent(u);
      if( !isRoot(v) ) {
        if(isRight(v))
          v.getParent().setRight(u);
        else 
          v.getParent().setLeft(u);
        u.setParent(v.getParent());
      }
      else {
        setRoot(u);
        u.setParent(null);
      }
      v.setParent(u);
      w.setParent(u);
      u.setLeft(v);
      u.setRight(w);
      return u;
    }
    else {
      v.setLeft(u.getRight());
      if(u.getRight() != null)
        u.getRight().setParent(v);
      w.setRight(u.getLeft());
      if(u.getLeft() != null)
        u.getLeft().setParent(u);
      if( !isRoot(v) ) {
        if(isLeft(v))
          v.getParent().setLeft(u);
        else 
          v.getParent().setRight(u);
        u.setParent(v.getParent());
      }
      else {
        setRoot(u);
        u.setParent(null);
      }
      v.setParent(u);
      w.setParent(u);
      u.setLeft(w);
      u.setRight(v);
      return u;
    }
  }
  
  public BSTNode<K,E> insertItem(K key, E e) {
    RedBlackNode<K,E> newNode = new RedBlackNode(key, e, null, null, null);
    BSTNode<K,E> insNode = super.insertItem(newNode);
    if(insNode == null)
      return null;
    if(isRoot(insNode))
      setBlack(insNode);
    else
      insertionRebalance(insNode);
    return insNode;
  }
  
  public BSTNode<K,E> deleteItem(K key) {
    BSTNode<K,E> delNode = super.deleteItem(key);
    if(delNode == null)
      return null;
    if(isRed(delNode) && isRed(delNode.getParent()))
      setBlack(delNode);
    else if( ((RedBlackNode)getLastDeletedNode()).getColor() == RedBlackColor.RED || isRoot(delNode) ) {
    }
    else 
      deletionRebalance(delNode);
    return delNode;
  }
  
  public String dotString() {
    String str = "digraph RedBlackTree {\n" + dotString(root()) + "}\n";
    return str;
  }
  
  public String dotString(BSTNode<K,E> node) {
    String str = node.getKey() + " [shape=circle, style=filled , fontcolor=white, color=";
    String color = "black";
    //if( lastInsertedNode == node ) 
    //  color = "blue";
    if( ((RedBlackNode)node).getColor() == RedBlackColor.RED )
      color = "red";
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
  
  
}
