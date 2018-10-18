public class Node
{
	public int key;

	public Node left;
	public Node right;

	public Node(int key){
		this.key = key;
		left     = null;
		right    = null;
	}

	public Node(Node node) { 
		key   = node.key;
        left  = node.left;
        right = node.right;
    } 

	public boolean isLeftNull(){
		return left.equals(null);
	}

	public boolean isRightNull(){
		return right.equals(null);
	}

	public void setLeft(Node addMe){
		left  = addMe;
	}

	public void setRight(Node addMe){
		right = addMe;
	}

	public int getKey(){
		return key;
	}
}
