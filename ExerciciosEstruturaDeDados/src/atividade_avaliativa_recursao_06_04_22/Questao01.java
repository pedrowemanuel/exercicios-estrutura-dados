package atividade_avaliativa_recursao_06_04_22;

public class Questao01 {
	public static void main(String[] args) {
		System.out.println(convertDecimalBinario(10));
	}
	
	public static String convertDecimalBinario(int numeroDecimal) {
		if(numeroDecimal == 1) {
			return "1";
		}
		if(numeroDecimal == 0) {
			return "0";
		}
		
		return convertDecimalBinario(numeroDecimal / 2) + (numeroDecimal % 2);
	}
}


