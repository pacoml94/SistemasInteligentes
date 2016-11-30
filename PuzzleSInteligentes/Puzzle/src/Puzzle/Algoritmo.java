package Puzzle;
import Solucion.Frontera;
import Solucion.Nodo;
import Solucion.Problema;

public class Algoritmo {
	public boolean BusquedaAcotada(Problema prob, int estrategia, int prof_max){
		Frontera front=new Frontera();
		Nodo n_actual;
		Nodo n_inicial=new Nodo(null, prob.getE(), 0, 0, 0);
		front.Insertar(n_inicial);
		boolean solucion=false;
		while(!solucion && !front.esVacia()){
			n_actual=SeleccionaNodo(front);
			if(prob.estadoMeta(n_actual.getEstado())){
				solucion=true;
			}else{
				//pero esta mierda que es?
				
				
			}
		}
		
		return true;
	}
	
	public boolean Busqueda(Problema prob, int estrategia, int prof_max, int prof_inc){
		int prof_actual=prof_inc;
		boolean solucion=false;
		while(!solucion && (prof_actual<=prof_max)){
			solucion= BusquedaAcotada(prob, estrategia, prof_actual);
			prof_actual+=prof_inc;
		}
		return solucion;
	}
	
	public Nodo SeleccionaNodo(Frontera front){
		Nodo n = front.getFrontera().remove(0);
		return n;
	}
}
