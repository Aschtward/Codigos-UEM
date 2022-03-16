package telas;

import java.util.Scanner;

public class TelaEspecialidade {
	
	private int id;
	private String nome;
	
    public TelaEspecialidade() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome");
        this.setNome(sc.nextLine());
        System.out.println("Digite o ID");
        this.setId(sc.nextInt());
        sc.close();
        
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
