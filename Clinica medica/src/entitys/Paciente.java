/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author guest-4sdrfw
 */
public class Paciente extends Pessoa{
    
    private float peso;
    private float altura;
    private int idade;

    public Paciente(float peso, float altura, int idade, String nome, String cpf, String endereco, String telefone) {
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        cadastro(nome, cpf, endereco, telefone);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.getNome() + ';' + "Peso;" + peso +  "Altura;" + altura + ';' + "Idade;" + idade + ';' + "CPF;" + this.getCpf() + ';' + "Endereco;" + this.getEndereco() + ';' + "telefone;" + this.getTelefone() + ';';
    }
    
    
}
