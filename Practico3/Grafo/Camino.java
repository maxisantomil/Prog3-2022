package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Camino {
	private Grafo grafo;
	private int verticeOrigen;
	private int verticeDestino;
	private ArrayList<ArrayList<Integer>> caminos;
	
	public Camino(Grafo g,int verticeOrigen, int verticeDestino) {
		this.grafo=g;
		this.verticeOrigen=verticeOrigen;
		this.verticeDestino=verticeDestino;
		this.caminos = new ArrayList<ArrayList<Integer>>();
	}
	
	public ArrayList<Integer> camino_simple(){
		ArrayList<Integer>camino= new ArrayList<Integer>();
		camino.add(verticeOrigen);
		Iterator<Integer> AdyacentesdeOrigen = grafo.obtenerAdyacentes(verticeOrigen);
		while(AdyacentesdeOrigen.hasNext()) {
			int ady= AdyacentesdeOrigen.next();
			ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
			copia.add(ady);
			caminos(ady,verticeDestino,copia);
		}
		//se queda con camino mas largo 
		return buscaCaminoLargo();
	}

	public ArrayList<Integer> camino_masCorto(){
		ArrayList<Integer>camino= new ArrayList<Integer>();
		camino.add(verticeOrigen);
		Iterator<Integer> AdyacentesdeOrigen = grafo.obtenerAdyacentes(verticeOrigen);
		while(AdyacentesdeOrigen.hasNext()) {
			int ady= AdyacentesdeOrigen.next();
			ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
			copia.add(ady);
			caminos(ady,verticeDestino,copia);
		}
		//se queda con camino mas corto 
		return buscaCaminoCorto();
	}
	
	private void caminos(int verticeOrigen, int verticeDestino2, ArrayList<Integer> camino) {
		if (verticeOrigen==verticeDestino2){
			caminos.add(camino);
		}else {
			Iterator<Integer> AdyacentesdeOrigen = grafo.obtenerAdyacentes(verticeOrigen);
			if (AdyacentesdeOrigen!=null) {
				while(AdyacentesdeOrigen.hasNext()) {
					int ady= AdyacentesdeOrigen.next();
					ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
					if (!copia.contains(ady)){
						copia.add(ady);
						caminos(ady,verticeDestino,copia);
					}
				}
			}
		}
	}

	private ArrayList<Integer> buscaCaminoLargo() {
		int largo=0;
		ArrayList<Integer>camino= new ArrayList<Integer>();
		for (ArrayList c :caminos) {
			if (c.size()>largo) {
				camino=c;
				largo=c.size();
			}
		}
		return camino;
	}
	
	private ArrayList<Integer> buscaCaminoCorto(){
		int largo=0;
		ArrayList<Integer>camino= new ArrayList<Integer>();
		for (ArrayList c :caminos) {
			if (largo==0) {
				camino=c;
				largo=c.size();
			}
			if (c.size()<largo) {
				camino=c;
				largo=c.size();
			}
		}
		return camino;
	}
	
	public ArrayList<Integer> camino_cortado(int prohibido){
		ArrayList<Integer>camino= new ArrayList<Integer>();
		camino.add(verticeOrigen);
		Iterator<Integer> AdyacentesdeOrigen = grafo.obtenerAdyacentes(verticeOrigen);
		while(AdyacentesdeOrigen.hasNext()) {
			int ady= AdyacentesdeOrigen.next();
			ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
			if (prohibido != ady) {
				copia.add(ady);
				caminos_cort(ady,verticeDestino,copia,prohibido);
			}
		}
		//se queda con camino mas largo 
		return buscaCaminoLargo();
	}
	
	private void caminos_cort(int verticeOrigen, int verticeDestino2, ArrayList<Integer> camino, int prohibido) {
		if (verticeOrigen==verticeDestino2){
			caminos.add(camino);
		}else {
			Iterator<Integer> AdyacentesdeOrigen = grafo.obtenerAdyacentes(verticeOrigen);
			if (AdyacentesdeOrigen!=null) {
				while(AdyacentesdeOrigen.hasNext()) {
					int ady= AdyacentesdeOrigen.next();
					if (ady!=prohibido) {
					ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
					if (!copia.contains(ady)){
						copia.add(ady);
						caminos(ady,verticeDestino,copia);
						}
					}
				}
			}
		}
	}
	
	//Encontrar caminos con caminos bloqueado.
	public ArrayList< ArrayList<Integer> > encontrarCaminosColor(int origen, int destino, HashMap <Integer, String> colores) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> camino = new ArrayList<>();
		camino.add(origen);
		Iterator <Integer> adyacentes=grafo.obtenerAdyacentes(origen);
		while(adyacentes.hasNext()){
			Integer actual=adyacentes.next();
			if(!colores.get(actual).equals("rojo")){
				System.out.println("color actual " + colores.get(actual));
				ArrayList<Integer> copia = (ArrayList<Integer>) camino.clone();
				copia.add(actual);
				caminosColor(actual,destino, copia,res, colores);
			}
		}
		
		return res;
	}

	private void caminosColor(Integer origen, int destino, ArrayList<Integer> camino, ArrayList<ArrayList<Integer>> res, HashMap<Integer, String> colores) {
		if(origen.equals(destino)){
			res.add(camino);
		}else{
			Iterator <Integer> adyacentes=grafo.obtenerAdyacentes(origen);
			while(adyacentes.hasNext() && adyacentes!=null){
				Integer actual=adyacentes.next();
				if(!colores.get(actual).equals("rojo")){
					System.out.println("color actual en caminos " + colores.get(actual));
					ArrayList<Integer> copia = (ArrayList<Integer>) camino.clone();
					if(!copia.contains(actual)){
						copia.add(actual);
						caminosColor(actual,destino, copia,res,colores);
					}	
				}	
			}
		}
	
	}
	
	//Ejercicio 5 , quedarte con los nodos no repetidos
}
