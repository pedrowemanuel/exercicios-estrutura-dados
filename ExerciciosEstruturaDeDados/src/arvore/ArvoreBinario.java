package arvore;

import java.util.ArrayList;

public class ArvoreBinario {
	private NoBinario root;
	private ArrayList<String> descricoes = new ArrayList<>();

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

	public void addNo(String Add, String posicao, NoBinario noPai) throws Exception {
		NoBinario noToAdd = new NoBinario(Add);

		addNo(noToAdd, posicao, noPai);
	}

	public void addNo(NoBinario noToAdd, String posicao, NoBinario noPai) throws Exception {

		if (descricoes.indexOf(noToAdd.getDescricao()) > -1) {
			throw new Exception("Esse nó já existe na árvore!");
		}

		if (noPai == null) {
			addFilho(noToAdd, posicao, root);
		} else {
			addFilho(noToAdd, posicao, noPai);
		}

		descricoes.add(noToAdd.getDescricao());
	}

	private void addFilho(NoBinario noToAdd, String posicao, NoBinario pai) {
		noToAdd.setPai(pai);
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
		if (iterationNo != null) {
			if (iterationNo.getEsquerda() != null && iterationNo.getDireita() != null) {
				removeAllNoRecursive(iterationNo.getEsquerda());
				removeAllNoRecursive(iterationNo.getDireita());
			}

			if (iterationNo == iterationNo.getPai().getEsquerda()) {
				iterationNo.getPai().setEsquerda(null);
			}

			if (iterationNo == iterationNo.getPai().getDireita()) {
				iterationNo.getPai().setDireita(null);
			}
		}
	}

	public NoBinario searchNo(String noToSearch) throws Exception {
		NoBinario noFound = searchNoRecursive(noToSearch, root);

		if (noFound == null) {
			throw new Exception("Nenhum resultado encontrado!");
		}

		return noFound;
	}

	private NoBinario searchNoRecursive(String noToRemove, NoBinario iterationNo) {
		if (iterationNo == null) {
			return null;
		}
		if (iterationNo.getDescricao().equals(noToRemove)) {
			return iterationNo;
		}

		NoBinario lineageNoEsquerda = searchNoRecursive(noToRemove, iterationNo.getEsquerda());

		if (lineageNoEsquerda != null) {
			return lineageNoEsquerda;
		}

		return searchNoRecursive(noToRemove, iterationNo.getDireita());
	}

	public boolean isStrictlyBinary() {
		try {
			isStrictlyBinaryRecursive(root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void isStrictlyBinaryRecursive(NoBinario iterationNo) throws Exception {
		if (iterationNo != null) {
			if ((iterationNo.getEsquerda() != null && iterationNo.getDireita() != null)
					|| (iterationNo.getEsquerda() == null && iterationNo.getDireita() == null)) {
				isStrictlyBinaryRecursive(iterationNo.getEsquerda());
				isStrictlyBinaryRecursive(iterationNo.getDireita());
			} else {
				throw new Exception("Árvore não é estritamente binária!");
			}
		}
	}

	public int getHeight() {
		return getHeightRecursive(root);
	}

	private int getHeightRecursive(NoBinario iterationNo) {
		if (iterationNo == null) {
			return 0;
		}

		int heightLeft = getHeightRecursive(iterationNo.getEsquerda());
		int heightRight = getHeightRecursive(iterationNo.getDireita());

		if (heightLeft >= heightRight) {
			return 1 + heightLeft;
		}

		return 1 + heightRight;
	}

	public int getLevel(NoBinario iterationNo) {
		if (iterationNo == root) {
			return 1;
		}

		return 1 + getLevel(iterationNo.getPai());
	}

	public boolean isFull() {
		try {
			int height = getHeightRecursive(root);
			isFullRecursive(height, root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void isFullRecursive(int height, NoBinario iterationNo) throws Exception {
		if (iterationNo != null) {
			if ((iterationNo.getEsquerda() != null && iterationNo.getDireita() != null)) {
				isFullRecursive(height, iterationNo.getEsquerda());
				isFullRecursive(height, iterationNo.getDireita());
			} else if (!(iterationNo.getEsquerda() == null && iterationNo.getDireita() == null
					&& getLevel(iterationNo) == height)) {
				throw new Exception("Árvore não é completa!");
			}
		}
	}

	public boolean isAmostFull() {
		try {
			int height = getHeightRecursive(root);
			return isAmostFullRecursive(height, root) >= 1;
		} catch (Exception e) {
			return false;
		}
	}

	private int isAmostFullRecursive(int height, NoBinario iterationNo) throws Exception {
		if (iterationNo != null) {
			if ((iterationNo.getEsquerda() != null && iterationNo.getDireita() != null)) {
				return isAmostFullRecursive(height, iterationNo.getEsquerda())
						+ isAmostFullRecursive(height, iterationNo.getDireita());
			} else if (iterationNo.getEsquerda() == null || iterationNo.getDireita() == null) {
				if (getLevel(iterationNo) < (height - 1)) {
					throw new Exception("Árvore não é quase completa!");
				} else if (getLevel(iterationNo) == (height - 1)) {
					if (iterationNo.getDireita() == null) {						
						return 1;
					}
				}
			}
		}

		return 0;
	}
}
