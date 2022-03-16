/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import clinica.medica.Medico;
import telas.TelaMedico;

/**
 *
 * @author guest-ey3e4n
 */
public class ControleMedico {
    
    Medico pc;
    FileWriter fw;
    BufferedWriter bw;

    public ControleMedico() {
        pc = new Medico();
    }


    
    private void abrirArquivo() throws IOException{
        
        File aq = new File("/tmp/guest-ey3e4n/NetBeansProjects/med");
        fw = new FileWriter(aq, true);
        bw = new BufferedWriter(fw);
        bw.write(pc.toString());
        fecharArquivo();

    }
    
    public void gravarArquivo(TelaMedico dadoMedico) throws IOException{
        
        pc.Medico(dadoMedico.getCrm(),
                dadoMedico.getNome(), 
                dadoMedico.getCpf(), 
                dadoMedico.getEndereco(), 
                dadoMedico.getTelefone());
        abrirArquivo();
    }
    
    private void fecharArquivo() throws IOException{
        bw.close();
        fw.close();
    }
}
