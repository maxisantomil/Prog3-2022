package Ejercicio5Practico2;
/*
 * Ejercicio 5.
Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
1. ¿Cuál es su complejidad en el peor caso?
2. ¿Cuál es su complejidad promedio?

 */
public class main {

	public static void main(String[] args) {
	Mergesort mergesort = new Mergesort();
	Quicksort quicksort = new Quicksort();
	int[] arr = {2,1,4,10,9,5};
		mergesort.sort(arr);
		for (int i=0; i< arr.length;i++) {
			System.out.print(" "+ arr[i]);
		}
		System.out.println(" ");
	int[] arr2 = {2,1,4,10,9,5};
		quicksort.quicksort(arr2, 0, arr.length -1);
		for (int i=0; i< arr.length;i++) {
			System.out.print(" "+ arr[i]);
		}
	}
	
}
