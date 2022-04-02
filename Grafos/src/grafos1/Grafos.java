package grafos1;

import java.util.ArrayList;
import java.util.List;


public class Grafos {
    
    Vertice[] vertices;
    List<Arestas> arestas;
    
    public Grafos(int n) {
        vertices = new Vertice[n];
        arestas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
    }

    public void addAresta(int u, int v,int p) {
        Arestas a = new Arestas(u,v,p);
        arestas.add(a);
    }
}
