package Controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entitys.Especialidade;
import telas.TelaEspecialidade;



public class ControleEspecialidade {
	
    Especialidade es;
    FileWriter fw;
    BufferedWriter bw;
    BufferedReader bf;
    FileReader fr;

    
    public void lerArquivo() throws IOException{
    	
    	String[] especialidade = null;
    	fr = new FileReader("especialidade.txt");
    	bf = new BufferedReader(fr);
    	String line = "";
    	while((line = bf.readLine()) != null) {
    		especialidade = line.split(";");
    		System.out.println("Nome:" + especialidade[0] + " ID: " + especialidade[1]);
    	}
    	fr.close();
    	bf.close();
    }


    
    private void abrirArquivo() throws IOException{
        
		BufferedWriter write = null;
		String[] val1 = {"Nome","ID"};
		String[] val2 = {es.getNome(),"" + es.getId()};
		try {
			write = new BufferedWriter(new FileWriter("especialidade.txt",true));
		}catch(IOException e) {}
		String current = "";
		current += val2[0];
		current += ";";
		current += val2[1];
		try {
			write.write(current);
			write.newLine();
		}catch(IOException e) {}
		try {
			write.flush();
			write.close();
		}catch(IOException e) {}

    }
    
    public void gravarArquivo(TelaEspecialidade dadoEspecialidade,String path, String name) throws IOException{
        
        es = new Especialidade(dadoEspecialidade.getId(), dadoEspecialidade.getNome());
        abrirArquivo();
    }
    
}
