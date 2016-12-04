package Solucion;

import Puzzle.Rectangulo;

import java.util.ArrayList;
import java.util.List;

import Puzzle.Puzzle;

public class EspacioEstados {
	private Estado e;
	private List<Estado> sucesores;
	private Rectangulo[][]imgOriginal;
	private int a,b;
	
	public EspacioEstados(Estado e, Rectangulo[][]imgOriginal) {
		this.e=e;
		this.sucesores=Sucesores(e);
		this.imgOriginal=imgOriginal;
	}

	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public List<Estado> getSucesores() {
		return sucesores;
	}

	/*public void setSucesores(Estado[] sucesores) {
		this.sucesores = sucesores;
	}*/

	/*public boolean esValido(Estado estado){	
		return true;
	}*/
	
	public boolean esObjetivo(Estado e){
		boolean objetivo=false;
		Rectangulo [][] rec=e.getPiezas();
		for(int i=0; i<rec.length; i++){
			for (int j=0; i<rec[0].length; i++){
				if(rec[i][j].getIdImage()==imgOriginal[i][j].getIdImage()){
					objetivo = true;
				}else
					objetivo=false;
					i=rec.length;
					j=rec[0].length;
			}
		}
		
		return objetivo;
	}
	
	public List<Estado> Sucesores(Estado estado){
		List<Estado> sucesores= new ArrayList<>();
		this.e=estado;
		boolean[] mov;
		PosicionNegro();
		mov=MovimientosPosibles(a,b);
		for(int i=0;i<mov.length;i++){
			if(mov[i]){
				Estado estadoNuevo=RealizarMovimiento(estado.getPiezas(), mov, i);
				sucesores.add(estadoNuevo);
			}
		}
		
		return sucesores;
	}
	
	public Estado RealizarMovimiento(Rectangulo[][] piezas, boolean[] mov, int i){
		Estado estadoNuevo;
		Rectangulo aux;
		switch(i){
		case 0: //arriba
			aux=piezas[a-1][b];
			piezas[a-1][b]=piezas[a][b];
			piezas[a][b]=aux;
			break;
		case 1: //abajo
			aux=piezas[a+1][b];
			piezas[a+1][b]=piezas[a][b];
			piezas[a][b]=aux;
			break;
		case 2: //izquierda
			aux=piezas[a][b-1];
			piezas[a][b-1]=piezas[a][b];
			piezas[a][b]=aux;
			break;
		case 3: //derecha
			aux=piezas[a][b+1];
			piezas[a][b+1]=piezas[a][b];
			piezas[a][b]=aux;
			break;
		}
		return estadoNuevo=new Estado(piezas);
	}
	
	public void PosicionNegro(){
		for (int i = 0; i < e.getPiezas().length; i++) {
			for (int j = 0; j < e.getPiezas()[0].length; j++) {
				if (e.getPiezas()[i][j].getIdImage() == 0) {
					a = i;
					b = j;
				}
			}
		}
	}
	public boolean[] MovimientosPosibles(int i, int j){
		boolean[] mov=new boolean[4];
		int f=e.getPiezas().length;
		int c=e.getPiezas()[0].length;
		
		/*
		 * mov[0]=arriba mov[1]=abajo mov[2]=izquierda mov[3]=derecha
		 */
		// Fila Arriba
		if (i == 0) {
			if (j == 0) {
				mov[3] = mov[1] = true;
			} else if (j == c - 1) {
				mov[2] = mov[1] = true;
			} else {
				mov[3] = mov[1] = mov[2] = true;
			}

			// Columna Izquierda
		} else if (j == 0) {
			if (i == f - 1) {
				mov[3] = mov[0] = true;
			} else {
				mov[3] = mov[0] = mov[1] = true;
			}

			// Columna Derecha
		} else if (j == c - 1) {
			if (i == f - 1) {
				mov[2] = mov[0] = true;
			} else {
				mov[2] = mov[0] = mov[1] = true;
			}
			// Fila Abajo
		} else if (i == f - 1) {
			mov[0] = mov[2] = mov[3] = true;
		} else {
			for (int x = 0; x < 4; x++) {
				mov[x] = true;
			}
		}
		return mov;
	}
	

}
