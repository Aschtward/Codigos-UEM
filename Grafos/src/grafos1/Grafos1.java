/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos1;

/**
 *
 * @author Leonardo Ribeiro Goulart
 *	Para testar tire a expressão de comentário de algum teste
 */
public class Grafos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafos g = new Grafos(5);
        
        Vertice v1 = new Vertice(0);
        Vertice v2 = new Vertice(1);
        Vertice v3 = new Vertice(2);
        Vertice v4 = new Vertice(3);
        Vertice v5 = new Vertice(4);
        g.vertices[0] = v1;
        g.vertices[1] = v2;
        g.vertices[2] = v3;
        g.vertices[3] = v4;
        g.vertices[4] = v5;
        
        Buscas b = new Buscas();
        
        ///Bellman Ford testes ////Para algoritmos com pesos nas arestas foi definido uma maneira diferente de criar arestas, visto q tem pesos
        //		TESTE 1			//
        /*g.addAresta(0,1,6);
        g.addAresta(0,2,7);
        g.addAresta(1,4,5);
        g.addAresta(1,4,-4);
        g.addAresta(1,2,8);
        g.addAresta(2,4,9);
        g.addAresta(2,3,-3);
        g.addAresta(3,1,-2);
        g.addAresta(4,3,7);*/
        //b.Bellman_Ford(4, g);
        
        
        //		TESTE 2		//
      /*g.addAresta(0,2,1);
        g.addAresta(1,2,10);
        g.addAresta(1,3,2);
        g.addAresta(2,4,1);
        g.addAresta(4,3,1);
        g.addAresta(3,4,1);
        b.Bellman_Ford(3, g);*/
        
       /// Busca em largura testes //
        
        //		TESTE 1		//
        /*v1.adj.add(v2);
        v1.adj.add(v3);
        v2.adj.add(v5);
        v2.adj.add(v3);
        v3.adj.add(v5);
        v3.adj.add(v4);
        v4.adj.add(v2);
        v5.adj.add(v4);
        b.buscaEmLargura(g.vertices[1],g);*/
        
        //		TESTE 2		//
        /*v1.adj.add(v4);
        v1.adj.add(v5);
        v5.adj.add(v3);
        v4.adj.add(v2);
        b.buscaEmLargura(g.vertices[0],g);*/
        
        /// Busca em profundidade testes  //
        
        //		TESTE 1		//
        /*v1.adj.add(v2);
        v1.adj.add(v3);
        v3.adj.add(v4);
        v2.adj.add(v5);
        b.Busca_em_profundidade(g,1);*/
        
        //		TESTE 2		//
        /*v1.adj.add(v4);
        v1.adj.add(v5);
        v5.adj.add(v3);
        v4.adj.add(v2);
        b.Busca_em_profundidade(g);*/
        
       // Dijkstra  e Gaos//
      //		Teste		//
       /*g.addAresta(0, 1, 10);
       g.addAresta(0, 2, 5);
       g.addAresta(1, 2, 2);
       g.addAresta(1, 3, 1);
       g.addAresta(2, 1, 3);
       g.addAresta(2, 3, 9);
       g.addAresta(2, 4, 2);
       g.addAresta(3, 4, 4);
       g.addAresta(4, 3, 6);
       g.addAresta(4, 0, 7);
       //b.dijkstra(g);
       //b.gaos(g);*/
       
        //Algoritmo de Floyd Warshall //
      /*  g.addAresta(0, 2, 3);
        g.addAresta(0, 3, 8);
        g.addAresta(0, 4, 4);
        g.addAresta(1, 4, 7);
        g.addAresta(1, 3, 1);
        g.addAresta(2, 1, 4);
        g.addAresta(3, 2, 5);
        g.addAresta(3, 0, 2);
        g.addAresta(4, 3, 6);
        b.floydWarshall(g);*/
        
        //Algoritmo de Ford Fukersson//
        g.addAresta(0, 2, 100);
        g.addAresta(0, 3, 50);
        g.addAresta(2, 1, 50);
        g.addAresta(2, 3, 50);
        g.addAresta(2, 4, 50);
        g.addAresta(3, 4, 100);
        g.addAresta(4, 1, 125);
        b.fordFokerson(g, 0, 1);
        
    }
    
}
