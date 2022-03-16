package Registros;

public class Registro {
	
	String[] reg;
	
	public void imprimirRegistro(String[] reg) {
		
		for(int i = 0; i< reg.length; i++) {
			System.out.println(reg[i].toString());
		}
	}
}
