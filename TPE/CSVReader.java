import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static void main(String[] args) {
    	
        String csvFile = "TPE/datasets/dataset1.csv";
        String line = "";
        String cvsSplitBy = ";";
        Tree treeLibros= new Tree();
        ArrayList<Libro>libros = new ArrayList<Libro>();
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
                		String[] generos= palabra[3].split(cvsSplitSpace);
                		for(String g:generos)
                			libro.addGeneros(g);
                		treeLibros.addLibro(libro);
                		}    
                }
            	
        } catch (IOException e) {
            e.printStackTrace();
        }
        treeLibros.printInOrder();
    }
}