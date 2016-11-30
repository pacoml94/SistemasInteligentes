package Solucion;

import java.util.Arrays;

import Puzzle.Rectangulo;

public class Estado {
	
	private Rectangulo [][]piezas;
	
	public Estado (Rectangulo [][]piezas){
		this.piezas=piezas;
		
	}
	
	public Rectangulo[][] getPiezas(){
		return piezas;
	}


	public boolean equals(Rectangulo[][] piezas1) {
		boolean igual=true;
		for(int i=0;i<piezas.length;i++){
			for(int j=0;j<piezas[0].length;j++){
				if(piezas[i][j].getIdImage()!=piezas1[i][j].getIdImage()){
					igual=false;
					j=piezas[0].length;
					i=piezas.length;
				}
			}
		}
		return igual;
	}
	
}
