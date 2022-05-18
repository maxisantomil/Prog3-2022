package Grafo;

public class Tarea {
	int id;
    String nombre;
    String descripcion;
    int duracion;
    
    public Tarea(int id,String nombre, String descripcion, int duracion) {
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.duracion=duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }
}
