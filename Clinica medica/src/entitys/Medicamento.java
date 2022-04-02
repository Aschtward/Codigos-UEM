/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author guest-nhdk5d
 */
public class Medicamento {
	
    private int idMedicamento;
    private String nome;
    
    
	public Medicamento(int idMedicamento, String nome) {
		super();
		this.idMedicamento = idMedicamento;
		this.nome = nome;
	}
	
	public int getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
