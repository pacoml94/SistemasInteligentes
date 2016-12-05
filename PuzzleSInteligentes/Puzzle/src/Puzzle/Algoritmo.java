package Puzzle;
import java.util.List;

import Solucion.EspacioEstados;
import Solucion.Estado;
import Solucion.Frontera;
import Solucion.Nodo;
import Solucion.Problema;

public class Algoritmo {
	private EspacioEstados eS;
	private Estado e;
	public Algoritmo(EspacioEstados eS, Estado e){
		this.eS=eS;
		this.e=e;
		Problema prob=new Problema(eS, e);
		Busqueda(prob, 0, 9999, 1);
	}
	
	public boolean BusquedaAcotada(Problema prob, int estrategia, int prof_max){
		int id = 0;
		Frontera front=new Frontera();
		List<Estado> LS;
		List<Nodo> LN;
		Nodo n_actual;
		Nodo n_inicial=new Nodo(id , null, prob.getE(), 0);
		front.Insertar(n_inicial);
		boolean solucion=false;
		while(!solucion && !front.esVacia()){
			n_actual=SeleccionaNodo(front);
			if(prob.estadoMeta(n_actual.getEstado())){
				solucion=true;
			}else{
				LS=prob.Sucesores(n_actual.getEstado());
				//Vamos creando un nodo por cada sucesor
				for(int i=0;i<LS.size();i++){
					id++;
					Nodo nuevoNodo=new Nodo(id, n_actual, LS.get(i), CalcularValor(n_actual, estrategia));
					front.Insertar(nuevoNodo); //Insertamos cada nodo en la frontera que se va ordenando por su valor
				}
			}
		}
		
		return solucion;
	}
	
	public void Busqueda(Problema prob, int estrategia, int prof_max, int prof_inc){
		int prof_actual=prof_inc;
		boolean solucion=false;
		while(!solucion && (prof_actual<=prof_max)){
			solucion= BusquedaAcotada(prob, estrategia, prof_actual);
			prof_actual+=prof_inc;
		}
	}
	
	public int CalcularValor(Nodo padre, int estrategia){
		int valor=0;
		if(estrategia == 1){
			valor=padre.getProfundidad() +1;
		}else if(estrategia == 2){
			valor=padre.getCosto()+1;
		}else if(estrategia == 3){
			valor=padre.getProfundidad() * (-1);
		}
		return valor;
	}
	
	public List<Nodo> CreaListaNodosArbol(List<Estado> LS, Nodo n_actual, int prof_max, int estrategia){
		List<Nodo> LN=null;
		
		return LN;
	}
	
	public Nodo SeleccionaNodo(Frontera front){
		Nodo n = front.getFrontera().remove(0);
		return n;
	}
}
