public class Main{
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.insertCall(4);
		tree.insertCall(3);
		tree.insertCall(3);
		tree.insertCall(1);

		if(tree.searchCall(5) == null){
			System.out.println("não achei nada");
		}else{
			System.out.println("achei");
		}
	}
}