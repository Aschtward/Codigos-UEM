/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.IOException;
import java.util.Scanner;

import Controles.*;

/**
 *
 * @author guest-ey3e4n
 */
public class TelaMain {
    
    private int op;
    private String path, nome;
    
    public TelaMain() throws IOException{
        
        Scanner sc = new Scanner(System.in);
        
        while(op != 5){
            System.out.println("Digite o que deseja fazer:");
            System.out.println("[1]-Cadastrar pacientes");
            System.out.println("[2]-Cadastrar medicos");
            System.out.println("[3]-Cadastrar especialidades");
            System.out.println("[4]-Registros");
            System.out.println("[5]-Sair");
            op = sc.nextInt();
            if(op == 1){
                        TelaPaciente telaPaciente = new TelaPaciente();
                        ControlePaciente controlePaciente = new ControlePaciente();
                        controlePaciente.gravarArquivo(telaPaciente);
            }else if(op == 2){
                        TelaMedico telaMedico = new TelaMedico();
                        ControleMedico controleMedico = new ControleMedico();
                        controleMedico.gravarArquivo(telaMedico);
            }else if(op == 3) {
            			TelaEspecialidade telaEspecialidade = new TelaEspecialidade();
            			ControleEspecialidade controleEspecialidade = new ControleEspecialidade();
            			controleEspecialidade.gravarArquivo(telaEspecialidade,path,nome);
            }else if(op == 4) {
            			TelaRegistro telaRegistro = new TelaRegistro();
            }
        }
        sc.close();
    }
}
