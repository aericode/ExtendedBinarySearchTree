public class Tree
{
	private Node root;

	public Tree(){  
        root = null;  
    } 

	public void insert(int key){
		Node where = search(root, key);

		if(where == null){
			where = new Node(key);
		}else{
			System.out.print("we already got this");
			return;
		}

	}

	public Node search(Node current, int key) 
	{ 
	    //achou ou deu fail
	    if (current==null || current.key==key){ //onde ele está ou deveria estar
	    	return current;
	    } 
	    
	    if (current.key > key){
	        return search(current.left, key); 
	    }else{
	    	return search(current.right, key);
	    }
	  	     
	} 



}