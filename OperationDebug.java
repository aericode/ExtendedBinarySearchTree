public class OperationDebug {
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(2);
		tree.insert(6);
		tree.insert(7);
		tree.insert(15);
		tree.insert(1);
		tree.insert(3);
		tree.insert(20);


		System.out.println( tree.posicao(20));

		//tree.search(4);

		//tree.remove(4);

		//tree.search(4);

	}
}