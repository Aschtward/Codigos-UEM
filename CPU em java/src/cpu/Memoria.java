package cpu;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	public List<String> memoria;

	public Memoria() {
		this.setMemoria(new ArrayList<String>());
	}
	public List<String> getMemoria() {
		return memoria;
	}
	public void setMemoria(List<String> memoria) {
		this.memoria = memoria;
	}
	
}
