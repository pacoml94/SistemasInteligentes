package Solucion;

import Puzzle.Rectangulo;

public class EspacioEstados {
	
	private Rectangulo [][] piezas;
	private int profundidad;
	
	
	public EspacioEstados(Rectangulo [][] p) {
		this.setPiezas(p);
		this.profundidad = 0;
	}

	public int incrementarProfundidad() {
		return profundidad++;
	}
	
	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public Rectangulo [][] getPiezas() {
		return piezas;
	}

	public void setPiezas(Rectangulo [][] piezas) {
		this.piezas = piezas;
	}
	
	public boolean esValido(Estado estado){
	
		return true;
	}
	public boolean esObjetivo(Estado e, Rectangulo[][]imgOriginal){
		boolean objetivo=false;
		Rectangulo [][] rec=e.getPiezas();
		for(int i=0; i<rec.length; i++){
			for (int j=0; i<rec.length; i++){
				if(rec[i][j].getIdImage()==imgOriginal[i][j].getIdImage()){
					objetivo = true;
				}else
					objetivo=false;
					i=rec.length;
					j=rec.length;
			}
		}
		
		return objetivo;
	}

}
