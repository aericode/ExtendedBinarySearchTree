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
	public boolean insert(int key){
		int auxCount = elementCount;
    	root = insertCall(root, key);
    	if(auxCount!=elementCount){
    		return true;
    	}else{
    		return false;
    	}
	}

	private Node insertCall(Node current, int key){
		if (current == null){
			elementCount++; //aumenta em um o numero de elementos
		    return new Node(key);
		}

		if (key < current.key){
		    current.left = insertCall(current.left, key);
		} else if (key > current.key){
		    current.right = insertCall(current.right, key);
		}
		//retorna current em todas as iterações, a menos que ache um local onde key está
		//se encontrar, retorna current também se encontrou o valor que deveria ser inserido
		return current;
	}

	public boolean search(int key){
		return searchCall(root, key);
	}	

	private boolean searchCall(Node current, int key){
		if(current == null){
			return false;
		}else if (current.key == key){
		    return true;
		}

		if (key < current.key){
		   return searchCall(current.left, key);
		} else if (key > current.key){
		   return searchCall(current.right, key);
		}

		return false;
	}

	public boolean remove(int key){
		int auxCount = elementCount;
    	root = nodeReplacement(root, key);
    	if(auxCount!=elementCount){
    		return true;
    	}else{
    		return false;
    	}
	}


	//deleta recursivamente
	private Node nodeReplacement(Node current, int value){
		//nada abaixo dele, basta deletar
		if(current.left == null && current.right == null){
			return null;
		}
		
		//apenas um abaixo dele, apenas substituir
		if(current.left == null){
			return current.right;
		}

		if(current.right == null){
			return current.left;
		}

		
		//troca pelo sucessor
		current.key = smallestValue(current.right);

		current.right = nodeReplacement(current.right, current.key);

		return current;
	}

	private int smallestValue(Node node){
		while(node.left != null){
			node = node.left;
		}
		return node.key;
	}



}