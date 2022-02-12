
package aulaPoo0902;

/**
*
* @author Leonardo Ribeiro Goulart
* Ra: 115642
*/
public class Pessoa {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    protected void cadastrarPessoa(String nome, String cpf, String endereco, String telefone){
        setNome(nome);
        setCpf(cpf);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    public String toString1() {
        return  " Nome : " + nome + " Cpf : " + cpf + " Endereco : " + endereco + " Telefone : " + telefone + " ";
    }
    
    
}
