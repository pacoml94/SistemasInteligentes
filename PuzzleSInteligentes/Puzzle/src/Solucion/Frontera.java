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
    
    public void insertarLista(List<Nodo> front){
    	this.frontera=front;
    }
    
    public List<Nodo> Insertar(Nodo nodo){ //Cambiar metodo en funcion del algoritmo
    	long tiempo_inicial, tiempo_final;
    	this.nodo=nodo;
    	boolean insertado = false;
    	tiempo_inicial = System.nanoTime();
    	if (frontera.isEmpty()) frontera.add(nodo);
    	else{
    		for(int i=0;i<frontera.size()&&!insertado;i++){
    			if(nodo.getValor() < frontera.get(i).getValor()){
    				frontera.add(i,nodo);
    				insertado=true;
    			}else if(i+1==frontera.size()){
    				frontera.add(i+1,nodo);
    				insertado=true;
    			}
    		}
    	}

    	tiempo_final = System.nanoTime();
    	
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
}
