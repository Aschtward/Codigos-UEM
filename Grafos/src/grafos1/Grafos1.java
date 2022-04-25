/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos1;

/**
 *
 * @author Leonardo Ribeiro Goulart
 *	OBS: testes foram realizados usando os exemplos visto em sala, todos os grafos testados são orientados;
 *	caso queria realizar mais testes basta: criar uma nova variável do tipo Grafos, adicionar arestas pelo metodo addAresta(inicio da aresta, fim da aresta, peso);
 *  o algoritmo está sendo postado no meu repositório do github, é possível acessar em: https://github.com/Aschtward/Codigos-UEM/tree/main/Grafos/src/grafos1
 */
public class Grafos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buscas b = new Buscas();
        
        ///Bellman Ford testes ////
        //		TESTE 1			//
        Grafos g2 = new Grafos(10);
        g2.addAresta(0,1,6);
        g2.addAresta(0,2,7);
        g2.addAresta(1,4,5);
        g2.addAresta(1,4,-4);
        g2.addAresta(1,2,8);
        g2.addAresta(2,4,9);
        g2.addAresta(2,3,-3);
        g2.addAresta(3,1,-2);
        g2.addAresta(4,3,7);
        b.Bellman_Ford(4, g2);
        
        
        //		TESTE 2		//
        Grafos g3 = new Grafos(11);
        g3.addAresta(0,2,1);
        g3.addAresta(1,2,10);
        g3.addAresta(1,3,2);
        g3.addAresta(2,4,1);
        g3.addAresta(4,3,1);
        g3.addAresta(3,4,1);
        b.Bellman_Ford(3, g3);
        
       /// Busca em largura testes //
        
        //		TESTE 1		//
        Grafos g4 = new Grafos(6);
        g4.addAresta(0,1,0);
        g4.addAresta(0,2,0);
        g4.addAresta(1,4,0);
        g4.addAresta(1,2,0);
        g4.addAresta(2,4,0);
        g4.addAresta(2,3,0);
        g4.addAresta(3,1,0);
        g4.addAresta(4,3,0);
        b.buscaEmLargura(g4.vertices[1],g4);
        
        /// Busca em profundidade testes  //
        
        //		TESTE 1		//
        Grafos g5 = new Grafos(6);
        g5.addAresta(0,2,0);
        g5.addAresta(0,2,0);
        g5.addAresta(2,4,0);
        g5.addAresta(1,4,0);
        b.Busca_em_profundidade(g5,1);
        
        
       // Dijkstra  e Gaos//
      //		Teste		//
       Grafos g6 = new Grafos(5);
       g6.addAresta(0, 1, 10);
       g6.addAresta(0, 2, 5);
       g6.addAresta(1, 2, 2);
       g6.addAresta(1, 3, 1);
       g6.addAresta(2, 1, 3);
       g6.addAresta(2, 3, 9);
       g6.addAresta(2, 4, 2);
       g6.addAresta(3, 4, 4);
       g6.addAresta(4, 3, 6);
       g6.addAresta(4, 0, 7);
       b.gaos(g6);
       b.dijkstra(g6);
       
        //Algoritmo de Floyd Warshall //
        Grafos g9 = new Grafos(5);
        g9.addAresta(0, 2, 3);
        g9.addAresta(0, 3, 8);
        g9.addAresta(0, 4, 4);
        g9.addAresta(1, 4, 7);
        g9.addAresta(1, 3, 1);
        g9.addAresta(2, 1, 4);
        g9.addAresta(3, 2, 5);
        g9.addAresta(3, 0, 2);
        g9.addAresta(4, 3, 6);
        b.floydWarshall(g9);
        
        //Algoritmo de Ford Fukersson//
        Grafos g7 = new Grafos(6);
        g7.addAresta(0, 1, 16);
        g7.addAresta(0, 2, 13);
        g7.addAresta(1, 3, 12);
        g7.addAresta(2, 1, 4);
        g7.addAresta(2, 4, 14);
        g7.addAresta(3, 2, 9);
        g7.addAresta(3, 5, 20);
        g7.addAresta(4, 3, 7);
        g7.addAresta(4, 5, 4);
        b.fordFulkerson(g7, 0, 5);
        
        //Algoritmo de prin//
        
        Grafos g8 = new Grafos(12); 
        g8.addAresta(0, 1, 4);
        g8.addAresta(0, 2, 1);
        g8.addAresta(1, 2, 11);
        g8.addAresta(1, 3, 8);
        g8.addAresta(2, 4, 7);
        g8.addAresta(2, 5, 1);
        g8.addAresta(3, 4, 2);
        g8.addAresta(3, 6, 7);
        g8.addAresta(3, 7, 4);
        g8.addAresta(4, 5, 6);
        g8.addAresta(5, 7, 2);
        g8.addAresta(6, 7, 14);
        g8.addAresta(6, 8, 9);
        g8.addAresta(7, 8, 10);
        b.kruskal(g8, g8.vertices[0]);
        b.prim(g8, g8.vertices[0]);
        
    }
    
}
