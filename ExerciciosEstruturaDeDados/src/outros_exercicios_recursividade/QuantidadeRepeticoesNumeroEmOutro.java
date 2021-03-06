package outros_exercicios_recursividade;

public class QuantidadeRepeticoesNumeroEmOutro {
	public static void main(String[] args) {
		System.out.println(quantidadeRepeticoesNumeroEmOutro(2442332, 2));
	}
	
	public static double quantidadeRepeticoesNumeroEmOutro(int numero1, int numero2) {
		if(numero1 <= 0) {
			return 0;
		}
		
		double resto1 = (double)numero1 / 10.0;
		double resto2 = (double)(numero1 / 10);
		float resto3 = ((float) (resto1 - resto2)) * 10;
		int testeIgualdade = (resto3 == numero2) ? 1 : 0;

		return testeIgualdade + quantidadeRepeticoesNumeroEmOutro(numero1 / 10, numero2);
	}
}
