package cpu;


public class ULA {
	
	public String mq;
	public String ac;
	public String mbr;
	public boolean of = false;
	
	public void calculate() {
		
		if(ac.charAt(0) == '1') {
			ac = complemento2(ac);
		}
		if(mq.charAt(0) == '1') {
			mq = complemento2(mq);
		}
		decodificador(mbr,ac,mq);
	}
	
	public String complemento2(String dado) {
		
		char[] dadoEmComplemento = new char[6];
		int p = -1;
		
		for(int i = dado.length()-1; i > 0;i--) {
			if(dado.charAt(i) == '1') {
				dadoEmComplemento[i] = '1';
				p = i-1;
				break;
			}
			dadoEmComplemento[i] = '0';
		}
		
		while(p > -1) {
			if(dado.charAt(p)== '1') {
				dadoEmComplemento[p] = '0';
			}else {
				dadoEmComplemento[p] = '1';
			}
			p--;
		}
		dadoEmComplemento[0] = '1';
		return String.valueOf(dadoEmComplemento);
	}
	
	public int decodificador(String opcode,String dado1,String dado2) {
		
		if(opcode.equals("0000")) {
			System.out.println("Soma");
			ac = soma(dado1,dado2);//Soma
			System.out.println("Resultado da : " + ac);
			if(of == true) {
				System.out.println("Houve overflow");
			}
		}
		if(opcode.equals("0001")) {
			if(dado1.equals(dado2)) {
				return 1;//Equals
			}
			return 0;
		}
		if(opcode.equals("0010")) {
			if(dado1.equals("1111") || dado2.equals("1111")) {
				return 1;//OR
			}
			return 0;
		}
		if(opcode.equals("0011")) {
			if(dado1.equals("1111") || dado2.equals("1111")) {
				return 0;//NOR
			}
			return 1;
		}
		if(opcode.equals("0100")) {
			if(dado1.equals("1111") && dado2.equals("1111")) {
				return 1;//AND
			}
			return 0;
		}
		if(opcode.equals("0101")) {
			if(dado1.equals("1111") && dado2.equals("1111")) {
				return 0;//	NAND
			}
			return 1;
		}
		if(opcode.equals("0110")) {
			if(dado1.equals(dado2)) {
				System.out.println("Os numeros são iguais!");
				return 1;
			}else {
				System.out.println("Os numeros são diferentes!");
				return 0;
			}
		}
		if(opcode.equals("0111")) {
			inverter(dado1,dado2);
			return 1;//Inverter
		}
		if(opcode.equals("1000")) {
			ac = multiplicacao(ac,mq);
			System.out.println("Resultado multiplicacao: " + ac);
			return 1;
		}
		if(opcode.equals("1001")) {
			dividir(dado1,dado2);
			return 1;//Divisao
		}
		return -1;//erro no decodificador de instrução
	}
	
	private void dividir(String ac2, String mq2) {
		String dividendo = ac2;
		String divisor = mq2;
		String resultado = "000000";

		if(divisor.charAt(0) == '0' && dividendo.charAt(0) == '0') { // Se os dois numero são positivos então tornamos o divisor negativo
			divisor = soma(divisor,"100000");
			divisor = complemento2(divisor);
		}else if(divisor.charAt(0) =='1' && dividendo.charAt(0) == '1') {// Se os dois são negativos então tornamos o dividendo positivo
			dividendo = complemento2(dividendo);
			dividendo = soma(dividendo,"100000");
		}else if(dividendo.charAt(0) == '1' && divisor.charAt(0) == '0') {//Se o dividendo é negativo o tornamos positivo e se o divisor é positivo o tornamos negativo
			dividendo = complemento2(dividendo);
			dividendo = soma(dividendo,"100000");
			divisor = soma(divisor,"100000");
			divisor = complemento2(divisor);
		}
		
		while(soma(dividendo,divisor).charAt(0) != '1') {
				dividendo = soma(dividendo,divisor);
				resultado = soma(resultado,"000001");
		}
		if(ac2.charAt(0) == '0' && mq2.charAt(0) == '1' || ac2.charAt(0) == '1' && mq2.charAt(0) == '0') {
			resultado = soma(resultado,"100000");
		}
		System.out.println("Resultado da divisão é: " + resultado);
		System.out.println("Resto da divisâo é: " + dividendo);
		
	}

	private void inverter(String mq2, String ac2) {
		String dado1 = "", dado2 = "";
		for(int i = 0 ; i < mq2.length();i++) {
			if(mq2.charAt(i) == '1') {
				dado1 += '0';
			}else {
				dado1 += '1';
			}
		}
		for(int i = 0 ; i < ac2.length();i++) {
			if(ac2.charAt(i) == '1') {
				dado2 += '0';
			}else {
				dado2 += '1';
			}
		}
		System.out.println("Inversao: " + dado1 +" " + dado2);
		
	}

	public String soma(String dado1,String dado2) {
		
		char[] dadofinal = new char[6];
		char cIn = '0',cOut = '0';
		of = false;
		
		for(int i = 5; i > -1 ; i--) {
			if(i == 0 && dado1.charAt(i) == '1' && dado2.charAt(i) == '1' || i == 0 && dado1.charAt(i) == '1' && cIn =='1' || i == 0 && dado2.charAt(i) == '1' && cIn == '1') {
				of = true;
			}
			if(dado1.charAt(i) == '0' && dado2.charAt(i) == '0' && cIn == '0' ) {
				dadofinal[i] = '0';
				cOut = '0';
			}else if(dado1.charAt(i) == '0' && dado2.charAt(i) == '0' && cIn == '1' ) {
				dadofinal[i] = '1';
				cOut = '0';
			}else if(dado1.charAt(i) == '0' && dado2.charAt(i) == '1' && cIn == '0' ) {
				dadofinal[i] ='1';
				cOut = '0';
			}else if(dado1.charAt(i) == '0' && dado2.charAt(i) == '1' && cIn == '1' ) {
				dadofinal[i] = '0';
				cOut = '1';
			}else if(dado1.charAt(i) == '1' && dado2.charAt(i) == '0' && cIn == '0' ) {
				dadofinal[i] = '1';
				cOut = '0';
			}else if(dado1.charAt(i) == '1' && dado2.charAt(i) == '0' && cIn == '1' ) {
				dadofinal[i] = '0';
				cOut = '1';
			}else if(dado1.charAt(i) == '1' && dado2.charAt(i) == '1' && cIn == '0' ) {
				dadofinal[i] = '0';
				cOut = '1';
			}else if(dado1.charAt(i) == '1' && dado2.charAt(i) == '1' && cIn == '1' ) {
				dadofinal[i] = '1';
				cOut = '1';
			}
			cIn = cOut;
		}
		return String.valueOf(dadofinal);
	}
	
	public String multiplicacao(String dado1,String dado2) {
		String dadoin1 = dado1, dadoin2 = dado2;
		//Transformando para numero positivo
		String dadoFinal = "000000";
		if(dadoin1.charAt(0) == '1') {
			dadoin1 = complemento2(dadoin1);
			dadoin1 = soma(dadoin1,"100000");
		}
		if(dadoin2.charAt(0) == '1') {
			dadoin2 = complemento2(dadoin2);
			dadoin2 = soma(dadoin2,"100000");
		}
		//Somando até chegar a 0
		while(!soma(dadoin1,"111111").equals("111111")) {
			dadoFinal = soma(dadoFinal,dadoin2);
			dadoin1 = soma(dadoin1,"111111");
		}
		//Colocando o sinal
		if(dado1.charAt(0) == '1' && dado2.charAt(0) == '0' || dado1.charAt(0) == '0' && dado2.charAt(0) == '1') {
			dadoFinal = soma(dadoFinal,"100000");//Invertendo o sinal
		}
		return dadoFinal;
	}
}
