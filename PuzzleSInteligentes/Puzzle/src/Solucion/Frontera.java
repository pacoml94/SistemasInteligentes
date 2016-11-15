package Solucion;

import java.util.ArrayList;
import java.util.List;

public class Frontera {

    private List <Nodo> frontera;
    private Nodo nodo;
    
    public Frontera(Nodo nodo) {
        this.frontera = new ArrayList<>();
        this.nodo = nodo;
    }
}
