
package aulaPoo0902;

import java.util.Date;

/**
*
* @author Leonardo Ribeiro Goulart
* Ra: 115642
*/

public class Medico extends Pessoa {
    
    private String crm;
    private String especialidade;
	protected Date data;

    public String getCrm() {
        return crm;
    }

    private void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    private void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    protected void cadastrarMedico(String crm, String especialidade, String nome, String cpf, String endereco, String telefone){
        setCrm(crm);
        setEspecialidade(especialidade);
        cadastrarPessoa(nome,cpf,endereco,telefone);
    }

    @Override
    public String toString() {
        return "Data de ingresso : " + data + "crm : " + crm + " especialidade : " + especialidade + toString1() + "\n";
    }
    
    
}
