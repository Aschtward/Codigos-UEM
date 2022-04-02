package telas;


import entitys.InputClass;

public class TelaEspecialidade {
	
	private int id;
	private String nome;
	
    public TelaEspecialidade() {
        
    	InputClass.in.nextLine();
        System.out.println("Digite o nome");
        this.setNome(InputClass.in.nextLine());
        System.out.println("Digite o ID");
        this.setId(InputClass.in.nextInt());
        
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
