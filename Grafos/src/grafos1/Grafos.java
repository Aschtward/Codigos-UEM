package grafos1;


public class Grafos {
    
    Vertice[] vertices;

    public Grafos(int n) {
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
    }

    public void addAresta(int u, int v) {
        vertices[u].adj.add(vertices[v]);
    }
}
