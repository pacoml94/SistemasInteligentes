package Puzzle_Nuevo;

import java.util.ArrayList;
import java.util.List;

class Arbol_busqueda {

	private List <Rectangulo> piezas, sucesores;
	
	
	public Arbol_busqueda(ArrayList<Rectangulo> imagenes) {
		piezas = new ArrayList<>();
		piezas = imagenes;
		sucesores = new ArrayList<>();
	}
	
}