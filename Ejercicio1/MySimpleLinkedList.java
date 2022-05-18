
public class MySimpleLinkedList {
	protected Node first;
	
	public MySimpleLinkedList() {
		first = null;
	}
	public void insertFront(Object o) {
		Node tmp = new Node(o,null);
		tmp.setNext(first);
		first = tmp;
	}
	
	@Override
	public String toString() {
		return  "["+first.getInfo()+ first.getNext()+"]";
	}
}
