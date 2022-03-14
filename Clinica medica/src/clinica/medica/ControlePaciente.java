/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guest-4sdrfw
 */
public class ControlePaciente {
    
    Paciente pc;
    FileWriter fw;
    BufferedWriter bw;

    public ControlePaciente() {
        pc = new Paciente();
    }


    
    private void abrirArquivo() throws IOException{
        
        File aq = new File("/tmp/guest-ey3e4n/NetBeansProjects/arq");
        fw = new FileWriter(aq, true);
        bw = new BufferedWriter(fw);
        bw.write(pc.toString());
        fecharArquivo();

    }
    
    public void gravarArquivo(TelaPaciente dadoPaciente) throws IOException{
        
        pc.Paciente(dadoPaciente.getPeso(), 
                dadoPaciente.getAltura(), 
                dadoPaciente.getIdade(),
                dadoPaciente.getNome(), 
                dadoPaciente.getCpf(), 
                dadoPaciente.getEndereco(), 
                dadoPaciente.getTelefone());
        abrirArquivo();
    }
    
    private void fecharArquivo() throws IOException{
        bw.close();
        fw.close();
    }
}
