/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entitys.Paciente;
import telas.TelaPaciente;

/**
 *
 * @author guest-4sdrfw
 */
public class ControlePaciente {
    
    Paciente pc;
    FileWriter fw;
    BufferedWriter bw;
    BufferedReader bf;
    FileReader fr;
    
    public void lerArquivo() throws IOException{
    	
    	String[] aux = null;
    	fr = new FileReader("pacientes.txt");
    	bf = new BufferedReader(fr);
    	String line = "";
    	while((line = bf.readLine()) != null) {
    		aux = line.split(";");
    		System.out.println(aux[0] + aux[1]);
    	}
    	fr.close();
    	bf.close();
    }

    private void abrirArquivo() throws IOException{
		BufferedWriter write = null;
		String[] val1 = {"Nome","CPF","Endereco","Telefone","Peso","Altura","Idade"};
		String[] val2 = {pc.getNome(), pc.getCpf(),pc.getEndereco(),pc.getTelefone(),"" + pc.getPeso(),"" +pc.getAltura(),"" +pc.getIdade()};
		try {
			write = new BufferedWriter(new FileWriter("pacientes.txt",true));
		}catch(IOException e) {}
		for(int i = 0; i < val1.length; i++) {
			String current = val1[i];
			current += ";";
			current += val2[i];
			try {
				write.write(current);
				if(i < val1.length) {
					write.newLine();
				}
			}catch(IOException e) {}
		}
		try {
			write.flush();
			write.close();
		}catch(IOException e) {}

    }
    
    public void gravarArquivo(TelaPaciente dadoPaciente) throws IOException{
        
        pc = new Paciente(dadoPaciente.getPeso(), 
                dadoPaciente.getAltura(), 
                dadoPaciente.getIdade(),
                dadoPaciente.getNome(), 
                dadoPaciente.getCpf(), 
                dadoPaciente.getEndereco(), 
                dadoPaciente.getTelefone());
        abrirArquivo();
    }

}
