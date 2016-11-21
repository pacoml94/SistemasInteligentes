package Puzzle;
import Solucion.Frontera;
import Solucion.Nodo;
import Solucion.Problema;

public class Algoritmo {
	public boolean BusquedaAcotada(Problema prob){
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
	
	public Nodo SeleccionaNodo(Frontera front){
		Nodo n= new Nodo();
		
		return n;
	}
}
