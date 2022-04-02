/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Controles.ControleMedicamento;
import entitys.InputClass;
import entitys.Receita;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author guest-nhdk5d
 */
public class TelaReceita {
    
    private Receita receita;
    
    public TelaReceita(){
        
        
        receita = new Receita();
        System.out.println("--------------------NOVA RECEITA--------------------");
        //receita.setDataValidade(sc.nextDate());
        
        System.out.println("Digite o ID do Paciente");
        receita.setIdPaciente(InputClass.in.nextInt());
        
        System.out.println("Digite o crm do medico");
        receita.setCrm(InputClass.in.nextLine());
        
        receita.setDataValidade(new Date());
        
        ControleMedicamento cm = new ControleMedicamento();
        try {
			cm.lerArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Deseja inserir itens [1] -Sim, [2] -Nao");
        
        int op = InputClass.in.nextInt();
        
        while(op != 2){
        	InputClass.in.nextLine();
            System.out.println("Digite o id do medicamento");
            String id = InputClass.in.nextLine();
            System.out.println("Digite a quantidade");
            receita.AddMedicamento(id,InputClass.in.nextInt());
            System.out.println("Deseja inserir itens [1] -Sim, [2] -Nao");
            op = InputClass.in.nextInt();
        }
    }
}
