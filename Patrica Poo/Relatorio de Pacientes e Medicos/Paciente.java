
package aulaPoo0902;

import java.util.Date;

/**
 *
 * @author Leonardo Ribeiro Goulart
 * Ra: 115642
 */
public class Paciente extends Pessoa {
    
    private String idConvenio;
    private float peso;
    private int idade;
    private float altura;
	protected Date data;

    public String getIdConvenio() {
        return idConvenio;
    }

    private void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    public float getPeos() {
        return peso;
    }

    private void setPeos(float peos) {
        this.peso = peos;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    private void setAltura(float altura) {
        this.altura = altura;
    }
    
    protected void cadastrarPaciente( String idConvenio, float peso, int idade, float altura, String nome, String cpf, String endereco, String telefone){
        setIdConvenio(idConvenio);
        setPeos(peso);
        setIdade(idade);
        setAltura(altura);
        cadastrarPessoa(nome,cpf,endereco,telefone);
    }
    
    @Override
    public String toString() {
        return   "Data de ingresso : " + data + "idConvenio : " + idConvenio + ", peso : " + peso + ", idade : " + idade + ", altura : " + altura + toString1() + "\n";
    }
    
    
    
}
