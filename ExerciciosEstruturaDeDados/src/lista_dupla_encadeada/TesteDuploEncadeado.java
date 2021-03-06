package lista_dupla_encadeada;

public class TesteDuploEncadeado {

	public static void main(String[] args) {
		ListaDuploNo listaDupla = new ListaDuploNo(null, null);

		listaDupla.add(new DuploNo("Daniel"));
		listaDupla.add(new DuploNo("Joao"));
		listaDupla.add(new DuploNo("Francisco"));
		listaDupla.add(new DuploNo("Raimundo"));

		System.out.println("Count manual: " + listaDupla.countManual());
		System.out.println("Count por variavel: " + listaDupla.getCount());
		
		System.out.println("Tem nome francisco2? " + listaDupla.containsName("francisco2"));
	
		//TODO: dizer qual posicao foi encontrado o nome?
		System.out.println("Posição do nome Raimundo: " + listaDupla.indexOf("Raimundo"));

		//TODO: imprimir a lista com quebra de linha e o numero da posição
		listaDupla.printLista();

		//TODO: add em uma posição específica um determinado no
		listaDupla.addInPosition(new DuploNo("Pedro"), 0);

		//TODO: add na frente
		listaDupla.addOnFirst(new DuploNo("Francely"));
	}
}
