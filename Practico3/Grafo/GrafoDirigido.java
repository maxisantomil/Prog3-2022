package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T>{
	
	HashMap <Integer, Vertice> mapVertices = new HashMap <Integer, Vertice> ();
	
		@Override
		public void agregarVertice(int verticeId) {
			if (!mapVertices.containsKey(verticeId)){
				mapVertices.put(verticeId, new Vertice(verticeId));
			}

		}

		@Override
		public void borrarVertice(int verticeId) {
			if (mapVertices.containsKey(verticeId)) {
				borrardeAdyacente(verticeId);
				mapVertices.remove(verticeId);
			}

		}

		private void borrardeAdyacente(int verticeId) {
			for (Vertice<T> v: mapVertices.values()) {
				if (v.getVerticeId()!=verticeId) {
					v.borrarArco(verticeId);
				}
			}
			
		}

		@Override
		public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
			Arco<T> aux = new Arco(verticeId1,verticeId2,etiqueta);
			
			if (mapVertices.containsKey(verticeId1)&& mapVertices.containsKey(verticeId2)){
				if (!mapVertices.get(verticeId1).existeArco(verticeId2)) {
					mapVertices.get(verticeId1).agregarArco(aux);
				}
			}

		}

		@Override
		public void borrarArco(int verticeId1, int verticeId2) {
			
			if (mapVertices.containsKey(verticeId1)) {
				mapVertices.get(verticeId1).borrarArco(verticeId2);
			}

		}

		@Override
		public boolean contieneVertice(int verticeId) {
			return this.mapVertices.containsKey(verticeId);
		}

		@Override
		public boolean existeArco(int verticeId1, int verticeId2) {
			boolean existe=false;
			if (mapVertices.containsKey(verticeId1)) {
				 existe = mapVertices.get(verticeId1).existeArco(verticeId2);
			}
			return existe;
		}

		@Override
		public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
			if (this.existeArco(verticeId1,verticeId2)) {
				return (this.mapVertices.get(verticeId1).devolverArco(verticeId2));
			}
			return null;
		}

		@Override
		public int cantidadVertices() {
			return this.mapVertices.size();
		}

		@Override
		public int cantidadArcos() {
			int totalArcos=0;
			for (Vertice v: mapVertices.values()) {
				totalArcos+= v.cantArcos();
				}
			
			return totalArcos;
		}

		@Override
		public Iterator<Integer> obtenerVertices() {
			ArrayList<Integer> aux = new ArrayList<Integer>();
			for (Vertice v: mapVertices.values()) {
				aux.add(v.getVerticeId());
				}
			return aux.iterator();
		}

		@Override
		//obtener adyacentes de un vertice dado. ???
		public Iterator<Integer> obtenerAdyacentes(int verticeId) {
			if (this.contieneVertice(verticeId))
				return mapVertices.get(verticeId).obtenerAdyacentes();
			return null;
		}

		@Override
		public Iterator<Arco<T>> obtenerArcos() {
			ArrayList<Arco<T>> aux = new ArrayList<Arco<T>>();
			for (Vertice v: mapVertices.values()) {
				aux.addAll(v.getArcos());
			}
			return aux.iterator();
		}

		@Override
		public Iterator<Arco<T>> obtenerArcos(int verticeId) {
			return mapVertices.get(verticeId).getArcos().iterator();
		}

		public Vertice obtenerVertice(int id) {
			return mapVertices.get(id);
		}
}
