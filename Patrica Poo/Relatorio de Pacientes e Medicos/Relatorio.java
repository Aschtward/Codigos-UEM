package aulaPoo0902;

import java.util.LinkedList;
/**
*
* @author Leonardo Ribeiro Goulart
* Ra: 115642
*/

public class Relatorio {
    
	LinkedList<Medico> medicos;
	LinkedList<Paciente> pacientes;
	
	protected void adicionaMedicos(Medico medico) {
		medicos.add(medico);
	}
	
	protected void adicionaPacientes(Paciente paciente) {
		pacientes.add(paciente);
	}
	
	protected void removePacientes(int pos) {
		this.pacientes.remove(pos);
	}
	
	protected void removeMedicos(int pos) {
		this.medicos.remove(pos);
	}

	@Override
	public String toString() {
		return "Relatorio :\n Medicos: \n" + medicos + "\n Pacientes = \n"  + pacientes;
	}
	
	
}
