package Puzzle;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Solucion.EspacioEstados;
import Solucion.Estado;
import Solucion.Frontera;
import Solucion.Nodo;
import Solucion.Problema;

public class Algoritmo {
	private Rectangulo[][] estadoFinal;
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
			n_actual=front.getFrontera().remove(0);
			if(eS.esObjetivo(n_actual.getEstado())){
				solucion=true;
				System.out.println("Puzzle resuelto");
				estadoFinal=n_actual.getEstado().getPiezas();
				
				recorrido(n_actual);
				
					
			}else{
				LS=eS.Sucesores(n_actual.getEstado());
				//Vamos creando un nodo por cada sucesor
				for(int i=0;i<LS.size();i++){
					//Nodo nuevoNodo=new Nodo(id, n_actual, LS.get(i), 0);
					//front.Insertar(nuevoNodo);
					if(n_actual.getPadre()!=null){
						if(!LS.get(i).equals(n_actual.getPadre().getEstado())){
							Nodo nuevoNodo=new Nodo(id, n_actual, LS.get(i), LS.get(i).getMovimiento());
							nuevoNodo.setValor(CalcularValor(nuevoNodo, estrategia));
							front.Insertar(nuevoNodo); //Insertamos cada nodo en la frontera que se va ordenando por su valor
							id++;
						}
					}else{
						Nodo nuevoNodo=new Nodo(id, n_actual, LS.get(i), LS.get(i).getMovimiento());
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
	
	public void recorrido(Nodo nodoFinal){
		Nodo padre = nodoFinal.getPadre();
		
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("Recorrido.txt"));
			pw.println(nodoFinal.getAccion()+"; estado final: ");
			for(int i=0;i<nodoFinal.getEstado().getPiezas().length;i++){
				for(int j=0;j<nodoFinal.getEstado().getPiezas()[0].length;j++){
					pw.print(nodoFinal.getEstado().getPiezas()[i][j].getIdImage()+" ");
				}
				pw.println(" ");
			}
			while(padre.getAccion()!=null){
				Rectangulo[][] rec = padre.getEstado().getPiezas();
				pw.println(padre.getAccion()+"; estado: ");
				for(int i=0;i<rec.length;i++){
					for(int j=0;j<rec[0].length;j++){
						pw.print(rec[i][j].getIdImage()+" ");
					}
					pw.println(" ");
				}
				padre=padre.getPadre();
			}
			pw.println("Estado inicial: ");
			for(int i=0;i<padre.getEstado().getPiezas().length;i++){
				for(int j=0;j<padre.getEstado().getPiezas()[0].length;j++){
					pw.print(padre.getEstado().getPiezas()[i][j].getIdImage()+" ");
				}
				pw.println(" ");
			}
			pw.close();
		}catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public int CalcularValor(Nodo nodo, int estrategia){
		int valor=0;
		if(estrategia == 1){ //anchura
			//valor=nodo.getProfundidad() +1;
			valor=nodo.getH()+nodo.getCosto();
		}else if(estrategia == 2){//coste Uniforme
			valor=nodo.getCosto()+1;
		}else if(estrategia == 3){// profundidad
			valor=nodo.getProfundidad() * (-1);
		}
		return valor;
	}
	
	public Rectangulo[][] getEstadoFinal() {
		return estadoFinal;
	}
}
