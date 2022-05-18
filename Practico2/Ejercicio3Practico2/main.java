package Ejercicio3Practico2;

/*Ejercicio 3.
Implemente un algoritmo recursivo que convierta un número en notación decimal a su
equivalente en notación binaria.
*/
public class main {

	
	public static String notacionbinariaX(int numero) {
		int resultado = numero%2;
		if (numero/2 !=0) {
			return notacionbinariaX(numero/2) +""+ resultado;
		}
		return resultado + "";
	}
	public static void main(String[] args) {
		int valor = 5;
		System.out.println("la notacion binaria de "+valor+" es : "+ notacionbinariaX(valor));
	}

}
