/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author guest-ey3e4n
 */
public class TelaMain {
    
    private int op;
    
    public TelaMain() throws IOException{
        
        Scanner sc = new Scanner(System.in);
        
        while(op != 3){
            System.out.println("Digite o que deseja fazer:");
            System.out.println("[1]-Cadastrar pacientes");
            System.out.println("[2]-Cadastrar medicos");
            System.out.println("[3]-Sair");
            op = sc.nextInt();
            if(op == 1){
                        TelaPaciente telaPaciente = new TelaPaciente();
                        ControlePaciente controlePaciente = new ControlePaciente();
                        controlePaciente.gravarArquivo(telaPaciente);
            }else if(op == 2){
                        TelaMedico telaMedico = new TelaMedico();
                        ControleMedico controleMedico = new ControleMedico();
                        controleMedico.gravarArquivo(telaMedico);
            }
        }
    }
}
