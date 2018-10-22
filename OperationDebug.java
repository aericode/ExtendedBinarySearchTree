public class OperationDebug {
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(2);
		tree.insert(3);

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