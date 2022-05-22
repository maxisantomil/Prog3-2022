import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSVReader {

    public static void main(String[] args) {
    	
        String csvFile = "TPE/datasets/dataset1.csv";
        String line = "";
        String cvsSplitBy = ";";
        LinkedList<Libro>libros= new LinkedList<>();
        LinkedList<Genero>generos= new LinkedList<>();
        Tree treeGeneros= new Tree();
        
        int idLibro=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine(); //salteo la primer linea
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                for (String p:items) {
                	idLibro++;
                    String linePalabra= ",";
                	String[]palabra= p.split(linePalabra);
                		Libro libro= new Libro(idLibro,palabra[0],palabra[1],palabra[2]);
                		String cvsSplitSpace = " ";
                		String[] generosDivision= palabra[3].split(cvsSplitSpace);
                		for(String g:generosDivision)
                			
                			libro.addGeneros(g);
                			libros.add(libro);
                		}    
                }
            	
        } catch (IOException e) {
            e.printStackTrace();
        }
        Genero genero=new Genero();
        genero.setNombre("cine");
        
        for(Libro l: libros){
           genero.addLibro(l);
           treeGeneros.addGenero(genero);
        }
        System.out.println(genero.getLibros());
        treeGeneros.printInOrder();;
    }
}