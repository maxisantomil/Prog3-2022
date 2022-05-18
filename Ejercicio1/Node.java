
public class Node {
	private Object info;
	private Node next;

	public Node() {
		info =  null;
		next = null;
	}

	public Node(Object o, Node n) {
		setInfo(o);
		setNext(n);
	}

	public void setNext(Node n) {
		next = n;
		
	}

	public void setInfo(Object o) {
		info = o;
	}

	public Object getInfo() {
		return info;
	}

	public Node getNext() {
		return next;
	}

	@Override
	public String toString() {
		return "Node [info=" + info + ", next=" + next + "]";
	}
	
}
