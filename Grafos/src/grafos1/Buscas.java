/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    
    public void Busca_em_profundidade(Grafos G, int i){
        
        for(Vertice v:G.vertices){
            v.cor = 0;
            v.pai = null;
        }
        t = 0;
        for(Vertice v:G.vertices){
            if(v.cor == 0)
                dfs_visit(v);
        }
        if(i == 1) {
	        System.out.println("----------Busca em profundidade-------------");
	        for(Vertice v:G.vertices){
	            System.out.println("Vertice " + (v.num+1) + " Tempo de inicio: " + v.ini + " Tempo final: " + v.fim);
	        }
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
    
    public void gaos(Grafos g) {
    	
    	Busca_em_profundidade(g,0);//Realiza busca em profundidade e set pais e filhos
    	
    	for(Vertice v: g.vertices) {//Inicializa distancias
    		v.d = Integer.MAX_VALUE;
    	}
    	g.vertices[0].d = 0;
    	
    	List<Vertice> vertices = Arrays.asList(g.vertices);//Cria lista em que os vertices serão ordenados
    	vertices.sort(new Comparator<Vertice>() {//Ordena em ordem topologica
    		public int compare(Vertice v1, Vertice v2) {
    			if(v1.fim > v2.fim) {
    				return -1;
    			}else {
    				return +1;
    			}
    		}
    	});
    	for(Vertice u: vertices) {//Efetua relaxamento
    		for(Vertice v: u.adj) {
    			relax(u,v,g);
    		}
    	}
    	System.out.println("-----------------GAOS-----------------");
    	for(Vertice v:vertices) {//Imprime vertices
    		System.out.println("Vertice " + v.num + " Distancia " + v.d);
    	}
    	//OBS esse metodo não é funcional para arestas com pesos negativos
    }
    
    private void relax(Vertice u, Vertice v, Grafos g) {
    	Arestas aresta = null;
		for(Arestas ar:g.arestas) {//Pela entrada é necessário busca a aresta referente aos vertices
			if(ar.inicio == u.num && ar.fim == v.num) {
				aresta = ar;
			}
		}
		if(u.d != Integer.MAX_VALUE && u.d + aresta.peso < v.d) {
			v.d = u.d + aresta.peso;
			v.pai = u;
		}
		
	}

	public void dijkstra(Grafos g){
		List<Vertice> s = new ArrayList<Vertice>();
		for(Vertice v: g.vertices) {
			v.d = Integer.MAX_VALUE;
			v.pai = null;
		}
		g.vertices[0].d = 0;
		List<Vertice> q = new ArrayList<Vertice>();
		Collections.addAll(q, g.vertices);
		q.sort(new Comparator<Vertice>() {
				public int compare(Vertice v1, Vertice v2) {
					if(v1.d < v2.d) {
						return -1;
					}else {
						return +1;
					}
				}
			});
		while(q.size() > 0) {
			Vertice u = q.get(0);
			s.add(u);
			for(Vertice v:u.adj) {
				relax(u,v,g);
			}
			q.remove(0);
			q.sort(new Comparator<Vertice>() {
				public int compare(Vertice v1, Vertice v2) {
					if(v1.d < v2.d) {
						return -1;
					}else {
						return +1;
					}
				}
			});
		}
		System.out.println("-----------------Algoritmo de Dijkstra-----------------");
    	for(Vertice v: s) {
    		System.out.println("Vertice " + v.num + " Distancia " + v.d);
    	}
    }
    
	public int[][] geraMatriz(Grafos g){
		int[][] matriz = new int[g.vertices.length][g.vertices.length];
		for(int i = 0; i < g.vertices.length; i++) {
			for(int j = 0; j < g.vertices.length; j++) {
				matriz[i][j] = 99999;
			}
		}
		for(Arestas a:g.arestas) {
			matriz[a.inicio][a.fim] = a.peso;
		}
		return matriz;
	}
	
	public void floydWarshall(Grafos g) {
		int[][] matriz = geraMatriz(g);
		int n = g.vertices.length;
		for(int k = 0 ; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(matriz[i][j] > matriz[i][k] + matriz[k][j])
						matriz[i][j] = matriz[i][k] + matriz[k][j];
				}
			}
		}
		System.out.println("");
		System.out.println("-----------------Floyd Warshall-----------------");
		for(int i = 0; i < g.vertices.length; i++) {
			System.out.println("");
			for(int j = 0; j < g.vertices.length; j++) {
					System.out.print("    " + matriz[i][j]);
			}
		}
	}
	
	public void fordFulkerson(Grafos g, int fonte, int sumidouro) {
		buscarCaminho(g.vertices[fonte],g);//Setando caminhos
		int[][] matrizArestas = geraMatriz(g);
		int fluxomax = 0;
		int fluxomin = Integer.MAX_VALUE;

		while(g.vertices[sumidouro].pai != null) {
			Vertice verticeatual = g.vertices[sumidouro];
			fluxomin = Integer.MAX_VALUE;
			while(verticeatual.num != fonte) {//Buscando fluxo minimo
				if(matrizArestas[verticeatual.pai.num][verticeatual.num] < fluxomin) {//Calculando fluxo minimo do caminho
					fluxomin = matrizArestas[verticeatual.pai.num][verticeatual.num];
				}
				if(g.vertices[verticeatual.num].pai != null) {
					verticeatual = verticeatual.pai;
				}
			}
			verticeatual = g.vertices[sumidouro];
			while(verticeatual.num != fonte) {//Atualizando grafo
					matrizArestas[verticeatual.pai.num][verticeatual.num] -= fluxomin;
					if(matrizArestas[verticeatual.pai.num][verticeatual.num] == 0) {
						g.vertices[verticeatual.pai.num].adj.remove(verticeatual);
					}
					verticeatual = verticeatual.pai;
				}
			fluxomax += fluxomin;
			buscarCaminho(g.vertices[fonte],g);//fazendo nova busca de caminho
		}
		System.out.println("");
		System.out.println("-----------------Ford Fulkerson-----------------");
		System.out.println("Fluxo maximo : " + fluxomax);
	}
	
	public void buscarCaminho(Vertice e, Grafos g) {//Busca em largura sem os sysout
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
	}

	public void kruskal(Grafos g, Vertice v) {

		List<Arestas> aresta = new ArrayList<Arestas>();
		
		g.arestas.sort(new Comparator<Arestas>() {//Organiza as arestas em ordem do menor peso para o maior peso
			public int compare(Arestas a1, Arestas a2) {
				if(a1.peso < a2.peso)
					return -1;
				else 
					return +1;
			}
		});

		for(Arestas a: g.arestas) {//Percorre todas as arestas
			if(g.vertices[a.fim].cor == 0) {//Verifica se o vertice não foi visitado ainda
				g.vertices[a.fim].cor = 1;//Indica que o vertice foi visitado e esta na arvore
				aresta.add(a);//Adiciona a aresta a cojunto de arestas da MST
			}
		}
		
		aresta.sort(new Comparator<Arestas>() {//Organiza as arestas em ordem de vertices
			public int compare(Arestas a1, Arestas a2) {
				if(a1.inicio < a2.inicio)
					return -1;
				else
					return +1;
			}
		});
		System.out.println("-----------------Kruskal-----------------");
		for(Arestas a: aresta) {//Imprime arvore
			System.out.println("Aresta " + a.inicio + " -> " + a.fim + " Peso " + a.peso);
		}
	}

	public void prim(Grafos g,Vertice r) {
		int[][] matriz = geraMatriz(g);//Matriz com os pesos
		
		for(Vertice u: g.vertices) {//Iniciando vertices
			u.d = Integer.MAX_VALUE;
			u.pai = null;
		}
		r.d = 0;//Iniciando primeiro vertice
		
		List<Vertice> vertices = new ArrayList<Vertice>();//Criando lista de prioridade
		Collections.addAll(vertices, g.vertices);
		vertices.sort(new Comparator<Vertice>() {//Organizando lista com base nas distancias
			public int compare(Vertice v1, Vertice v2) {
				if(v1.d < v2.d)
					return -1;
				else return +1;
			}
		});
		
		while(vertices.size() != 0) {
			Vertice u = vertices.get(0);
			vertices.remove(u);
			for(Vertice v: u.adj) {
				if(vertices.contains(v) && matriz[u.num][v.num] < v.d) {
					v.pai = u;
					v.d = matriz[u.num][v.num];
				}
			}
			
		}
		
		System.out.println("----------------- PRIM -----------------");
		
		for(Vertice v: g.vertices) {
			if(v.pai != null)
				System.out.println(v.pai.num + " -> " + v.num + "  Peso " + v.d);
		}
	}
}
