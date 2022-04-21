package cpu;

import java.util.List;

public class UnidadeDeControle {
	
	private int pc = 0; // Registradores da UC
	private String ir;
	private String mar;
	
	private ULA ula;
	
	
	public void rollMemory(List<String> mem) {
		ula = new ULA();
		nextPc(-1,mem);
	}
	
	public void nextPc(int i,List<String> mem) {//Fetch next operation
		pc = i;
		nextIr(i+1,mem);
	}
	
	public void nextIr(final int i,List<String> mem) {//Fetch next word
		if(i < mem.size()){
			ir = mem.get(i);
			nextMar(ir,mem, i);
			new Thread() {
				public final int pos = i;
				public void run() {
					nextPc(pos, mem);
				}
			}.start();;
		}
	}
	
	public void nextMar(String ir,List<String> mem,int i) {//Fetch next operands
		mar = ir;
		ula.mbr = ir.substring(0,4);
		if(mar.length() > 6) {
			if(mar.substring(4, 6).equals( "0f")) {//Passando endereco de memoria, Unidade de controle le memoria
				int pos = Integer.parseInt(mar.substring(6,10));
				ula.mq = mem.get(pos);//Passa os operandos para a ula
			}else {
				ula.mq = mar.substring(4,10);
			}
			
			if(mar.substring(10, 12).equals( "0f")) {//Passando endereco de memoria, Unidade de controle le memoria
				int pos = Integer.parseInt(mar.substring(12,16));
				ula.ac = mem.get(pos);//Passa os operandos para a ula
			}else {
				ula.ac = mar.substring(10,16);//Passa os operandos para a ula
			}
			nextCalc(mem,i);
		}
	
	}
	
	public void nextCalc(List<String> mem,int i) {//Fetch next calc
		System.out.println("-----------------------------------------------------------------------------------------");
		ula.calculate();
		nextWrite(mem,i);
	}
	
	public void nextWrite(List<String> mem, int i) {//Fetch next write
		System.out.println("Salvando dados " + (pc+1));
		System.out.println("Registradores estão salvos da seguinte forma PC: " + (i+1) + " IR : " + mem.get(i+1) +" MAR " + mem.get(i+1));
		System.out.println("-----------------------------------------------------------------------------------------");
		mem.add(ula.ac);
	}
}
