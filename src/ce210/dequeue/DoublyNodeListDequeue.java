package ce210.dequeue;

import ce210.lists.*;

public class DoublyNodeListDequeue<T> extends DoublyNodeList {

	public void inject(T element){
		insertLast(element);
	}

	public T eject(){
		if (isEmpty()){
			System.out.println("Dequeue is empty.");
			return null;
		}
		
		DNode<T> last = last();
		delete(last);
		return last.getElement();
	}

	public T pop(){
		if (isEmpty()){
			System.out.println("Dequeue is empty.");
			return null;
		}
		
		DNode<T> first = first();
		delete(first);		
		return first.getElement();
	}

	public void push(T element){
		insertFirst(element);
	}
}
