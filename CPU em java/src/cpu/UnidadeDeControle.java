package cpu;

import java.util.List;

public class UnidadeDeControle {
	
	private int pc = 0;
	private String ir;
	private String mar;
	private ULA ula;
	
	public void rollMemory(List<String> mem) {
		ula = new ULA();
		for(pc = 0; pc < mem.size();pc++) {
			mar = mem.get(pc);//Armazena em mar a instrucao e a referencia de operandos
			if(mar.length()  > 4) {
				ir = mar.substring(0,4);//Armazena instrucao atual
				ula.mbr = ir;//Passa para a Ula a instrucao
				
				if(mar.substring(4, 6).equals( "0f")) {//Passando endereco de memoria, Unidade de controle le memoria
					int pos = Integer.parseInt(mar.substring(6,8));
					ula.mq = mem.get(pos);//Passa os operandos para a ula
				}else {
					ula.mq = mar.substring(4,8);
				}
				
				if(mar.substring(8, 10).equals( "0f")) {//Passando endereco de memoria, Unidade de controle le memoria
					int pos = Integer.parseInt(mar.substring(10,12));
					ula.ac = mem.get(pos);//Passa os operandos para a ula
				}else {
					ula.ac = mar.substring(8,12);//Passa os operandos para a ula
				}
				
				ula.calculate();//Ula decodifica e opera dados.
				mem.add(ula.ac);//Salva novo dado na memoria
			}
		}
	}
	
}
