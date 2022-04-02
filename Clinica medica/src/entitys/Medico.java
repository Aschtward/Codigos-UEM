/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.time.LocalDateTime;

/**
 *
 * @author guest-ey3e4n
 */
public class Medico extends Pessoa{
    
    private String crm;
    private int especialidade;
    private LocalDateTime dataContratacao;
    
    public Medico(String crm,String nome, String cpf, String endereco, String telefone){
        cadastro(nome, cpf, endereco, telefone);
        this.setCrm(crm);
        this.setDataContratacao(LocalDateTime.now());
        
    }
    
    public int getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDateTime getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDateTime localDateTime) {
		this.dataContratacao = localDateTime;
	}

	@Override
    public String toString() {
        return this.getNome() +',' + this.getCpf() + ',' + this.getEndereco() + ',' + getCrm() + ',' + getDataContratacao();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

        
}
