package Controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entitys.Medicamento;
import telas.TelaMedicamento;

public class ControleMedicamento {
	FileReader fr;
	BufferedReader bf;

	public static void salvarMedicamento(Medicamento m) {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("medicamentos.txt",true));
			try {
				write.write("ID;" + m.getIdMedicamento());
				write.newLine();
				write.write("Nome;" + m.getNome());
				write.newLine();
			}catch(IOException e) {}
			write.flush();
			write.close();
		}catch(IOException e) {}
	}
	
	public static void novoMedicamento(TelaMedicamento tm) {
		Medicamento m = new Medicamento(tm.getIdMedicamento(),tm.getNome());
		salvarMedicamento(m);
	}
	
    public void lerArquivo() throws IOException{
    	
    	String[] medicamento = null;
    	fr = new FileReader("medicamentos.txt");
    	bf = new BufferedReader(fr);
    	String line = "";
    	while((line = bf.readLine()) != null) {
    		medicamento = line.split(";");
    		System.out.println(medicamento[0] + ": " + medicamento[1]);
    	}
    	fr.close();
    	bf.close();
    }
}
