package Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Vertice<T> {
	int verticeId;
	LinkedList<Arco<T>>arcos;
	
	public int getVerticeId() {
		return verticeId;
	}

	public void setVerticeId(int verticeId) {
		this.verticeId = verticeId;
	}

	public LinkedList<Arco<T>> getArcos() {
		return arcos;
	}

	public void setArcos(LinkedList<Arco<T>> arcos) {
		this.arcos = arcos;
	}

	public Vertice(int verticeId) {
		this.verticeId=verticeId;
		arcos = new LinkedList<Arco<T>>();
	}

	public void agregarArco(Arco<T> aux) {
		this.arcos.add(aux);
	}
	
	
	public boolean existeArco(int idAdyacente) {
		boolean result= false;
		for (Arco<T> a: arcos ) {
			if (a.getVerticeDestino()==idAdyacente){
				return result=true;
			}
		}
		return result;
	}
	
	public void borrarArco(int idAdyacente) {
		if (existeArco(idAdyacente)) {
			Arco<T> arcoAux =null;
			for (Arco<T> a: arcos ) {
				if (a.getVerticeDestino()==idAdyacente){
					arcoAux= a;
				}
			}
			arcos.remove(arcoAux);
		}
	}

	public Arco<T> devolverArco(int idAdyacente) {
		//return arcos.get(verticeId2);
		Arco<T> arcoAux =null;
		for (Arco<T> a: arcos ) {
			if (a.getVerticeDestino()==idAdyacente){
				arcoAux= a;
			}
		}
		return arcoAux;
	}
	
	public int cantArcos() {
		return this.arcos.size();
	}
	public Iterator<Integer> obtenerAdyacentes(){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (Arco<T> a: arcos ) {
			aux.add(a.getVerticeDestino());
		}
		return aux.iterator();
	}
	
}
