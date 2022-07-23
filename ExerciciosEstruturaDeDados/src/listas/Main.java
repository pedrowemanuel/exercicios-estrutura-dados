package listas;

public class Main {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();

		LIFO pilha = new LIFO();		
		
		for (long i = 1; i <= 10000000; i++) {
			pilha.add(new DuploNo(""+i));
		}
		
		System.out.println("Fim da execução");
		
		for (long i = 1; i < 10000000; i++) {
			pilha.pop();
		}
		
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		
		System.out.println("O programa executou em " + tempoFinal + " ms");
	}
}











//FIFO fila = new FIFO();		
//
//for (long i = 1; i <= 10000000; i++) {
//	fila.add(new No(""+i));
//}
//
//System.out.println("Fim da execução");
//
//for (long i = 1; i < 10000000; i++) {
//	fila.shift();
//}
//
//long tempoFinal = System.currentTimeMillis() - tempoInicial;
//
//System.out.println("O programa executou em " + tempoFinal + " ms");

