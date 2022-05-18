package Practico1;

import java.util.Iterator;

/*
Ejercicios prácticos
Ejercicio 1.
Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)
*/
public class MyList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void insertFront(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    public T extractFront() {
    	if (this.size> 0) {
        Node<T> temp = this.head;
        Node<T> aux = head.next();
        this.head = aux;
        this.size--;
        return temp.getData();
    	} else
    		return null;

    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public T getIndex(int index) {
        if (index == 0)
            return head.getData();
        if (index > this.size - 1)
            return null;
        Node<T> temp = head.next();
        for (int i = 1; i < index; i++) {
            temp = temp.next();
        }
        return temp.getData();
    }

    public int size() {
        return size;
    }

    public String toString() {
    	if (this.size>0) {
        String result = this.head.toString();
        Node<T> temp = head.next();

        while (temp != null) {
            result += " " + temp.toString();
            temp = temp.next();
        }

        return result;
    	} 
    	return null;
    }

/**
 * @brief busca un indice en la lista a partir del dato
 * @param data parametro que se esta buscando dentro de mis lista 
 * @return retorna el indice del parametro dentro de la lista
 */

    public int indexOf(T data) {
        if (this.head == null)
            return -1;
        if (this.head.getData().equals(data))
            return 0;
        Node<T> temp = head.next();
        int index = 1;
        while (temp != null) {
            if (temp.getData().equals(data))
                return index;
            temp = temp.next();
            index++;
        }
        return -1;
    }

    public void sort() {
    	  Node<T> temp = head; // direccion de memoria head
        for (int i = 0; i < this.size; i++) {
            Node<T> aux = head.next(); // direccion de memoria al siguiente nodo del head
            while (aux != null) {
                if (temp.compare(aux) > 0) {
                    T tempData = temp.getData(); // guardo en un auxiliar los datos del head
                    temp.setData(aux.getData()); // reemplazo los datos del head por los datos del siguiente nodo al
                                                 // head
                    aux.setData(tempData); // seteo en el auxiliar los datos del head
                }
                temp = aux;
                aux = aux.next();
            }
        }
    }

    @Override
    public MyListIterator<T> iterator() {
        return new MyListIterator<>(this);      
    }

}