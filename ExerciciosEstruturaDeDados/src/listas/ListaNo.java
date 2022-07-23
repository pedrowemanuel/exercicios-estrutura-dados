package listas;

public class ListaNo {
	No primeiro;
	No ultimo;
	protected long count = 0;

	public void add(No no) {
		if (primeiro == null) {
			primeiro = no;
		} else if (ultimo == null) {
			ultimo = no;
			primeiro.setProximo(ultimo);
		} else {
			ultimo.setProximo(no);
			ultimo = no;
		}
		count++;
	}
	
	public ListaNo() {
		this(null, null);
	}

	public ListaNo(No primeiro, No ultimo) {
		super();
		this.primeiro = primeiro;
		this.ultimo = ultimo;
	}

	public void varrerListaDupla(No duplo) {
		if (duplo.getProximo() != null) {
			System.out.println(duplo);
			varrerListaDupla(duplo.getProximo());
		} else {
			System.out.println(duplo);
		}
	}

	private int varrerListPraContar(No no) {
		if (no.getProximo() == null) {
			return 1;
		} else {
			return 1 + varrerListPraContar(no.getProximo());
		}
	}

	public int countManual() {
		if (primeiro == null) {
			return 0;
		} else if (ultimo == null) {
			return 1;
		}
		return varrerListPraContar(primeiro);
	}

	public No varrerListaBuscarNoPorDescricao(No no, String busca) {
		if (no == null) {
			return null;
		}
		if (no.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return no;
		}
		return varrerListaBuscarNoPorDescricao(no.getProximo(), busca);
	}

	public boolean containsName(String descricao) {
		if (varrerListaBuscarNoPorDescricao(primeiro, descricao) == null) {
			return false;
		}
		return true;
	}
	
	public int varrerListaBuscarPosicao(No no, String busca) {
		if (no == null) {
			return -1;
		}
		if (no.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return 0;
		}
		
		int posicao = varrerListaBuscarPosicao(no.getProximo(), busca);
		
		if(posicao < 0) {
			return posicao;
		}
		
		return posicao + 1;
	}
	
	public int indexOf(String descricao) {
		return varrerListaBuscarPosicao(primeiro, descricao);
	}
	
	private void varrerListPraExibir(No no, int posicao) {
		System.out.println(no + ", Posição: " + posicao);
		
		if (no.getProximo() != null) {
			varrerListPraExibir(no.getProximo(), ++posicao);
		}
	}

	public void printLista() {
		if (primeiro != null) {
			varrerListPraExibir(primeiro, 0);
		}
	}
	
	private No varrerListPraPegarElementoPosicao(No no, int posicao) {
		if(posicao == 0) {
			return no;
		}
		if (no.getProximo() == null) {
			return null;
		}
		
		return varrerListPraPegarElementoPosicao(no.getProximo(), --posicao);
	}

	public long getCount() {
		return count;
	}
	
	public void addInPosition(No noNovo, int posicao) {
		if (primeiro == null) {
			primeiro = noNovo;
			count++;
		} else {
			No noPosicaoAtual = varrerListPraPegarElementoPosicao(primeiro, 0);
			
			if(noPosicaoAtual != null) {
				noNovo.setProximo(noPosicaoAtual);
				
				if(posicao == 0) {
					primeiro = noNovo;
				} else if(ultimo.equals(noPosicaoAtual)) {
					ultimo = noNovo;
				}

				count++;
			}
		}
	}

	public void addOnFirst(No noNovo) {
		if (primeiro == null) {
			primeiro = noNovo;
		} else if (ultimo == null) {
			ultimo = primeiro;
			noNovo.setProximo(ultimo);
			primeiro = noNovo;
		} else {
			noNovo.setProximo(primeiro);
			primeiro = noNovo;
		}
		
		count++;
	}
}