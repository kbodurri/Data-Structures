package ce210.lists;
import ce210.lists.*;

public class SinglyNodeListCircular<T> {
	protected int nofelements;
	protected SNode<T> head, tail;

	public SinglyNodeListCircular() {
		nofelements = 0;
		head = tail = null;
	}

 	 //returns the number of stored elements in list.  
	 public int size() {
    	return nofelements;
 	 }

 	 /**
  	 * Checks whether the list is empty.
  	 */
 	 public boolean isEmpty() {
   		return (nofelements < 1);
 	 }

 	 /**
 	  * Checks whether the provided node is the first node in list.
  	 */
 	 public boolean isFirst(SNode<T> v) {
   		return v == head;
 	 }

 	 /**
  	 * Returns the first node of the list.
  	 */
 	 public SNode<T> first() {
   		 if( isEmpty() ) {
     		 System.out.println("List is empty");
    	 }
   		 return head;
 	 }

  /**
   * Returns the last node of the list.
   */
 	 public SNode<T> last() {
   		 if( isEmpty() ) {
     		 System.out.println("List is empty");
   		 }
   	 	 return tail;
 	 }

	//insert element in the end of the list
 	public SNode<T> insertLast(T element){
		if (!isEmpty()){
			return insertAfter ( last() , element);
		}
		else{
			return insertFirst(element);
		}
	}

	//insert element after node p
	public SNode<T> insertAfter(SNode<T> p, T element ){
		if (isEmpty()){
			System.out.println("List is empty.Not allowed to use \"insertAfter\" function ");
			return null;
		}
		nofelements++;
		SNode<T> q = new SNode<T>(p.getNext(), element);
		if (p.getNext() == head){
			tail = q;	
		}
		p.setNext(q);
		return q;
	}

	//insert element at the beginning of the list
	public SNode<T> insertFirst(T element){
		//when the list is empty head == null
		SNode<T> q = new SNode<T>(head,element);
		head = q;
		if (nofelements == 0){
			 tail = head;
		}
		tail.setNext(head);
		nofelements++;
		return q;
	}

	//delete node after node 'p'
	public T deleteAfter(SNode<T> p){
		SNode<T> pNext = p.getNext();
		p.setNext(pNext.getNext());
		if (p == tail){
			head = pNext.getNext();
		}
		
		if (pNext == tail){
			tail = p;
		}

		nofelements--;
		return pNext.getElement();
	}
	
	//delete first node
	public T deleteFirst(){
   	 	if (nofelements == 0){
     	 	System.out.println("The list is empty. You can't delete nodes!!!\n");
      		return null;
    	}
    	return deleteAfter(tail);
  	}
	
	//delete node at the given position
  	public T delete(int pos){
    	if (pos < 0 | pos >= size()){
      		System.out.println("ERROR -> pos must be in the interval [0, size)\n");
      		return null;
    	}
    	else{
      		SNode<T> current = head, prv = null;
      		for (int i = 0; i < pos; i++){
        		prv = current;
        		current = current.getNext();
     	}
     	 return deleteAfter(prv);
    	}
  	}
	
	//delete the last node of the list
  	public T deleteLast(){
    	return delete(size() - 1);
  	}
	
	//catenate list with list 's'
  	public void catenate(SinglyNodeListCircular<T> s){
    	if (s.isEmpty()){
      		return;
    	}

    	if (isEmpty()){
     		head = s.first();
    	}

    	else{
      		tail.setNext(s.first());
    	}

    	tail = s.last();
    	tail.setNext(head);
    	nofelements = nofelements + s.size();
    	s.setEmpty();
  	}

	//set the list empty.	
  	public void setEmpty(){
    	head = tail = null;
    	nofelements = 0;
  	}
	
	//Method is based on the toString of the elements' class
	public String toString() {
		String str="";
    	if( isEmpty() ) {
   		str = "List is empty\n";
      		return str;
    	}
    	SNode<T> p = first();
    	for (int i=0; i<nofelements; i++) {
      		str += p.getElement().toString()+"\n";
      		p = p.getNext();
    	}
    	return str;
  	}
  
  	/**
   	* Print the elements of the list in standard output.
   	*/
  	public void printList() {
    		System.out.println( toString() );
  	}

}
