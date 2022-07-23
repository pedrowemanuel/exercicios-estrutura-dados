package arvore;

public class HelloArvore {

	public static void main(String[] args) throws Exception {
		
		ArvoreBinario arvoreBinario = new ArvoreBinario();

		NoBinario no1 = new NoBinario("no1");
		NoBinario no2 = new NoBinario("no2");
		NoBinario no3 = new NoBinario("no3");
		NoBinario no4 = new NoBinario("no4");
		NoBinario no5 = new NoBinario("no5");
		NoBinario no6 = new NoBinario("no6");

		arvoreBinario.addNo(no1, "esquerda", null);
		arvoreBinario.addNo(no2, "direita", null);
		arvoreBinario.addNo(no3, "esquerda", no1);
		arvoreBinario.addNo(no4, "direita", no1);
		arvoreBinario.addNo(no5, "esquerda", no2);
		arvoreBinario.addNo(no6, "direita", no2);
		
//		System.out.println(arvoreBinario.searchNo("no1").getDescricao());
//		System.out.println(arvoreBinario.searchNo("no2").getDescricao());
//
//		arvoreBinario.removeAllNo("no1");
//		
//		System.out.println(arvoreBinario.searchNo("folha1").getDescricao());

//		ArvoreNumerica arvoreNumerica = new ArvoreNumerica();
//		arvoreNumerica.addNo(1, "esquerda", null);
//		arvoreNumerica.addNo(2, "direita", null);
//		
//		System.out.println("A soma de todos os valores é: " + arvoreNumerica.sum());
		
		if(arvoreBinario.isStrictlyBinary()) {
			System.out.println("A árvore é estritamente binária!");
		} else {
			System.out.println("A árvore não é estritamente binária!");
		}
		
		System.out.println("A altura da árvore é: " + arvoreBinario.getHeight());
		
		if(arvoreBinario.isFull()) {
			System.out.println("A árvore é completa!");
		} else {
			System.out.println("A árvore não é completa!");
		}
		
		if(arvoreBinario.isAmostFull()) {
			System.out.println("A árvore é quase completa!");
		} else {
			System.out.println("A árvore não é quase completa!");
		}
	}
}
