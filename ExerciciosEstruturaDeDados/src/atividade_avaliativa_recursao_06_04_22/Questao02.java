package atividade_avaliativa_recursao_06_04_22;

public class Questao02 {
	public static void main(String[] args) {
		System.out.println(contadorPares(10));
	}
	
	public static int contadorPares(int numero) {
		if(numero < 2) {
			return 1;
		}
		
		return 1 + contadorPares(numero - 2);
	}
}
