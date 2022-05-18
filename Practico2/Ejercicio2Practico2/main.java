package Ejercicio2Practico2;

import java.util.ArrayList;

/*Ejercicio 2.
Implemente un algoritmo recursivo para buscar un elemento en una lista simple.
Implemente, además, un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente [1 2 3 …].
1. ¿Qué complejidad O tienen estos algoritmos?
2. ¿En qué afecta la estructura a estos algoritmos?
3. ¿Cambia algo que la estructura esté ordenada?
*/	
public class main {

	public static <T> int buscarElemento(ArrayList<T>list,T elemento,int pos) {
		if (pos < list.size()){
			if (list.get(pos) != elemento) {
				return buscarElemento(list,elemento,pos+1);
			}
			else return pos;
		}
		return -1;
	}
	
	
	// Una Búsqueda Binaria para un arreglo de n elementos tarda en el peor de los casos log2(n) iteraciones para encontrar la respuesta.
	public static int buscarElementoArreglo(int[]A,int x, int inicio, int fin) {
		int medio;
		if (fin < inicio)
			return -1; //sucederá si no se encuentra el elemento
		else {
			medio = (inicio + fin) / 2; //al ser medio un int, se realiza un truncado
		if (x > A[medio])
			return buscarElementoArreglo(A, x, medio+1, fin);
		else
		if (x < A[medio])
			return buscarElementoArreglo(A,x, inicio, medio -1);
		else
			return medio;
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer>arrayList = new ArrayList<>();
		int[] arr = {1,2,3,4,5,6};
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		int elemento = 5;
		//buscarElemento(arrayList,elemento,0);
		System.out.println(buscarElemento(arrayList,elemento,0));
		System.out.println(buscarElementoArreglo(arr, elemento, 0, arr.length));
	}

}
