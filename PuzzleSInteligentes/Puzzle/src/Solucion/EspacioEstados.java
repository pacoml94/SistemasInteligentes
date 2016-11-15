package Solucion;

import Puzzle.Rectangulo;

public class EspacioEstados {
	
	private Estado e;
	private Estado[]sucesores;
	
	
	public EspacioEstados(Estado e) {
		this.e=e;
		this.sucesores=Sucesores(e);
		}

	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public Estado[] getSucesores() {
		return sucesores;
	}

	public void setSucesores(Estado[] sucesores) {
		this.sucesores = sucesores;
	}

	public boolean esValido(Estado estado){
	
		return true;
	}
	public boolean esObjetivo(Estado e, Rectangulo[][]imgOriginal){
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
	public Estado[] Sucesores(Estado e){
		Estado[] sucesores=null;
		return sucesores;
	}

}
