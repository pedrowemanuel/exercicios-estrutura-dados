package listas;

public class LIFO extends ListaDuploNo {
	public LIFO() {
		super();
	}
	public LIFO(DuploNo primeiro, DuploNo ultimo) {
		super(primeiro, ultimo);
	}
	public void addInPosition(No noNovo, int posicao) {
	}
	public void addOnFirst(No noNovo) {
	}
	public DuploNo pop() {
		DuploNo noRemovido = null;
		if(primeiro == null) {
			return null;
		} else if(ultimo == null) {
			noRemovido = primeiro;
			primeiro = null;
		} else {
			noRemovido = ultimo;
			ultimo.getAnterior().setProximo(null);
			ultimo = ultimo.getAnterior();
		}

		count--;
		return noRemovido;
	}
}
