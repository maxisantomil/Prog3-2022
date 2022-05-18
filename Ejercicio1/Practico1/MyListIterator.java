package Practico1;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {

    private Node<T> head;

    MyListIterator(MyList<T> list) {
        this.head = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return head != null;       
    }

    @Override
    public T next() {
        T data = head.getData();
        this.head = head.next();
        return data;      
    }
    
    
    public void forward() {
    	if(this.head!=null)
    		this.head = head.next();           
    }

    public T getValor() {
    	if(this.head!=null)
    		 return this.head.getData();
    	
    	return null;
    }
    
}
