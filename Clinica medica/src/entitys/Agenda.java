package entitys;

import java.util.Date;

public class Agenda {
	
	private Date Data;
	private String horario;
	private int idConsulta;
	
	public void agendarConsulta(Medico medico,Paciente paciente, Date data,String horario) {
		setData(data);
		setHorario(horario);
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
