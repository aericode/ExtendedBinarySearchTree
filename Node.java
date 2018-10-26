public class Node {

	public int key;
	public Node left;
	public Node right;

	public int leftCount;
	public int rightCount;

	public Node(int key) {
		this.key = key;
		left     = null;
		right    = null;

		leftCount  = 0;
		rightCount = 0;
	}

	//unused
	public Node(Node node) { 
		key   = node.key;
        left  = node.left;
        right = node.right;
    } 
	
	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public boolean isLeftNull() {
		return left.equals(null);
	}

	public boolean isRightNull() {
		return right.equals(null);
	}

	public void setLeft(Node addMe) {
		left  = addMe;
	}

	public void setRight(Node addMe) {
		right = addMe;
	}

	public int getKey() {
		return key;
	}

	//nós completos, em uma árvore completa não há nós incompletos
	public boolean isComplete(){
		if(left == null && right == null){
			return true;
		}

		if(left != null && right != null){
			return true;
		}

		return false;
	}


	//em uma árvore cheia todos os nós preservam 
	public boolean isFull(){
		return leftCount == rightCount;
	}
	
	
	@Override
	public String toString() {
		return "" + getKey();
	}
}
