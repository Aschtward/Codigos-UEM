package cpu;

public class main {
	
	public static Memoria mem;
	
	public static void main(String[] args) {
		
		mem = new Memoria();
		//Inserindo dados na memoria
		/*
		mem.memoria.add("000001");//0
		mem.memoria.add("000010");//1
		mem.memoria.add("000100");//2
		*/
		//Somando/subtraindo dados na memoria
		//Não é necessário ordem na soma e subtracao
		
		/*
		mem.memoria.add("00000f00000f0001");//3  //2 + 1
		mem.memoria.add("0000000101100010");//4  //5 - 2
		mem.memoria.add("00000f0001000001");//5  //2 + 1
		mem.memoria.add("00000f0002000001");//6  //4 + 1
		*/
		
		//Multiplicando dados na memoria
		//Não é necessário ordem na multiplicacao
		
		/*
		mem.memoria.add("1000000010000101");//7 5x2
		mem.memoria.add("1000000010000010");//8 2x2
		mem.memoria.add("1000000010000011");//9 2x3
		mem.memoria.add("1000000010000100");//10 2x4
		mem.memoria.add("1000000100000001");//11 4x1
		mem.memoria.add("10000f00000f0001");//12 Multiplicando dois numeros já salvos na memoria 
		mem.memoria.add("1000100010000010");//13 Multiplicando -2x2
		*/
		//Trabalhar com numeros na memoria nessa forma pode se tornar muito complexo por não saber onde eles estão alocados

		//Divisão
		//Ordem divisor, dividendo
		
		mem.memoria.add("1001000101000111");	//14	7 / 5
		mem.memoria.add("1000000100000010");	//15	4 * 2
		mem.memoria.add("0000000001000010");	//16	1 + 2
		mem.memoria.add("0000100100000111");	//17   -2 + 7
		mem.memoria.add("1001100010000100");	//18	4 /-2
		
		
		ULA ula = new ULA();
		UnidadeDeControle ucd = new UnidadeDeControle();
		ucd.rollMemory(mem.getMemoria());
		
	}

}
