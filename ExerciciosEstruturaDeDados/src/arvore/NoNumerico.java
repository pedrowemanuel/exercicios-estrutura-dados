package arvore;

public class NoNumerico {
	private Integer descricao;
	private NoNumerico direita;
	private NoNumerico esquerda;
	private NoNumerico pai;
	
	public NoNumerico(Integer descricao) {
		this.direita = null;
		this.esquerda = null;
		this.pai = null;
		this.descricao = descricao;
	}

	public NoNumerico(Integer descricao, NoNumerico pai,
			NoNumerico direita, NoNumerico esquerda) {
		super();
		this.pai = pai;
		this.descricao = descricao;
		this.direita = direita;
		this.esquerda = esquerda;
	}

	public Integer getDescricao() {
		return descricao;
	}

	public void setDescricao(Integer descricao) {
		this.descricao = descricao;
	}

	public NoNumerico getDireita() {
		return direita;
	}

	public void setDireita(NoNumerico direita) {
		this.direita = direita;
	}

	public NoNumerico getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoNumerico esquerda) {
		this.esquerda = esquerda;
	}
        
        public NoNumerico getPai() {
		return pai;
	}

	public void setPai(NoNumerico pai) {
		this.pai = pai;
	}
}
