/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;

/**
 *
 * @author guest-4sdrfw
 */
public class Pessoa {
    
    private int idPessoa;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public void cadastro(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    protected int getIdPessoa() {
        return idPessoa;
    }

    protected void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected String getEndereco() {
        return endereco;
    }

    protected void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    protected String getTelefone() {
        return telefone;
    }

    protected void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
