package Practico1;

public class Pila<T> {
    private MyList<T> lista;


    Pila(){
        this.lista = new MyList<>();
    }

    public void push(T data){
        this.lista.insertFront(data);
    }

    public T pop (){
        return this.lista.extractFront();
    }
    
    public T top(){
        return this.lista.getHead().getData();
    }

    public void reverse(){
        int size =  this.lista.size();
        MyList <T> auxlista = new MyList<>();
        for(int i=0 ; i<size ; i++){
          T tempData = this.pop(); // elimina el primer elemento y devuelve la data
          auxlista.insertFront(tempData);
        }
        this.lista = auxlista;       
    }

    public int size(){
        return this.lista.size();
    }

    @Override
    public String toString(){
        return this.lista.toString();
    }
}
