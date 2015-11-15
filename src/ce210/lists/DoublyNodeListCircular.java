package ce210.lists;

public class DoublyNodeListCircular<T> {
	private int nofelements;
	private DNode<T> head,tail;
	
	public DoublyNodeListCircular(){
		nofelements = 0;
		head = tail = null;
	}

	//return the number of stored elemenents in list.
	public int size(){
		return nofelements;
	}

	//check if list is empty
	public boolean isEmpty(){
		return (nofelements < 1);
	}

	//if node v is first node
	public boolean isFirst(DNode<T> v){
		return (v == head);
	}

	//if node v is last	
	public boolean isLast(DNode<T> v) {
      	return (v == tail);
    }

	//return the first node of the list
	public DNode<T> first(){
		if (isEmpty()){
			System.out.println("List is empty");
		}
		return head;
	}

	//return tail
	public DNode<T> last(){
		if (isEmpty()){
			System.out.println("List is empty");
		}
		return tail;
	}

	//add first node
	private DNode<T> addFirstNode(T element){
		if ( head != null || tail != null){
			return null;
		}
		DNode<T> q = new DNode<T>(null,null,element);
		head = tail = q;
		q.setNext(q);
		q.setPrev(q);
		nofelements++;
		return q;
	}
	
	// delete last node
	private T deleteLastNode(){
		if ( size() == 1 ){
			DNode<T> q = head;
			head.setNext(null);
			tail.setPrev(null);
			head = tail = null;
			nofelements--;
		}
		return null;
	}

	//insert element at the beginning of the list
	public DNode<T> insertFirst(T element){
		if ( isEmpty() ){
			return addFirstNode(element);
		}
		return insertBefore(head, element);
	}

	//insert element at the end of the list
	public DNode<T> insertLast(T element){
		if ( isEmpty() ){
			return addFirstNode(element);
		}
		return insertAfter(tail,element);
	}

	//insert element before node 'p'
	public DNode<T> insertBefore(DNode<T> p , T element){
		DNode<T> q;
		if (p==head){
			q = new DNode<T>(tail,head,element);
			head.setPrev(q);
			head = q;
		}
		else {
			q = new DNode<T>(p.getPrev(),p,element);
			p.getPrev().setNext(q);
			p.setPrev(q);
		}
		nofelements++;
		return q;
	}

	//insert node 'q' after node p	
	public DNode<T> insertAfter(DNode<T> p , T element){
		DNode<T> q;
		if (p == tail){
			q = new DNode<T>(tail,head,element);
			tail.setNext(q);
			tail = q;
		}
		else{
			q = new DNode<T>(p,p.getNext(),element);
			p.getNext().setPrev(q);
			p.setNext(q);
		}
		nofelements++;
		return q;
	}

	//delete node at given position

	public T delete(int pos){
		DNode<T> q;
		int i=0;
		if (pos >= size() || pos <0){
			return null;
		}
	
		for ( i =0, q=head; q!=head && i<pos; q=q.getNext(), i++){	
		}
		return delete(q);
	}

	//delete node 'p' from the list
	public T delete(DNode<T> p){
		if (size() <=1 ){
			return deleteLastNode();
		}
		
		DNode<T> pPrev=null, pNext=null;
		if ( p!=head ){
			p.getPrev().setNext(p.getNext());
		}
		if ( p!=tail){
			p.getNext().setPrev(p.getPrev());
		}

		if (p==head){
			head = head.getNext();
		}
		if (p==tail){
			tail = tail.getPrev();
		}

		nofelements--;
		p.setNext(null);
		p.setPrev(null);
		return p.getElement();
	}


	//catenate list with list 's'
	public void catenate(DoublyNodeListCircular<T> s){
		if (s.isEmpty()){
			return;
		}

		if (isEmpty()){
			head = s.first();
		}
		else{
			s.first().setPrev(tail);
			tail.setNext(s.first());
		}

		tail = s.last();
		nofelements += s.size();
		s.reset();
	} 

	protected void reset() {
		head = tail = null;
		nofelements = 0;
	}


	public String toString() {
     	String str = "";
     	if( isEmpty() ) {
       		str = "List is empty\n";
       	return str;
     	}
     	DNode<T> p = first();
    	for (int i=0; i<nofelements; i++) {
      		str += p.getElement().toString() + "\n";
       		p = p.getNext();
     	}
    	return str;
   }
 
   
    // Print the elements of the list in standard output.
   	public void printList() {
     	System.out.println("\n----- Size: "+size()+" --------");
     	System.out.println( toString() );
   	}

	
}
