package Solucion;

import java.util.ArrayList;
import java.util.List;
import Puzzle.Rectangulo;


public class Frontera {

    private List <Nodo> frontera;
    private Nodo nodo;
    
    public Frontera() {
        this.frontera = new ArrayList<>();
        this.nodo=nodo;       
    }
    
    public List<Nodo> Insertar(Nodo nodo){ //Cambiar metodo en funcion del algoritmo
    	frontera.add(nodo);
    	return frontera;	
    }
    
    public List<Nodo> Eliminar(){
    	frontera.remove(nodo);
    	return frontera;
    }
    
    public boolean esVacia(){
    	return frontera.isEmpty();
    }
}
