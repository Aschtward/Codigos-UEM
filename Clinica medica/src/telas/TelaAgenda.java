package telas;

import java.io.IOException;
import java.util.Date;
import Controles.ControleMedico;
import entitys.InputClass;
import entitys.Medico;
import entitys.Paciente;

public class TelaAgenda {
	
	private Medico medico;
	private Paciente paciente;
	private Date data;
	private String horario;
	
	public TelaAgenda() {
		System.out.println("-----------------Agendar Consulta-----------------");
		ControleMedico cm = new ControleMedico();
		try {
			cm.lerArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Digite o nome do medico");
        System.out.println("Digite o nome do paciente");
        System.out.println("Digite o horario");
        System.out.println("Digite a data");
		
	}
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
