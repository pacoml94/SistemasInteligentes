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

}
