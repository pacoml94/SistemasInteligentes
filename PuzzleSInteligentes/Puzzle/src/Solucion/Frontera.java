package Solucion;

import java.util.ArrayList;
import java.util.List;
import Puzzle.Rectangulo;


public class Frontera {

    private List <Nodo> frontera;
    private Nodo nodo;
    
    public Frontera() {
        this.frontera = new ArrayList<>();
        
    }
    
    public List<Nodo> Insertar(Nodo nodo){
    	frontera.add(nodo);
    	return frontera;
    	
    	
    }
}
