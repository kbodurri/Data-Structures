package ce210.fifo;

import ce210.lists.*;

public class SinglyNodeListFIFO<T> extends SinglyNodeList {
	protected int nofElements;
	protected SNode<T> head,tail;

	//enqueue
	public void enqueue(T element){
		SNode<T> x = new SNode<T>(null,element);
		if (isEmpty()){
			head = tail = x;
		}
		else{
			tail.setNext(x);
			tail = x;
			nofElements++;
		}
	}

	public T dequeue(){
		SNode<T> tmp;

		if (isEmpty()){
			System.out.println("Fifo is empty.");
			return null;
		}
		
		tmp = head;
		head = head.getNext();
		tmp.setNext(null);
		nofElements--;
		if (nofElements==0){
			tail = null;
		}
		return tmp.getElement();
	}
}
