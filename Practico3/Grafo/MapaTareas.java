package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MapaTareas<T> {
	
	private HashMap <Integer, Tarea> tareas;
    private GrafoDirigido <T> grafo;
    private ArrayList<ArrayList<Integer>> caminos;
    
    
    public MapaTareas(HashMap<Integer, Tarea> tareas, GrafoDirigido<T> grafo) {
        this.tareas = tareas;
        this.grafo = grafo;
    }
    
    public HashMap<Integer, Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(HashMap<Integer, Tarea> tareas) {
		this.tareas = tareas;
	}

	public void agregarTarea(Tarea tarea){
        tareas.put(tarea.id, tarea);
    }

    public void agregarArcoTarea(Tarea tarea1, Tarea tarea2, T etiqueta){
        this.grafo.agregarArco(tarea1.id, tarea2.id,etiqueta);
    }
    
	public Iterator<Integer> obtenerTareas() {
		return this.tareas.keySet().iterator();
	}
	
    public void agregarTareasGrafo() {
    	Iterator<Integer> iteratorTarea = this.obtenerTareas();
    	while (iteratorTarea.hasNext()) {
    		int it = iteratorTarea.next();
    		grafo.agregarVertice(it);
    	}
    }
    
//    public ArrayList<Integer> camino_simple(Tarea origen,Tarea destino){
//		ArrayList<Tarea>camino= new ArrayList<Tarea>();
//		camino.add(origen);
//		int duracion= origen.duracion;
//		Iterator<Integer> adyacentesTareas=grafo.obtenerAdyacentes(origen.id);
//		while(adyacentesTareas.hasNext()) {
//			int ady= adyacentesTareas.next();
//			Iterator<Tarea> AdyacentesdeOrigen = buscarTarea(ady).;
//		}
//		while(AdyacentesdeOrigen.hasNext()) {
//			int ady= AdyacentesdeOrigen.next();
//			if (grafo.existeArco(origen.id, ady)){
//				duracion+=(int)grafo.obtenerArco(origen.id, ady).getEtiqueta();
//			}
//			ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
//			copia.add(ady);
//			caminos(ady,destino.id,copia,duracion);
//		}
//		//se queda con camino mas largo 
//		return buscaCaminoLargo();
//	}
//    
//    private void caminos(int verticeOrigen, int verticeDestino2, ArrayList<Integer> camino,int duracion) {
//		if (verticeOrigen==verticeDestino2){
//			caminos.add(camino);
//		}else {
//			Iterator<Integer> AdyacentesdeOrigen = grafo.obtenerAdyacentes(verticeOrigen);
//			if (AdyacentesdeOrigen!=null) {
//				while(AdyacentesdeOrigen.hasNext()) {
//					int ady= AdyacentesdeOrigen.next();
//					if (grafo.existeArco(verticeOrigen, ady)){
//						duracion+=(int)grafo.obtenerArco(verticeOrigen, ady).getEtiqueta() + grafo.obtenerVertice(ady).;
//					}
//					ArrayList<Integer>copia=(ArrayList<Integer>)camino.clone();
//					if (!copia.contains(ady)){
//						copia.add(ady);
//						caminos(ady,verticeDestino2,copia,duracion);
//					}
//				}
//			}
		//}
	//}

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
	
	private Tarea buscarTarea(int id) {
		return tareas.get(id);
	}

}
