package cpu;

public class main {
	
	public static Memoria mem;
	
	public static void main(String[] args) {
		
		mem = new Memoria();
		//Inserindo dados na memoria
		mem.memoria.add("0001");//0
		mem.memoria.add("0010");//1
		mem.memoria.add("0100");//2
		
		//Somando/subtraindo dados na memoria
		//Não é necessário ordem na soma e subtracao
		
		mem.memoria.add("00000f000f01");//3
		mem.memoria.add("000001011010");//4
		mem.memoria.add("00000f010001");//5
		mem.memoria.add("00000f020001");//6 

		//Multiplicando dados na memoria
		//Não é necessário ordem na multiplicacao
		
		mem.memoria.add("100000100101");//7 5x2//Ultrapassa o limite de bits suportados, se torna negativo
		mem.memoria.add("100000100010");//8 2x2
		mem.memoria.add("100000100011");//9 2x3
		mem.memoria.add("100000100100");//10 2x4//Ultrapassa o limite de bits suportados, se torna negativo
		mem.memoria.add("100001000001");//11 4x1
		mem.memoria.add("10000f000f01");//12 Multiplicando dois numeros já salvos na memoria 
		mem.memoria.add("100010100010");	//13 Multiplicando -2x2
		
		//Trabalhar com numeros na memoria nessa forma pode se tornar muito complexo por não saber onde eles estão alocados

		//Divisão
		//Ordem divisor, dividendo
		
		mem.memoria.add("100101010111");	//14	7/5
		mem.memoria.add("100100100101");	//15	5/2
		mem.memoria.add("100100010010");	//16	2/1
		mem.memoria.add("100101000111");	//17	7/4
		mem.memoria.add("100110100100");	//18	4/-2
		
		
		ULA ula = new ULA();
		UnidadeDeControle ucd = new UnidadeDeControle();
		ucd.rollMemory(mem.getMemoria());
		
	}

}
