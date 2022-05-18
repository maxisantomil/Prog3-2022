package Practico1_ejercicio8;

public  class NodeDoble<T> {
	 private T data;
	 private NodeDoble<T> next;
	 private NodeDoble<T> previous;

	  NodeDoble(T data,NodeDoble<T> previous,NodeDoble<T> next ){
	        this.data = data;
	        this.next = next;
	        this.previous=previous;
	    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeDoble<T> getNext() {
		return next;
	}

	public void setNext(NodeDoble<T> next) {
		this.next = next;
	}

	public NodeDoble<T> getPrevious() {
		return previous;
	}

	public void setPrevious(NodeDoble<T> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		//return "NodeDoble [data=" + data + ", next=" + next + ", previous=" + previous + "]";
		String data = this.getData().toString();
		if (this.getNext()!=null) {
			data+= " "+ this.getNext().toString();
		}
		return data;
	}
}
