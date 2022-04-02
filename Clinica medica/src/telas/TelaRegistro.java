package telas;

import java.io.IOException;
import java.util.Scanner;
import Controles.ControleEspecialidade;


public class TelaRegistro {
	
    public TelaRegistro() throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int op;
        
        do {
        	System.out.println("[1]-Exibir registros de medico");
        	System.out.println("[2]-Exibir registro de pacientes");
        	System.out.println("[3]-Exibir registro de especialidades");
        	System.out.println("[4]-Sair");
        	op =sc.nextInt();
        	if(op == 1) {
        		//Registro de médicos
        	}else if(op == 2) {
        		//Registro de pacientes
        	}else if(op == 3) {
        		//Registro de especialidades
        		ControleEspecialidade ce = new ControleEspecialidade();
        		ce.lerArquivo();
        	}
        }while(op != 4);
        sc.close();
    }
}
