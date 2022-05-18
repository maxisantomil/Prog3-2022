package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import Practico1.MyList;

/*
 * BFS (G):
Vaciar la fila F.
Para cada vértices v de G
Marcar v como NO_VISITADO.
Para cada vértice v de G
Si v es NO_VISITADO:
BFS(G,v)

 */
public class BFS {
	private Grafo grafo;
	private Stack fila;
	private HashMap<Integer,String> vertices;
	
	public BFS(Grafo<?> grafo) {
		this.grafo=grafo;
		this.fila= new Stack();
		this.vertices= new HashMap();
	}
	
	public void bfs() {
		Iterator<Integer> iteratorGrafo = grafo.obtenerVertices();
		while (iteratorGrafo.hasNext()) {
			int verticeId=iteratorGrafo.next();
			this.vertices.put(verticeId, "NO_VISITADOS");
		}
		iteratorGrafo = grafo.obtenerVertices();
		while (iteratorGrafo.hasNext()) {
				int verticeId= iteratorGrafo.next();
			if (vertices.get(verticeId).equals("NO_VISITADOS")) {
				bfs(grafo,verticeId);
			}
		}
	}

	private void bfs(Grafo grafo2, int verticeId) {
		this.vertices.put(verticeId, "VISITADO");
		fila.push(verticeId);
		while(!fila.isEmpty()) {
			fila.pop();
			Iterator<Integer> iteratorAdyacentesDe = grafo.obtenerAdyacentes(verticeId);
			while (iteratorAdyacentesDe.hasNext()) {
				int verticeAdy= iteratorAdyacentesDe.next();
				if (vertices.get(verticeAdy).equals("NO_VISITADOS")) {
					this.vertices.put(verticeAdy, "VISITADO");
					this.fila.push(verticeAdy);
				}
			}	
		}
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
	public HashMap<Integer, String> getVertices() {
		return this.vertices;
	}

	public void setVertices(HashMap<Integer, String> vertices) {
		this.vertices = vertices;
	}

}
