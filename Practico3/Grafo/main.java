package Grafo;

import java.util.Iterator;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Practico1.MyListIterator;

public class main {

	public static void main(String[] args) {
		GrafoDirigido<String> grafoD = new GrafoDirigido<String>();


		grafoD.agregarVertice(1);
		grafoD.agregarVertice(2);
		grafoD.agregarVertice(3);
		grafoD.agregarVertice(4);
		grafoD.agregarVertice(5);
		grafoD.agregarVertice(6);
		grafoD.agregarVertice(7);

		grafoD.agregarArco(1, 2, "etiqueta1");
		grafoD.agregarArco(1, 3, "etiqueta1");
		grafoD.agregarArco(2, 3, "etiqueta1");
		grafoD.agregarArco(3, 5, "etiqueta1");
		grafoD.agregarArco(1, 7, "etiqueta1");
		grafoD.agregarArco(5, 4, "etiqueta1");
		grafoD.agregarArco(2, 4, "etiqueta1");
		grafoD.agregarArco(7, 6, "etiqueta1");
		grafoD.agregarArco(4, 7, "etiqueta1");

		System.out.println("Cantidad de arcos:");
		System.out.println(grafoD.cantidadArcos());

		//"Borrar un arco:"
		//grafoD.borrarArco(1,3);


		System.out.println("Cantidad de vertices:");
		System.out.println(grafoD.cantidadVertices());
		
		//imprime los arcos que tiene el grafo
		Iterator<Arco<String>> iteratorArcos = grafoD.obtenerArcos();
		while (iteratorArcos.hasNext()) {
			System.out.println(iteratorArcos.next());	
		}
		
		//imprime los adyacentes que tiene x vertice
		Iterator<Integer> iteratorAdyacentes = grafoD.obtenerAdyacentes(3);
		while (iteratorAdyacentes.hasNext()) {
			System.out.println("Adyacente de 3: "+ iteratorAdyacentes.next());	
		}
		
		//imprime los arcos que tiene x vertice
		Iterator<Arco<String>> iteratorArcosVertice = grafoD.obtenerArcos(3);
		while (iteratorArcosVertice.hasNext()) {
			System.out.println(iteratorArcosVertice.next());	
		}
		

		//grafoD.borrarArco(3,4);
		System.out.println("Cantidad de vertices:");
		System.out.println(grafoD.cantidadVertices());
		System.out.println("Cantidad de arcos:");
		System.out.println(grafoD.cantidadArcos()); 

		/*BFS bfs = new BFS(grafoD);
		bfs.bfs();
		System.out.println(bfs.getVertices());
		
		Ejercicio3_Ciclos dfs_ciclo = new Ejercicio3_Ciclos(grafoD);
		dfs_ciclo.dfs_ciclo();
		System.out.println(dfs_ciclo);

		*/
		//Ejercicio 4 , busca el camino mas largo del grafo
		Camino c= new Camino(grafoD,1,6);
		System.out.println("camino cortado: "+ c.camino_cortado(4));
		System.out.println("camino mas largo: "+ c.camino_simple());
		System.out.println("camino mas corto: "+ c.camino_masCorto());
	    }
	}
