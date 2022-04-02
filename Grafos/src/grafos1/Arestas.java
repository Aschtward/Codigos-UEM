/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos1;

/**
 *
 * @author guest-bqyt8s
 */
class Arestas {
    int peso;
    int inicio;
    int fim;
    //Para está implementação se deve ter um grafo direcionado.
    
    public Arestas(int inicio, int fim, int peso){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        //Inicia uma aresta com inicio, fim e peso
    }
}
