package Solucion;

import Puzzle.Rectangulo;

import java.util.ArrayList;
import java.util.List;

import Puzzle.Puzzle;

public class EspacioEstados {
	//private List<Estado> sucesores;
	
	public boolean esObjetivo(Estado e){
		int cont=0;
		boolean solucion=true;
		Rectangulo [][] rec=e.getPiezas();
		int [][] objetivo=new int[rec.length][rec[0].length];
		for(int i=0; i<rec.length; i++){
			for (int j=0; j<rec[0].length; j++){
				objetivo[i][j]=cont;
				cont++;
			}
		}
		
		for(int i=0; i<rec.length; i++){
			for (int j=0; j<rec[0].length; j++){
				if(rec[i][j].getIdImage()!=objetivo[i][j]){
					solucion=false;
				}
			}
		}
		return solucion;
	}
	
	public List<Estado> Sucesores(Estado estado){
		List<Estado> sucesores= new ArrayList<>();
		Rectangulo[][] piezas=CopiarMatriz(estado.getPiezas());
		int [] posicionNegro=PosicionNegro(estado.getPiezas());
		boolean[] mov=MovimientosPosibles(estado.getPiezas(), posicionNegro);
		
		for(int i=0;i<mov.length;i++){
			if(mov[i]){
				Estado estadoNuevo=RealizarMovimiento(piezas, i, posicionNegro);
				sucesores.add(estadoNuevo);
			}
		}
		
		return sucesores;
	}
	
	public Estado RealizarMovimiento(Rectangulo[][] piezas, int i, int[]posicionNegro){
		int x=posicionNegro[0];
		int y=posicionNegro[1];
		Estado estadoNuevo;
		Rectangulo aux;
		switch(i){
		case 0: //arriba
			aux=piezas[x-1][y];
			piezas[x-1][y]=piezas[x][y];
			piezas[x][y]=aux;
			break;
		case 1: //abajo
			aux=piezas[x+1][y];
			piezas[x+1][y]=piezas[x][y];
			piezas[x][y]=aux;
			break;
		case 2: //izquierda
			aux=piezas[x][y-1];
			piezas[x][y-1]=piezas[x][y];
			piezas[x][y]=aux;
			break;
		case 3: //derecha
			aux=piezas[x][y+1];
			piezas[x][y+1]=piezas[x][y];
			piezas[x][y]=aux;
			break;
		}
		
		estadoNuevo = new Estado(piezas);
		
		return estadoNuevo;
	}
	
	public int[] PosicionNegro(Rectangulo[][] piezas){
		int[]posicion=new int[2];
		for (int i = 0; i < piezas.length; i++) {
			for (int j = 0; j < piezas[0].length; j++) {
				if (piezas[i][j].getIdImage() == 0) {
					posicion[0] = i;
					posicion[1]= j;
				}
			}
		}
		return posicion;
	}
	public boolean[] MovimientosPosibles(Rectangulo[][]piezas, int[] posicionNegro){
		boolean[] mov=new boolean[4];
		int x=posicionNegro[0];
		int y=posicionNegro[1];
		for(int i=0;i<mov.length;i++){
			mov[i]=true;
		}
		/*
		 * mov[0]=arriba mov[1]=abajo mov[2]=izquierda mov[3]=derecha
		 * 
		 */
		if(y==0)
			mov[2]=false;
		if(y==piezas[0].length-1)
			mov[3]=false;
		if(x==0)
			mov[0]=false;
		if(x==piezas.length-1)
			mov[1]=false;
		return mov;
	}
	
	public Rectangulo [][] CopiarMatriz(Rectangulo  [][] estadoActual){
		Rectangulo [][] piezas=new Rectangulo[estadoActual.length][estadoActual[0].length];
	
		for (int i = 0; i < estadoActual.length; i++) {
			for (int j = 0; j < estadoActual[0].length; j++) {
				piezas[i][j] = estadoActual[i][j];
			}
		}
		return piezas;
	}
}
