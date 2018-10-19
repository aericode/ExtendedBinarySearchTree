public class Tree
{
	private Node root;

	private int elementCount;

	public Tree(){  
        root = null;
        elementCount = 0;
    }


	//Insertion call
	//Baseado em https://www.baeldung.com/java-binary-tree
	public boolean insertCall(int key){
		int auxCount = elementCount;
    	root = insert(root, key);
    	if(auxCount!=elementCount){
    		return true;
    	}else{
    		return false;
    	}
	}

	private Node insert(Node current, int key){
		if (current == null){
			elementCount++; //aumenta em um o numero de elementos
		    return new Node(key);
		}

		if (key < current.key){
		    current.left = insert(current.left, key);
		} else if (key > current.key){
		    current.right = insert(current.right, key);
		}
		//retorna current em todas as iterações, a menos que ache um local onde key está
		//se encontrar, retorna current também se encontrou o valor que deveria ser inserido
		return current;
	}

	public boolean searchCall(int key){
		return search(root, key);
	}	

	private boolean search(Node current, int key){
		if(current == null){
			return false;
		}else if (current.key == key){
		    return true;
		}

		if (key < current.key){
		   return search(current.left, key);
		} else if (key > current.key){
		   return search(current.right, key);
		}

		return false;
	}



}