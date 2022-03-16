/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;

import java.time.LocalDateTime;

/**
 *
 * @author guest-ey3e4n
 */
public class Medico extends Pessoa{
    
    private String crm;
    private int especialidade;
    private LocalDateTime dataContratação;
    
    public void Medico(String crm,String nome, String cpf, String endereco, String telefone){
        cadastro(nome, cpf, endereco, telefone);
        this.setCrm(crm);
        this.setDataContratação(LocalDateTime.now());
        
    }
    
    public int getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDateTime getDataContratação() {
		return dataContratação;
	}

	public void setDataContratação(LocalDateTime localDateTime) {
		this.dataContratação = localDateTime;
	}

	@Override
    public String toString() {
        return this.getNome() +',' + this.getCpf() + ',' + this.getEndereco() + ',' + getCrm() + ',' + getDataContratação();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

        
}
