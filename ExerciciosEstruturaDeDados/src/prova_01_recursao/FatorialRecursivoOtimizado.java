package prova_01_recursao;

public class FatorialRecursivoOtimizado {
	public static void main(String[] args) {
		System.out.println(fatorial(10, 1));
	}
	
	/*
	 * Tail-Call Optimization
	 * */
	public static int fatorial(int numero, int contador) {
		if(numero == 0) {
			return contador;
		}

		return fatorial(numero - 1, contador * numero);
	}
}

