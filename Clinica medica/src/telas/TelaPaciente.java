/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import entitys.InputClass;


/**
 *
 * @author guest-4sdrfw
 */
public class TelaPaciente {
    
    private String nome;
    private String cpf;
    private String telefone;
    private float peso;
    private float altura;
    private int idade;
    private String endereco;

    public TelaPaciente() {
        InputClass.in.nextLine();
        System.out.println("Digite o nome");
        this.setNome(InputClass.in.nextLine());
        System.out.println("Digite o CPF");
        this.setCpf(InputClass.in.nextLine());
        System.out.println("Digite o telefone");
        this.setTelefone(InputClass.in.nextLine());
        System.out.println("Digite o peso");
        this.setPeso(InputClass.in.nextFloat());
        System.out.println("Digite o Altura");
        this.setAltura(InputClass.in.nextFloat());
        System.out.println("Digite o idade");
        this.setIdade(InputClass.in.nextInt());
        System.out.println("Digite o Endereco");
        this.setEndereco(InputClass.in.nextLine());
        
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

    public float getPeso() {
        return peso;
    }

    private void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    private void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    
    
}
