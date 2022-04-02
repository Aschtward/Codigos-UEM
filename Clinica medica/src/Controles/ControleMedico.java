
package Controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entitys.Medico;
import telas.TelaMedico;

/**
 *
 * @author guest-ey3e4n
 */
public class ControleMedico {
    
    Medico pc;
    FileWriter fw;
    BufferedWriter bw;
    BufferedReader bf;
    FileReader fr;

    
    public void lerArquivo() throws IOException{
    	
    	String[] aux = null;
    	fr = new FileReader("medicos.txt");
    	bf = new BufferedReader(fr);
    	String line = "";
    	while((line = bf.readLine()) != null) {
    		aux = line.split(";");
    		System.out.println(aux[0] + ": " + aux[1]);
    	}
    	fr.close();
    	bf.close();
    }
    
    
    private void abrirArquivo() throws IOException{
        
		BufferedWriter write = null;
		String[] val1 = {"Nome","CPF","Endereco","Telefone","Crm","Especialidade"};
		String[] val2 = {pc.getNome(), pc.getCpf(),pc.getEndereco(),pc.getTelefone(),pc.getCrm(),"" + pc.getEspecialidade()};
		try {
			write = new BufferedWriter(new FileWriter("medicos.txt",true));
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
    
    public void gravarArquivo(TelaMedico dadoMedico) throws IOException{
        
        pc = new Medico(dadoMedico.getCrm(),
                dadoMedico.getNome(), 
                dadoMedico.getCpf(), 
                dadoMedico.getEndereco(), 
                dadoMedico.getTelefone());
        pc.setEspecialidade(dadoMedico.getEspecialidade());
        abrirArquivo();
    }
    
}
