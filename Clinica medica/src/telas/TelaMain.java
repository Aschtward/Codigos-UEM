/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.IOException;
import Controles.*;
import entitys.InputClass;

/**
 *
 * @author guest-ey3e4n
 */
public class TelaMain {
    
    private int op;
    private String path, nome;
    
    public TelaMain() throws IOException{
        
        
        op = 0;
        while(op != 8) {
            System.out.println("Digite o que deseja fazer:");
            System.out.println("[1]-Cadastrar pacientes");
            System.out.println("[2]-Cadastrar medicos");
            System.out.println("[3]-Cadastrar especialidades");
            System.out.println("[5]-Receita");
            System.out.println("[6]-Consulta");
            System.out.println("[7]-Cadrastar Medicamento");
            System.out.println("[8]-Sair");
            op = InputClass.in.nextInt();
            if(op == 1){
                TelaPaciente telaPaciente = new TelaPaciente();
                ControlePaciente controlePaciente = new ControlePaciente();
                controlePaciente.gravarArquivo(telaPaciente);
                InputClass.in.nextLine();
            }else if(op == 2){
                TelaMedico telaMedico = new TelaMedico();
                ControleMedico controleMedico = new ControleMedico();
                controleMedico.gravarArquivo(telaMedico);
                InputClass.in.nextLine();
            }else if(op == 3) {
            	TelaEspecialidade telaEspecialidade = new TelaEspecialidade();
       			ControleEspecialidade controleEspecialidade = new ControleEspecialidade();
      			controleEspecialidade.gravarArquivo(telaEspecialidade,path,nome);
           		InputClass.in.nextLine();
            }else if(op == 4) {
            	TelaRegistro telaRegistro = new TelaRegistro();
            }else if(op == 5) {
            	TelaReceita tr = new TelaReceita();
            }else if(op == 6) {
    			TelaAgenda tA = new TelaAgenda();
    			ControleAgenda controleAgenda = new ControleAgenda();
    			controleAgenda.gravarArquivo(tA);
            }else if(op == 7) {
            	TelaMedicamento telaMedicamento = new TelaMedicamento();
            	ControleMedicamento controleMedicamento = new ControleMedicamento();
            	controleMedicamento.novoMedicamento(telaMedicamento);
            	InputClass.in.nextLine();
            }
        }
    }
}
