package Solucion;

import Puzzle.Rectangulo;

public class Nodo {
    private int id;
	private Estado estado;
	private Nodo padre;
	private int valor; 
	private int costo = 0; //coste que cuesta hacer ese movimiento en nuestro puzzle siempre es 1
	//private int h;  //Numero de nodos que faltan para llegar al estado objetivo
	//private int id; //Identificador del nodo
	private int profundidad=0; //profundidad que ocupa ese nodo en el arbol
   
    
    public Nodo(int id, Nodo padre, Estado e, int valor) {
    	this.id=id;
    	this.estado=e;
        this.padre=padre;
        this.profundidad=padre.getProfundidad()+1;
        this.costo=padre.getCosto()+1;
        this.valor=valor;
        //this.h=calcularHeuristica();
    }
   /* public Nodo(){
    	
    }*/

    public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    public int calcularHeuristica(){
    	int id=0, heu=0;
    	for(int i=0;i<estado.getPiezas().length;i++){
    		for(int j=0;j<estado.getPiezas()[0].length;j++){
    			if(estado.getPiezas()[i][j].getIdImage()!=id) heu++;
    			id++;
    		}
    	}
    	return heu;
    }

}
