package atividade_avaliativa_recursao_06_04_22;

public class Questao03 {
	public static void main(String[] args) {
		sequenciaFibonacci(10);
	}
	
	public static int posicaoFibonacci(int posicao) {
		if(posicao <= 1) {
			return 0;
		}
		if(posicao == 2) {
			return 1;
		}
		
		return posicaoFibonacci(posicao - 1) + posicaoFibonacci(posicao - 2);
	}

	public static void sequenciaFibonacci(int posicao) {
		if(posicao >= 1) {
			sequenciaFibonacci(posicao - 1);
			System.out.print(posicaoFibonacci(posicao) + " ");;
		}
	}
}
