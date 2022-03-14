/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;

/**
 *
 * @author guest-ey3e4n
 */
public class Medico extends Pessoa{
    
    private String crm;
    private String especialidade;
    
    public void Medico(String crm, String especialidade, String nome, String cpf, String endereco, String telefone){
        cadastro(nome, cpf, endereco, telefone);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
    }
    
    @Override
    public String toString() {
        return this.getNome() +',' + this.getCpf() + ',' + this.getEndereco() + ',' + this.getTelefone() + ',' + getEspecialidade() + ',' + getCrm() + ',';
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
        
}
