public class Main{
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.insert(4);
		tree.insert(3);
		tree.insert(3);
		tree.insert(1);


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