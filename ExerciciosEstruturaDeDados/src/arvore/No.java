package arvore;

public class No {
	private String descricao;
	private No[] filhos;// N Filhos
	private No pai;

	public No(String descricao) {
		this.descricao = descricao;
		filhos = null;
	}

	public No(String descricao, No[] filhos) {
		super();
		this.descricao = descricao;
		this.filhos = filhos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public No[] getFilhos() {
		return filhos;
	}

	public void setFilhos(No[] filhos) {
		this.filhos = filhos;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}
}
