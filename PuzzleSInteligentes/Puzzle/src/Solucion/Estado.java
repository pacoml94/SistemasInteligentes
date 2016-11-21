package Solucion;

import Puzzle.Rectangulo;

public class Estado {
	
	private Rectangulo [][]piezas;
	
	public Estado (Rectangulo [][]piezas){
		this.piezas=piezas;
		
	}
	
	public Rectangulo[][] getPiezas(){
		return piezas;
	}
	
}
