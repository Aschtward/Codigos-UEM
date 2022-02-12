
package aulaPoo0902;

import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
*
* @author Leonardo Ribeiro Goulart
* Ra: 115642
*/
public class JavaApplication1 {

    
    public static void main(String[] args) {
        
        
    	int escolha;
    	
    	String crm;
    	String especialidade;
    	String nome;
    	String cpf;
    	String telefone;
    	String endereco;
        String idConvenio;
        float peso;
        int idade;
        float altura;
    	
    	Relatorio relatorio = new Relatorio();
    	relatorio.medicos = new LinkedList<Medico>();
    	relatorio.pacientes = new LinkedList<Paciente>();
    	
        Scanner sc = new Scanner(System.in); //Classe scanner para ler dados.
        
        boolean continua = true;
        
        while(continua) {
        	System.out.println("----------Escolha oque deseja fazer----------");
        	System.out.println("Cadastrar Medicos(1)");
        	System.out.println("Cadastrar Pessoas(2)");
        	System.out.println("Exibir Registro(3)");
        	System.out.println("Remover Medicos(4)");
        	System.out.println("Remover Paciente(5)");
        	System.out.println("Sair(0)");
        	System.out.println("---------------------------------------------");
        	escolha = sc.nextInt();
        	if(escolha == 0) {
        		continua = false;
        	}
        	else if(escolha == 1) {
        		System.out.println("----------Digite os dados do medico----------");
        		
        		sc.nextLine();
        		System.out.println("Nome");
        		nome = new String(sc.nextLine());
        		System.out.println("Crm");
        		crm = new String(sc.nextLine());
        		System.out.println("Especialidade");
        		especialidade = new String(sc.nextLine());
        		System.out.println("Endereco");
        		endereco = new String(sc.nextLine());
        		System.out.println("Telefone");
        		telefone = new String(sc.nextLine());
        		System.out.println("Cpf");
        		cpf = new String(sc.nextLine());
        		

        		Medico medico = new Medico();
        		
        		medico.cadastrarMedico(crm, especialidade, nome, cpf, endereco, telefone);
        		medico.data = new Date();
        		relatorio.adicionaMedicos(medico);
        		
        	}
        	else if(escolha == 2) {
        		System.out.println("----------Digite os dados do paciente----------");
        		
        		sc.nextLine();
        		System.out.println("Nome");
        		nome = new String(sc.nextLine());
        		System.out.println("Id do Convenio");
        		idConvenio = new String(sc.nextLine());
        		System.out.println("Peso");
        		peso = sc.nextFloat();
        		System.out.println("Altura");
        		altura = sc.nextFloat();
        		System.out.println("Idade");
        		idade = sc.nextInt();
        		endereco = new String(sc.nextLine());
        		System.out.println("Endereco");
        		endereco = new String(sc.nextLine());
        		System.out.println("Telefone");
        		telefone = new String(sc.nextLine());
        		System.out.println("Cpf");
        		cpf = new String(sc.nextLine());
        		
        		Paciente paciente = new Paciente();
        		
        		paciente.cadastrarPaciente(idConvenio, peso, idade, altura, nome, cpf, endereco, telefone);
        		paciente.data = new Date();
        		relatorio.adicionaPacientes(paciente);
        	}
        	else if(escolha == 4) {
        		
        		sc.nextLine();
        		int pos = 0;
        		
        		System.out.println("Digite o crm do medico a ser removido");
        		crm = new String(sc.nextLine());
        		
        		ListIterator<Medico> iterador = relatorio.medicos.listIterator(0);
        		while(iterador.hasNext()) {
        			if(crm.equals(iterador.next().getCrm())) {
                		relatorio.removeMedicos(pos);
        			}
        			pos++;	
        		}
        	}
        	else if(escolha == 5) {
        		
        		sc.nextLine();
        		int pos = 0;
        		
        		System.out.println("Digite o cpf do paciente a ser removido");
        		cpf = new String(sc.nextLine());
        		
        		ListIterator<Paciente> iterador = relatorio.pacientes.listIterator(0);
        		while(iterador.hasNext()) {
        			if(cpf.equals( iterador.next().getCpf())) {
        				relatorio.removeMedicos(pos);
        			}
        			pos++;	
        		}
        		
        	}else if( escolha == 3) {
        		System.out.println(relatorio.toString());
        	}
        }
        
        sc.close();    
      
    }
    
}
