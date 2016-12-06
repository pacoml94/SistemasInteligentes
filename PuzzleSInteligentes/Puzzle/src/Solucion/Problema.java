package Solucion;

import java.util.List;

import Puzzle.Rectangulo;

public class Problema {

	private Estado e;
	private EspacioEstados eS;
	
	public Problema(EspacioEstados eS, Estado e) {
		this.e=e;
		this.eS=eS;
	}

	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public EspacioEstados geteS() {
		return eS;
	}

	public void seteS(EspacioEstados eS) {
		this.eS = eS;
	}
	public boolean estadoMeta(Estado estado){
		return eS.esObjetivo(estado);
	}
	public List<Estado> Sucesores(Estado estado){
		List<Estado> LS=eS.Sucesores(estado);
		return LS;
	}
	
		
}
