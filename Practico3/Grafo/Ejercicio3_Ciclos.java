package Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class Ejercicio3_Ciclos{
	private HashMap<Integer,String> colores;
	private HashMap<Integer,Integer> visitados;
	private HashMap<Integer,Integer> finales;
	private Grafo grafo;
	private int tiempo;
	
	public Ejercicio3_Ciclos(Grafo<?> grafo) {
		this.grafo=grafo;
		this.colores= new HashMap();
		this.visitados= new HashMap();
		this.finales= new HashMap();
	}
	
	public void dfs_ciclo() {
		Iterator<Integer> iteratorGrafo = grafo.obtenerVertices();
		while (iteratorGrafo.hasNext()) {
			int verticeId=iteratorGrafo.next();
			this.colores.put(verticeId, "blanco");
		}
		tiempo=0;
		
		iteratorGrafo = grafo.obtenerVertices();
		while (iteratorGrafo.hasNext()) {
				int verticeId= iteratorGrafo.next();
			if (colores.get(verticeId).equals("blanco")) {
				dfs_visit(verticeId);
			}
			else {
				// EJERCICIO 3 , SE AGREGA CONDICION PARA DETECTAR CICLOS.
					System.out.println("Hay Ciclo");
			}
		}
	}

	private void dfs_visit(int verticeId) {
		
		colores.put(verticeId,"amarillo");
		tiempo=tiempo+1;;
		visitados.put(verticeId,tiempo);
		Iterator<Integer> iteratorAdyacentesDe = grafo.obtenerAdyacentes(verticeId);
		while (iteratorAdyacentesDe.hasNext()) {
			int verticeAdy= iteratorAdyacentesDe.next();
			if (colores.get(verticeAdy).equals("blanco")) {
				dfs_visit(verticeAdy);
			}
		}
		colores.put(verticeId, "negro");
		tiempo=tiempo+1;
		finales.put(verticeId, tiempo);
	}

	public HashMap<Integer, String> getColores() {
		return colores;
	}

	public void setColores(HashMap<Integer, String> colores) {
		this.colores = colores;
	}

	public HashMap<Integer, Integer> getVisitados() {
		return visitados;
	}

	public void setVisitados(HashMap<Integer, Integer> visitados) {
		this.visitados = visitados;
	}

	public HashMap<Integer, Integer> getFinales() {
		return finales;
	}

	public void setFinales(HashMap<Integer, Integer> finales) {
		this.finales = finales;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
}
