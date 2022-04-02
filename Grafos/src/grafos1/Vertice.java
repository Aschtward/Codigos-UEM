package grafos1;

import java.util.List;
import java.util.LinkedList;

public class Vertice {
    int num;
    List<Vertice> adj;
    int grauSaida;
    Vertice pai;
    int d;
    int cor;
    int ini;
    int fim;
    
    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<Vertice>();
    }

    public String toString() {
        return "Vertice(" + num + ")";
    }
}
