package outros_exercicios_recursividade;

public class SomaArray {
	public static void main(String[] args) {
		double[] array = {1.5, 1.5, 2.5, 2.5, 0, 1};
		System.out.println(somaArray(array, 0));
	}
	
	public static double somaArray(double[] array, int contador) {
		if(contador >= array.length) {
			return 0.0;
		}

		return array[contador] + somaArray(array, ++contador);
	}
}
