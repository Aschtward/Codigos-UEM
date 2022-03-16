package Controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import clinica.medica.Especialidade;
import telas.TelaEspecialidade;



public class ControleEspecialidade {
	
    Especialidade es;
    FileWriter fw;
    BufferedWriter bw;
    BufferedReader bf;
    FileReader fr;

    public ControleEspecialidade() {
        es = new Especialidade();
    }
    
    public String[] lerArquivo(String path, String name) throws IOException{
    	
    	String[] especialidade = null;
    	fr = new FileReader(path+name);
    	bf = new BufferedReader(fr);
    	String line = "";
    	while((line = bf.readLine()) != null) {
    		especialidade = line.split(",");
    	}
    	fr.close();
    	bf.close();
    	return especialidade;
    }


    
    private void abrirArquivo(String path, String name) throws IOException{
        
        File aq = new File(path+name);
        fw = new FileWriter(aq, true);
        bw = new BufferedWriter(fw);
        bw.write(es.toString());
        fecharArquivo();

    }
    
    public void gravarArquivo(TelaEspecialidade dadoEspecialidade,String path, String name) throws IOException{
        
        es.Especialidade(dadoEspecialidade.getId(), dadoEspecialidade.getNome());
        abrirArquivo(path,name);
    }
    
    private void fecharArquivo() throws IOException{
        bw.close();
        fw.close();
    }
}
