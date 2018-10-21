public class OperationDebug {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int i=0;

		tree.insert(3);
		tree.insert(2);
		tree.insert(4);


		if(tree.search(4)){
			System.out.println("achei");
		}else{
			System.out.println("não achei");
		}

		tree.remove(4);


		if(tree.search(4)){
			System.out.println("achei");
		}else{
			System.out.println("não achei");
		}
	}
}