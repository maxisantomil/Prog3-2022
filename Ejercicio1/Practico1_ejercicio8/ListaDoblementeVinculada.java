package Practico1_ejercicio8;

public class ListaDoblementeVinculada<T> {
	  private NodeDoble<T> head;
	  private NodeDoble<T> last;
	  private int size;
	  
	  ListaDoblementeVinculada() {
	        this.head = null;
	        this.last = null;
	        this.size = 0;
	    }

	  public void insertFront(T data) {
		  NodeDoble<T> nodeD = new NodeDoble<T>(data,null,head);
		  if (this.head == null) {
			  this.head=nodeD;
			  this.last=nodeD;
			  size++;
		  }
		  else 
		  {
			  //nodeD.setNext(head);
			  this.head.setPrevious(nodeD);
			  this.head=nodeD;
			  size++;
		  }
	  }
	  
	  public NodeDoble<T> getHead() {
	        return this.head;
	    }

	  public int size() {
		  return this.size;
	  }
	  
	  public T get(int index) {
		if ((index > size) && (index<1))
		  return null;
		else {
		  	int i = 1;
		  	NodeDoble<T> aux = head;
		  	while (i < index) {
		  		aux = aux.getNext();
		  		i++;
		  	}
		  	return aux.getData(); 	
	  	} 
	  }

	public NodeDoble<T> getLast() {
		return last;
	}

	public void setLast(NodeDoble<T> last) {
		this.last = last;
	}

	public void setHead(NodeDoble<T> head) {
		this.head = head;
	}

	@Override
	public String toString() {
		//return "ListaDoblementeVinculada [head=" + head + ", last=" + last + ", size=" + size + "]";
		return this.head.toString();
	}
	  
	  
}
