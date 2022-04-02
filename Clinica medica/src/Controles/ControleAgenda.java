package Controles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import entitys.Agenda;
import telas.TelaAgenda;

public class ControleAgenda {
	
	Agenda novaAgenda;
    FileWriter fw;
    BufferedWriter bw;

    public ControleAgenda() {
        novaAgenda = new Agenda();
    }

    private void abrirArquivo() throws IOException{
		BufferedWriter write = null;
		String[] val1 = {"Data","Horario","idConsulta"};
		String[] val2 = {"" + novaAgenda.getData(), novaAgenda.getHorario(),"" + novaAgenda.getIdConsulta()};
		try {
			write = new BufferedWriter(new FileWriter("agenda.txt",true));
		}catch(IOException e) {}
		for(int i = 0; i < val1.length; i++) {
			String current = val1[i];
			current += ";";
			current += val2[i];
			try {
				write.write(current);
				if(i < val1.length - 1) {
					write.newLine();
				}
			}catch(IOException e) {}
		}
		try {
			write.flush();
			write.close();
		}catch(IOException e) {}

    }
    
    public void gravarArquivo(TelaAgenda telaAgenda) throws IOException{
        
        novaAgenda.agendarConsulta(telaAgenda.getMedico(),telaAgenda.getPaciente(),telaAgenda.getData(),telaAgenda.getHorario());
        abrirArquivo();
    }
}
