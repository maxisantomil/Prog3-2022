package Ejercicio1Practico2;

import java.util.ArrayList;

// O(n) porque en el peor de los casos tiene que entrar recursivamente hasta el ultimo elemento del arreglo. 
public class Ejercicio1 {
	
	public static boolean isOrder(int[] arr,int n) {
		if (n < arr.length - 1){
			if (arr[n]< arr[n+1]) {
				return isOrder(arr,n+1);
			}
			return false;
		}
		else 
			return true;
	}
	
	public static boolean isOrderLista(ArrayList<Integer> list,int n) {
		if (n < list.size()-1){
			if (list.get(n)< list.get(n+1)) {
				return isOrderLista(list,n+1);
			}
			return false;
		}
		else 
			return true;
	}

	public static void main(String[] args) {
		int [] arr = {1,2,4,5,8,10};
		ArrayList<Integer>list= new ArrayList<>();
		list.add(1);
		list.add(9);
		list.add(3);
		list.add(4);
		System.out.println(isOrder(arr,0));
		System.out.println(isOrderLista(list,0));

	}

}


