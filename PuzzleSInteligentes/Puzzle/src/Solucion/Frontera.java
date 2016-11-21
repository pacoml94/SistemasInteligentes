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
    
    public List<Nodo> Insertar(Nodo nodo){ //Cambiar metodo en funcion del algoritmo
    	this.nodo=nodo;
    	if (frontera.isEmpty()) frontera.add(nodo);
    	else{
    		for(int i=0;i<frontera.size();i++){
    			if(nodo.getValor() < frontera.get(i).getValor()) frontera.add(i,nodo);
    		}
    	}
    	System.out.println(System.nanoTime());
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
