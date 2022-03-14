/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos1;

import java.util.List;

/**
 *
 * 0 - branco 1 - cinza 2 - preto
 * @author guest-6piceq
 */
public class Buscas {
    
    public void buscaEmLargura(Vertice e, Grafos g){
        
        for(Vertice v : g.vertices){
            v.cor = 0;
            v.pai = null;
            v.num = -1;
        }
        
        e.cor = 1;
        e.pai = null;
        e.num = 0;
        List<Vertice> Q = null;
        Q.add(e);
        
        while(!Q.isEmpty()){
            
            Vertice u = Q.remove(0);
            
            for(Vertice v : g.vertices){
                if(v.cor == 0){
                    v.num = u.num + 1;
                    v.pai = u;
                    v.cor = 1;
                    Q.add(v);
                }
                u.cor = 2;
            }
        }
    }
    
    public void Busca_em_profundidade(Grafos G){
        
        for(Vertice v:G.vertices){
            v.cor = 0;
            v.pai = null;
        }
        int t = 0;
        for(Vertice v:G.vertices){
            if(v.cor == 0)
                dfs_visit(v,t);
        }
    }

    private void dfs_visit(Vertice v,int t) {
        t++;
        v.cor = 1;
        v.ini = t;
        for(Vertice u: v.adj){
            if(u.cor == 0){
                u.pai = v;
                dfs_visit(u,t);
            }         
        }
        t++;
        v.cor = 2;
        v.fim = t;

    }
    
}
