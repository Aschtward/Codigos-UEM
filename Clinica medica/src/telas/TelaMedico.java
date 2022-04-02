/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;


import java.io.IOException;
import java.util.Date;
import Controles.ControleEspecialidade;
import entitys.InputClass;

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
    private int especialidade;
    private Date dataDeContratacao;


    public TelaMedico() {
    	InputClass.in.nextLine();
        System.out.println("Digite o nome");
        this.setNome(InputClass.in.nextLine());
        System.out.println("Digite o CPF");
        this.setCpf(InputClass.in.nextLine());
        System.out.println("Digite o telefone");
        this.setTelefone(InputClass.in.nextLine());
        System.out.println("Digite o Endereco");
        this.setEndereco(InputClass.in.nextLine());
        System.out.println("Digite o crm");
        this.setCrm(InputClass.in.nextLine());
        
        System.out.println("Deseja informar especialidade 1 - Sim, 2 -Não");
        int op = InputClass.in.nextInt();
        if(op == 1) {
    		ControleEspecialidade ce = new ControleEspecialidade();
    		try {
				ce.lerArquivo();
				System.out.println("Digite o id da especialidade do medico");
				this.setEspecialidade(InputClass.in.nextInt());
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
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

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
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
