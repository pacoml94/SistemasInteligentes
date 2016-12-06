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
	private Frontera front;
	public Algoritmo(EspacioEstados eS, Estado e){
		this.eS=eS;
		this.e=e;
		front=new Frontera();
		Problema prob=new Problema(eS, e);
		Busqueda(prob, 1, 9999, 1);
	}
	
	public boolean BusquedaAcotada(Problema prob, int estrategia, int prof_max){
		int id = 1;
		List<Estado> LS;
		List<Nodo> LN;
		Nodo n_actual;
		Nodo n_inicial=new Nodo(prob.getE());
		front.Insertar(n_inicial);
		boolean solucion=false;
		while(!solucion && !front.esVacia()){
			n_actual=SeleccionaNodo(front);
			if(eS.esObjetivo(n_actual.getEstado())){
				System.out.println("Puzzle resuelto");
				solucion=true;
			}else{
				LS=eS.Sucesores(n_actual.getEstado());
				//Vamos creando un nodo por cada sucesor
				for(int i=0;i<LS.size();i++){
					if(n_actual.getPadre()!=null){
						if(!LS.get(i).equals(n_actual.getPadre().getEstado())){
							Nodo nuevoNodo=new Nodo(id, n_actual, LS.get(i), 0);
							nuevoNodo.setValor(CalcularValor(nuevoNodo, estrategia));
							front.Insertar(nuevoNodo); //Insertamos cada nodo en la frontera que se va ordenando por su valor
							id++;
						}
					}else{
						Nodo nuevoNodo=new Nodo(id, n_actual, LS.get(i), 0);
						nuevoNodo.setValor(CalcularValor(nuevoNodo, estrategia));
						front.Insertar(nuevoNodo); //Insertamos cada nodo en la frontera que se va ordenando por su valor
						id++;
					}
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
	
	public int CalcularValor(Nodo nodo, int estrategia){
		int valor=0;
		if(estrategia == 1){
			valor=nodo.getProfundidad() +1;
			//valor=nodo.getH()+nodo.getCosto();
		}else if(estrategia == 2){
			valor=nodo.getCosto()+1;
		}else if(estrategia == 3){
			valor=nodo.getProfundidad() * (-1);
		}
		return valor;
	}
	
	public Nodo SeleccionaNodo(Frontera front){
		Nodo n = front.getFrontera().remove(0);
		return n;
	}
}
