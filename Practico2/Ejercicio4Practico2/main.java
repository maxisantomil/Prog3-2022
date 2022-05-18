package Ejercicio4Practico2;
/*
 * Ejercicio 4.
Implemente un algoritmo de ordenamiento por selección en un arreglo.
Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
1. ¿Qué complejidad O tienen estos algoritmos?

 */
public class main {

	private static int buscarMenor(int arr[],int pos) {
		int valorMenor= arr[pos];
		int posMenor =pos;
		for (int i=pos+1;(i < arr.length);i++){
			if (arr[i] < valorMenor){
				valorMenor = arr[i];
				posMenor=i;
			}
		}
		return posMenor;
	}
	
// creo que la complejidad del metodo ordenar es de O(n2)
	public static void ordenarSeleccion(int[]arr,int posInicial) {
		int valor=0;
		if (posInicial < arr.length) {
			int posMenor= buscarMenor(arr,posInicial); // O(n) n es la cantidad de elementos del arreglo
			valor = arr[posInicial];
			arr[posInicial]= arr[posMenor];
			arr[posMenor]= valor;
			ordenarSeleccion(arr,posInicial+1); //  O(n)
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {2,1,4,10,9,5};
		ordenarSeleccion(arr,0);
		for (int i=0; i< arr.length;i++) {
			System.out.print(" "+ arr[i]);
		}
	}

}
