package telas;

import entitys.InputClass;

public class TelaMedicamento {
	
    private int idMedicamento;
    private String nome;
    
    public TelaMedicamento() {
        InputClass.in.nextLine();
        System.out.println("Digite o nome");
        this.setNome(InputClass.in.nextLine());
        System.out.println("Digite o id");
        this.setIdMedicamento(InputClass.in.nextInt());
    }
    
	public int getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
