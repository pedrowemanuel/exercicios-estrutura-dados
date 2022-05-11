package arvore;

public class ArvoreBinario {
	private NoBinario root;

	public ArvoreBinario() {
		super();
		this.root = new NoBinario("raiz");
	}

	public ArvoreBinario(NoBinario root) {
		super();
		if (root == null) {
			this.root = new NoBinario("raiz");
		} else {
			this.root = root;
		}
	}

	public void addNo(String Add, String posicao, NoBinario noPai) {
		NoBinario noToAdd = new NoBinario(Add);
		if (noPai == null) {
			addFilho(noToAdd, posicao, root);
		} else {
			addFilho(noToAdd, posicao, noPai);
		}
	}

	private void addFilho(NoBinario noToAdd, String posicao, NoBinario pai) {
		if (posicao.equals("direita")) {
			pai.setDireita(noToAdd);
		} else {
			pai.setEsquerda(noToAdd);
		}
	}
	
	public void removeAllNo(String noToRemove) throws Exception {
		NoBinario noFound = searchNo(noToRemove);
		
		removeAllNoRecursive(noFound);
	}
	
	private void removeAllNoRecursive(NoBinario iterationNo) {
		if(iterationNo != null) {
			if(iterationNo.getEsquerda() == null && iterationNo.getDireita() == null) {
				iterationNo = null;
			} else {				
				removeAllNoRecursive(iterationNo.getEsquerda());
				removeAllNoRecursive(iterationNo.getDireita());
			}
			
		}
	}
	
	public NoBinario searchNo(String noToSearch) throws Exception {
		NoBinario noFound = searchNoRecursive(noToSearch, root);
		
		if(noFound == null) {
			throw new Exception("Nenhum resultado encontrado!");
		}

		return noFound;
	}
	
	private NoBinario searchNoRecursive(String noToRemove, NoBinario iterationNo) {
		if(iterationNo == null) {
			return null;
		}
		if(iterationNo.getDescricao().equals(noToRemove)) {
			return iterationNo;
		}
		
		NoBinario lineageNoEsquerda = searchNoRecursive(noToRemove, iterationNo.getEsquerda());
		
		if(lineageNoEsquerda != null) {
			return lineageNoEsquerda;
		}
	
		return searchNoRecursive(noToRemove, iterationNo.getDireita());
	}
	
}
