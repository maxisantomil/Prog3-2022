package Ejercicio7Practico2;
/*
Ejercicio 7.
Implemente la estructura de �?rbol Binario para búsquedas.
Métodos:
�? Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List
getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?
 */
public class main {

	public static void main(String[] args) {
	Tree arbol = new Tree(9);
	arbol.add(5);
	arbol.add(15);
	System.out.println(arbol.isEmpty());
	System.out.println(arbol.getSize());
	arbol.printInOrder();
	System.out.println("el elemento maximo del arbol es: "+arbol.getMaxElem());
	System.out.println(arbol.getFrontera());
	System.out.println(arbol.getElemAtLevel(0));
	System.out.println(arbol.getLongestBranch());
	System.out.println(arbol.getHeight());
	System.out.println(arbol.delete(2));
	System.out.println(arbol.isEmpty());
	System.out.println(arbol.getSize());
	arbol.printInOrder();
	}


}
