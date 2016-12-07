package Solucion;

import Puzzle.Rectangulo;

public class Nodo {
    private int id;
    private String accion;
	private Estado estado;
	private Nodo padre;
	private int valor; 
	private int costo; //coste que cuesta hacer ese movimiento en nuestro puzzle siempre es 1
	private int profundidad; //profundidad que ocupa ese nodo en el arbol
	private int h;  //Numero de nodos que faltan para llegar al estado objetivo
    
    public Nodo(int id, Nodo padre, Estado e, String accion) {
    	this.id=id;
    	this.accion=accion;
    	this.estado=e;
        this.padre=padre;
        this.profundidad=padre.getProfundidad()+1;
        this.costo=padre.getCosto()+1;
        this.valor=0;
        this.h=calcularHeuristica();
    }
    
	public Nodo(Estado e){
    	id=0;
    	this.estado=e;
    	h=calcularHeuristica();
    	valor=calcularHeuristica();
    	costo=0;
    	padre=null;
    	profundidad=0;
    	accion=null;
    }
    
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
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
	
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
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
