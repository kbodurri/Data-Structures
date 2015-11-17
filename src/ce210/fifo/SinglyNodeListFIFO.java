package ce210.fifo;

import ce210.lists.*;

public class SinglyNodeListFIFO<T> extends SinglyNodeList {
	protected int nofElements;
	protected SNode<T> head,tail;

	//enqueue
	public void enqueue(T element){
		insertLast(element);	
	}

	public T dequeue(){
		if (isEmpty()){
			System.out.println("Fifo is empty.");
			return null;
		} 	
		return (T)deleteFirst();
	}
}
