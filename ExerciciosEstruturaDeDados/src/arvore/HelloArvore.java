package arvore;

public class HelloArvore {

	public static void main(String[] args) throws Exception {
		
		ArvoreBinario arvoreBinario = new ArvoreBinario();
		arvoreBinario.addNo("folha1", "esquerda", null);
		arvoreBinario.addNo("folha2", "direita", null);
		
		System.out.println(arvoreBinario.searchNo("folha1").getDescricao());
		System.out.println(arvoreBinario.searchNo("folha2").getDescricao());

		arvoreBinario.removeAllNo("folha1");
		
		System.out.println(arvoreBinario.searchNo("folha1").getDescricao());
	}
}
