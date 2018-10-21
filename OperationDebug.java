public class OperationDebug {
	public static void main(String[] args) {
		Tree tree = new Tree();

		for(int i = 0;i<100;i++){
			tree.insert(i);
		}


		tree.search(4);

		tree.remove(4);

		tree.search(4);

	}
}