package arvore;

import java.util.ArrayList;

public class ArvoreNumerica {
	private NoNumerico root;
	private ArrayList<Integer> descricoes = new ArrayList<>();

	public ArvoreNumerica() {
		super();
		this.root = new NoNumerico(null);
	}

	public ArvoreNumerica(NoNumerico root) {
		super();
		if (root == null) {
			this.root = new NoNumerico(null);
		} else {
			this.root = root;
		}
	}

	public void addNo(Integer Add, String posicao, NoNumerico noPai) throws Exception {
		NoNumerico noToAdd = new NoNumerico(Add);
		
		if(descricoes.indexOf(Add) > -1) {
			throw new Exception("Esse nó já existe na árvore!");
		}

		if (noPai == null) {
			addFilho(noToAdd, posicao, root);
		} else {
			addFilho(noToAdd, posicao, noPai);
		}
		
		descricoes.add(Add);
	}

	private void addFilho(NoNumerico noToAdd, String posicao, NoNumerico pai) {
                noToAdd.setPai(pai);
		if (posicao.equals("direita")) {
			pai.setDireita(noToAdd);
		} else {
			pai.setEsquerda(noToAdd);
		}
	}
	
	public void removeAllNo(Integer noToRemove) throws Exception {
		NoNumerico noFound = searchNo(noToRemove);
		
		removeAllNoRecursive(noFound);
	}
	
	private void removeAllNoRecursive(
                NoNumerico iterationNo) {
		if(iterationNo != null) {
			if(iterationNo.getEsquerda() != null && iterationNo.getDireita() != null) {			
				removeAllNoRecursive(iterationNo.getEsquerda());
				removeAllNoRecursive(iterationNo.getDireita());
			}
                        
                        if(iterationNo == iterationNo.getPai().getEsquerda()) {			
				iterationNo.getPai().setEsquerda(null);
			}
                        
                        if(iterationNo == iterationNo.getPai().getDireita()) {			
				iterationNo.getPai().setDireita(null);
			}
		}
	}
	
	public NoNumerico searchNo(Integer noToSearch) throws Exception {
		NoNumerico noFound = searchNoRecursive(noToSearch, root);
		
		if(noFound == null) {
			throw new Exception("Nenhum resultado encontrado!");
		}

		return noFound;
	}
	
	private NoNumerico searchNoRecursive(Integer noToRemove, NoNumerico iterationNo) {
		if(iterationNo == null) {
			return null;
		}
		if(iterationNo.getDescricao().equals(noToRemove)) {
			return iterationNo;
		}
		
		NoNumerico lineageNoEsquerda = searchNoRecursive(noToRemove, iterationNo.getEsquerda());
		
		if(lineageNoEsquerda != null) {
			return lineageNoEsquerda;
		}
	
		return searchNoRecursive(noToRemove, iterationNo.getDireita());
	}
	
	public int sum() throws Exception {
		return sumRecursive(root);
	}
	
	private int sumRecursive(NoNumerico iterationNo) {
		if(iterationNo == null) {
			return 0;
		}
		
		int lineageSum = sumRecursive(iterationNo.getEsquerda()) + sumRecursive(iterationNo.getDireita());
		
		if(iterationNo.getDescricao() != null) {
			return iterationNo.getDescricao() + lineageSum;
		}
		
		return lineageSum;
	}
	
}
