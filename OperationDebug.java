public class OperationDebug {
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(4);

		tree.insert(2);
		tree.insert(6);

		tree.insert(1);
		tree.insert(3);

		tree.insert(5);
		tree.insert(7);

		tree.remove(2);


		if(tree.ehCompleta()){
			System.out.println( "eh completa" );
		}else{
			System.out.println( "nao eh completa" );
		}

		//tree.search(4);

		//tree.remove(4);

		//tree.search(4);

	}
}