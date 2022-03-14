/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author guest-ey3e4n
 */
public final class TelaMedico {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String crm;
    private String especialidade;
    private Date dataDeContratacao;


    public TelaMedico() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome");
        this.setNome(sc.nextLine());
        System.out.println("Digite o CPF");
        this.setCpf(sc.nextLine());
        System.out.println("Digite o telefone");
        this.setTelefone(sc.nextLine());
        System.out.println("Digite o Endereco");
        this.setEndereco(sc.nextLine());
        System.out.println("Digite o crm");
        this.setCrm(sc.nextLine());
        System.out.println("Digite a Especialidade");
        this.setEspecialidade(sc.nextLine());
        
    }
    
    public Date getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(Date dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
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

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

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

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
}
