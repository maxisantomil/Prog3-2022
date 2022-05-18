package Practico1;

import java.util.Comparator;

public class Node<T> implements Comparable<Node<T>> {

    private T data;
    private Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }


    public Node<T> next (){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
         this.data = data;
    }

  
    public int compare(Node<T> node){
        return (Integer) this.data - (Integer) node.getData();
    }

    @Override
    public int compareTo(Node<T> node) {    
        return (Integer) this.data - (Integer) node.getData();
    }
    
@Override
    public String toString(){       
       return data.toString();
    }
}
