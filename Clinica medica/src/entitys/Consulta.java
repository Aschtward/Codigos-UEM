package entitys;

import java.util.Date;

public class Consulta {

	private int idConsulta;
	private Date data;
	private String horario;
	private boolean primeiraConsulta;
	private int idPaciente;
	private String nomePaciente;
	private String idMedico;
	private String nomeMedico;
	
	public Consulta(int idConsulta, Date data, String horario, boolean primeiraConsulta, int idPaciente,
			String nomePaciente, String idMedico, String nomeMedico) {
		super();
		this.idConsulta = idConsulta;
		this.data = data;
		this.horario = horario;
		this.primeiraConsulta = primeiraConsulta;
		this.idPaciente = idPaciente;
		this.nomePaciente = nomePaciente;
		this.idMedico = idMedico;
		this.nomeMedico = nomeMedico;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public Date getData() {
		return data;
	}
	public String getHorario() {
		return horario;
	}
	public boolean isPrimeiraConsulta() {
		return primeiraConsulta;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public String getIdMedico() {
		return idMedico;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public void setPrimeiraConsulta(boolean primeiraConsulta) {
		this.primeiraConsulta = primeiraConsulta;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	
}
