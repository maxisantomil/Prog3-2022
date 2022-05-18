
public class main {
	public static void main(String[] args) {
		Node node1 =  new Node(1,null);
		Node node2 =  new Node(2,null);
		Node node3 =  new Node(3,null);
		Node node4 =  new Node(4,null);
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		list1.insertFront(node1);
		list1.insertFront(node2);
		list1.insertFront(node3);
		list1.insertFront(node4);
		
		System.out.println(list1.toString());
	}

}
