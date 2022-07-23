package lista_dupla_encadeada;

public class ListaDuploNo {
	DuploNo primeiro;
	DuploNo ultimo;
	private int count = 0;

	public void add(DuploNo duploNo) {
		if (primeiro == null) {
			primeiro = duploNo;
		} else if (ultimo == null) {
			ultimo = duploNo;
			primeiro.setProximo(ultimo);
			ultimo.setAnterior(primeiro);
		} else {
			ultimo.setProximo(duploNo);
			duploNo.setAnterior(ultimo);
			ultimo = duploNo;
		}
		count++;
	}

	public ListaDuploNo(DuploNo primeiro, DuploNo ultimo) {
		super();
		this.primeiro = primeiro;
		this.ultimo = ultimo;
	}

	public void varrerListaDupla(DuploNo duplo) {
		if (duplo.getProximo() != null) {
			System.out.println(duplo);
			varrerListaDupla(duplo.getProximo());
		} else {
			System.out.println(duplo);
		}
	}

	private int varrerListPraContar(DuploNo duploNo) {
		if (duploNo.getProximo() == null) {
			return 1;
		} else {
			return 1 + varrerListPraContar(duploNo.getProximo());
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

	public DuploNo varrerListaBuscarDuploNoPorDescricao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return null;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return duploNo;
		}
		return varrerListaBuscarDuploNoPorDescricao(duploNo.getProximo(), busca);
	}

	public boolean containsName(String descricao) {
		if (varrerListaBuscarDuploNoPorDescricao(primeiro, descricao) == null) {
			return false;
		}
		return true;
	}
	
	public int varrerListaBuscarPosicao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return -1;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return 0;
		}
		
		int posicao = varrerListaBuscarPosicao(duploNo.getProximo(), busca);
		
		if(posicao < 0) {
			return posicao;
		}
		
		return posicao + 1;
	}
	
	public int indexOf(String descricao) {
		return varrerListaBuscarPosicao(primeiro, descricao);
	}
	
	private void varrerListPraExibir(DuploNo duploNo, int posicao) {
		System.out.println(duploNo + ", Posição: " + posicao);
		
		if (duploNo.getProximo() != null) {
			varrerListPraExibir(duploNo.getProximo(), ++posicao);
		}
	}

	public void printLista() {
		if (primeiro != null) {
			varrerListPraExibir(primeiro, 0);
		}
	}
	
	private DuploNo varrerListPraPegarElementoPosicao(DuploNo duploNo, int posicao) {
		if(posicao == 0) {
			return duploNo;
		}
		if (duploNo.getProximo() == null) {
			return null;
		}
		
		return varrerListPraPegarElementoPosicao(duploNo.getProximo(), --posicao);
	}
	
	public void addInPosition(DuploNo duploNoNovo, int posicao) {
		if (primeiro == null) {
			primeiro = duploNoNovo;
			count++;
		} else {
			DuploNo duploNoPosicaoAtual = varrerListPraPegarElementoPosicao(primeiro, 0);
			
			if(duploNoPosicaoAtual != null) {
				duploNoNovo.setAnterior(duploNoPosicaoAtual.getAnterior());
				duploNoNovo.setProximo(duploNoPosicaoAtual);
				duploNoPosicaoAtual.setAnterior(duploNoNovo);
				
				if(posicao == 0) {
					primeiro = duploNoNovo;
				} else if(ultimo.equals(duploNoPosicaoAtual)) {
					ultimo = duploNoNovo;
				}

				count++;
			}
		}
	}

	public void addOnFirst(DuploNo duploNoNovo) {
		if (primeiro == null) {
			primeiro = duploNoNovo;
			count++;
		} else if (ultimo == null) {
			ultimo = primeiro;
			ultimo.setAnterior(duploNoNovo);
			duploNoNovo.setProximo(ultimo);
			primeiro = duploNoNovo;
			count++;
		} else {
			duploNoNovo.setProximo(primeiro);
			primeiro.setAnterior(duploNoNovo);
			primeiro = duploNoNovo;
			count++;
		}
	}

	public int getCount() {
		return count;
	}
}