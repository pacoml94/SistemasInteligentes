package Solucion;

import Puzzle.Rectangulo;

public class Nodo {
    
  
	private int f; //distancia que queda para llegar al objetivo
	private int costo; //coste que cuesta hacer ese movimiento en nuestro puzzle siempre es 1
	private int h;  //
	private int id; //
	private int profundidad; //profundidad que ocupa ese nodo en el arbol
   
    
    public Nodo() {
        
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

}
