package Practico1;


public class main {

    public static void main(String[] args) {

        MyList<String> l = new MyList<String>();
        l.insertFront("a");
        l.insertFront("b");
        l.insertFront("c");
        l.insertFront("d");
        
        l.extractFront();
        l.extractFront();
        l.extractFront();
        l.extractFront();
        l.extractFront();

        System.out.println(l.toString());

        System.out.println(l.indexOf("b"));

        System.out.println(l.getIndex(3));

        Pila<Integer> p = new Pila<Integer>();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);

        System.out.println("retirar el ultimo elemento: " +p.pop());

        System.out.println(p);

        p.reverse();

        System.out.println(p);

        MyList<Integer> l1 = new MyList<Integer>();
        MyList<Integer> l2 = new MyList<Integer>();

       
        l1.insertFront(1);
        l1.insertFront(3);
        l1.insertFront(4);
        l1.insertFront(2);
        l1.insertFront(18);
        l1.insertFront(9);  
        l1.insertFront(1);

        System.out.println("Lista 1 :" + l1);
      
        l2.insertFront(4);
        l2.insertFront(7);
        l2.insertFront(18);
        l2.insertFront(1);
        l2.insertFront(2);
        
     
        System.out.println("Lista 2 :" + l2);
        // l1.sort();
        // l2.sort();

        System.out.println("Lista 1 :" + l1);
        System.out.println("Lista 2 :" + l2);

        MyList<Integer> rep = new MyList<Integer>();

        for (int i = 0; i < l1.size(); i++) {
            Integer tempData = l1.getIndex(i);
            if (l2.indexOf(tempData) != -1)
                rep.insertFront(tempData);
        }
        rep.sort(); // Se puede ordenar al finalizar?
        System.out.println("Repetidos " + rep);    
        
     

  /*       Ejercicio 5.
A partir de la clase Lista implementada en el ejercicio 1, implemente el patr贸n
iterator-iterable, para que la lista sea iterable. 驴Existe alguna ventaja computacional a la
hora de recorrer la lista de principio a fin si se cuenta con un iterador? */
MyListIterator<Integer> iterator = l1.iterator();
System.out.println("imprime con iterator: ");
while (iterator.hasNext()){
	System.out.print(iterator.next()+ " - ");
}
System.out.println(" ");
        System.out.println("TETS ITERATOR-ITERABLE");
        for(Integer i : l1) {
            System.out.print(i);        
        }
        System.out.println("\n");

/*
Ejercicio 6.
Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
suponiendo que: a) Las listas est醤 desordenadas y la lista resultante debe quedar
ordenada. b) Las listas est醤 ordenadas y la lista resultante debe mantenerse ordenada.    
 */
//LISTAS DESORDENADAS       
MyList<Integer> Repetidos = new MyList<Integer>();
MyListIterator<Integer> iteratorList = l1.iterator();
while (iteratorList.hasNext()) {
	int valor= iteratorList.next();
	if (l2.indexOf(valor)!=-1 && Repetidos.indexOf(valor)==-1) {
		Repetidos.insertFront(valor);
	}
	Repetidos.sort();
}
System.out.println("la lista tiene los siguientes elementos repetidos: "+ Repetidos);

//LISTAS ORDENADAS
MyList<Integer> l11 = new MyList<Integer>();
MyList<Integer> l22 = new MyList<Integer>();


l11.insertFront(10);


System.out.println("Lista 11 :" + l11);
System.out.println("Lista 22 :" + l22);

MyList<Integer> RepetidosOrdenados = new MyList<Integer>();
MyListIterator<Integer> iteratorList1 = l11.iterator();
MyListIterator<Integer> iteratorList2 = l22.iterator();
System.out.println("iterador 2 :" + iteratorList2.getValor());
System.out.println("iterador 1  :" + iteratorList1.getValor());

while (iteratorList1.hasNext() && iteratorList2.hasNext()) {
	if (iteratorList1.getValor()> iteratorList2.getValor())
		iteratorList2.next();
	else if  (iteratorList1.getValor()< iteratorList2.getValor()) 
		iteratorList1.next();	
	
	else {
		RepetidosOrdenados.insertFront(iteratorList1.getValor());
		iteratorList1.next();
		iteratorList2.next();
	}
}
System.out.println("la lista tiene los siguientes elementos repetidos: "+ RepetidosOrdenados);
/*        
Ejercicio 7.
Escriba una funci贸n que dadas dos listas construya otra con los elementos que est谩n en la
primera pero no en la segunda.
*/
        MyList<Integer> noRep = new MyList<Integer>(); // no repetidos
        for (int i = 0; i < l1.size(); i++) {
            Integer tempData = l1.getIndex(i);
            if (l2.indexOf(tempData) == -1)
                noRep.insertFront(tempData);
        }

        System.out.println("No Repetidos " + noRep);     
        


    }


  
}

// Ejercicio 2.
/*
 * Ejercicio 2.
 * Considerando la implementaci贸n de la Lista realizado en el ejercicio
 * anterior, comparar la
 * complejidad computacional contra un array en las siguientes operaciones:
 * 
 * 1.- Insertar al principio. En un Array O(n). En una lista vinculada O(1).
 * 
 * 2.- Buscar un elemento en una posici贸n.
 * En un Array O(n). En una lista vinculada O(n).
 * Si se sabe la posicion en la que se encuentra un elemento en un Array es
 * O(1).
 * 
 * 3.- Determinar la cantidad de elementos.
 * En un Array O(1). En una lista vinculada O(n)(Si se posee una contador de los
 * elementos que se agregan en la lista la complejidad computacional es de
 * O(1)).
 */

/*
 * Ejercicio 4.
 * A la implementaci贸n de la clase Lista realizada en el ejercicio 1, agregue un
 * m茅todo
 * indexOf, que reciba un elemento y retorne el 铆ndice donde est谩 almacenado ese
 * elemento, o
 * -1 si el elemento no existe en la lista.
 */


