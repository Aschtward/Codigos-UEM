/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 0 - branco 1 - cinza 2 - preto
 * @author guest-6piceq
 */
public class Buscas {
	
	int t;
	
    public void buscaEmLargura(Vertice e, Grafos g){
        
        for(Vertice v : g.vertices){
            v.cor = 0;
            v.pai = null;
            v.d = -1;
        }
        
        e.cor = 1;
        e.pai = null;
        e.d = 0;
        List<Vertice> Q = new ArrayList<>();
        Q.add(e);
        
        while(!Q.isEmpty()){
            
            Vertice u = Q.remove(0);
            
            for(Vertice v : u.adj){
                if(v.cor == 0){
                    v.d = u.d + 1;
                    v.pai = u;
                    v.cor = 1;
                    Q.add(v);
                }
                u.cor = 2;
            }
        }
        System.out.println("----------Busca em largura----------");
        for(Vertice v:g.vertices){
            System.out.println("Vertice " + (v.num+1) + " Distancia " + v.d);
        }
    }
    
    public void Busca_em_profundidade(Grafos G){
        
        for(Vertice v:G.vertices){
            v.cor = 0;
            v.pai = null;
        }
        t = 0;
        for(Vertice v:G.vertices){
            if(v.cor == 0)
                dfs_visit(v);
        }
        System.out.println("----------Busca em profundidade-------------");
        for(Vertice v:G.vertices){
            System.out.println("Vertice " + (v.num+1) + " Tempo de inicio: " + v.ini + " Tempo final: " + v.fim);
        }
    }

    private void dfs_visit(Vertice v) {
        t++;
        v.cor = 1;
        v.ini = t;
        for(Vertice u: v.adj){
            if(u.cor == 0){
                u.pai = v;
                dfs_visit(u);
            }         
        }
        t++;
        v.cor = 2;
        v.fim = t;
    }
    
    public void Bellman_Ford(int e,Grafos g){
        
        for(Vertice v : g.vertices){
            v.pai = null;
            v.d = Integer.MAX_VALUE;
        }
        //Inicializando distancia em 0 e vertices sem pai
        g.vertices[0].d = 0;
        
        for(int i = 0; i < g.vertices.length - 1;i++){//Relaxando as arestas  V-1 vezes
        	if(g.arestas.size() == 0) continue;//Caso não exista arestas.
            for(Arestas a : g.arestas){
                int v1 = a.inicio;
                int v2 = a.fim;
                int weigth = a.peso;
                if(g.vertices[v1].d != Integer.MAX_VALUE && g.vertices[v1].d + weigth < g.vertices[v2].d){
                    g.vertices[v2].d = g.vertices[v1].d + weigth;
                    g.vertices[v2].pai = g.vertices[v1];
                }
            }
        }
        
        for(Arestas a : g.arestas){//Verificando se Ã© possivel relaxar mais as arestas
            int v1 = a.inicio;
            int v2 = a.fim;
            int weigth = a.peso;
            if(g.vertices[v1].d != Integer.MAX_VALUE && g.vertices[v1].d + weigth < g.vertices[v2].d){
               System.out.println("Ciclo negativo detectado");
            }
        }
        System.out.println("----------Bellman-Ford----------");
        System.out.println("Distancia minima da origem até o vertice: " + g.vertices[e].d);
        imprimir_caminho( g.vertices[e]);
        System.out.println("");
    }
    
    public void imprimir_caminho(Vertice e) {
    	List<Vertice> path = new ArrayList<Vertice>();
    	while(e.pai != null) {
    		path.add(e); 
    		e = e.pai;
    	}
    	System.out.print("0->");
    	while(path.size() != 0) {
    		if(path.size() > 1) {
    			System.out.print(path.get(path.size()-1).num + "->");
    		}else {
    			System.out.print(path.get(path.size()-1).num);
    		}
    		path.remove(path.size()-1);
    	}
    	
    }
    
    public void dijkstra(Vertice e, Grafos g){
    	List<Vertice> queue = new ArrayList<Vertice>();
    	for(Vertice v:g.vertices) {
    		v.d = Integer.MAX_VALUE;
    		v.pai = null;
    		queue.add(v);
    	}
    	List<Vertice> done = new ArrayList<Vertice>();
    	while(queue.size() > 0) {
    		
    	}
    }
    
}
