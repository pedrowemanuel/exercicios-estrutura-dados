package listas;

public class No {
	private String descricao;
	private No proximo;

	public No(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "Encadeado{" + "descricao='" + descricao + '\'' + '}';
	}
}