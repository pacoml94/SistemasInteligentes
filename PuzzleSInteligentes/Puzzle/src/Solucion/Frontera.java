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
    
    public void insertarLista(List front){
    	this.frontera=front;
    }
    
    public List<Nodo> Insertar(Nodo nodo){ //Cambiar metodo en funcion del algoritmo
    	long tiempo_inicial, tiempo_final;
    	this.nodo=nodo;
    	
    	tiempo_inicial = System.currentTimeMillis();
    	if (frontera.isEmpty()) frontera.add(nodo);
    	else{
    		for(int i=0;i<frontera.size();i++){
    			if(nodo.getValor() < frontera.get(i).getValor()) frontera.add(i,nodo);
    		}
    	}

    	tiempo_final = System.currentTimeMillis();
    	
    	System.out.printf("Tiempo de insercion del nodo %d = %d\n", nodo.getId(), (tiempo_final - tiempo_inicial));
    	
    	return frontera;	
    }
    
    public List<Nodo> Eliminar(){
    	frontera.remove(nodo);
    	return frontera;
    }
    
    public boolean esVacia(){
    	return frontera.isEmpty();
    }

	public List<Nodo> getFrontera() {
		return frontera;
	}

	public void setFrontera(List<Nodo> frontera) {
		this.frontera = frontera;
	}
    
}
