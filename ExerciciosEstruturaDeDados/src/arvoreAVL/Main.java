package arvoreAVL;

public class Main {
    public static void main(String[] args) {
        BinaryNode<Integer> node50 = new BinaryNode<>(50);
        BinaryNode<Integer> node17 = new BinaryNode<>(17);
        BinaryNode<Integer> node76 = new BinaryNode<>(76);
        BinaryNode<Integer> node9 = new BinaryNode<>(9);
        BinaryNode<Integer> node23 = new BinaryNode<>(23);
        BinaryNode<Integer> node54 = new BinaryNode<>(54);
        BinaryNode<Integer> node14 = new BinaryNode<>(14);
        BinaryNode<Integer> node19 = new BinaryNode<>(19);
        BinaryNode<Integer> node72 = new BinaryNode<>(72);
        BinaryNode<Integer> node12 = new BinaryNode<>(12);
        BinaryNode<Integer> node67 = new BinaryNode<>(67);
        BinaryTree<Integer> tree = new BinaryTree<>(node50);
        
        for (int i = 0; i < 20; i++) {
            tree.addNode(new BinaryNode<Integer>(i));
		}

        tree.print();
    }
}
