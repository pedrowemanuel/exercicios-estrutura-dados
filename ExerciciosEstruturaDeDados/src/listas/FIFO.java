package listas;

public class FIFO extends ListaNo {
	public FIFO() {
		super();
	}
	public FIFO(No primeiro, No ultimo) {
		super(primeiro, ultimo);
	}
	public void addInPosition(No noNovo, int posicao) {
	}

	public void addOnFirst(No noNovo) {
	}
	public No shift() {
		No noRemovido = primeiro;

		if (primeiro != null) {
			primeiro = primeiro.getProximo();
			
			if (primeiro == ultimo) {
				ultimo = null;
			}
			count--;
		}

		
		return noRemovido;
	}
}
