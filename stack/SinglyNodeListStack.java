package ce210.stack;

import ce210.lists.*;

public class SinglyNodeListStack<T> extends SinglyNodeList{

	//method push
	public void push(T element){
		insertFirst(element);
	}

	//pop
	public T pop(){
		if (isEmpty()){
			System.out.println("Stack is empty");
		}
		return delete(0).getElement();
	}

	//top
	public T top(){
		if (isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		SNode<T> first = first();
		return first.getElement();
	}
}
