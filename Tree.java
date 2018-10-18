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
	public void insertCall(int key){
		int auxCount = elementCount;
    	root = insert(root, key);
    	if(auxCount!=elementCount){
    		System.out.println("Elemento inserido com sucesso");
    	}else{
    		System.out.println("Elemento já presente na árvore");
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

	public Node searchCall(int key){
		return search(root, key);
	}	

	private Node search(Node current, int key){
		if (current.key == key){
		    return current;
		}else if(current == null){
			return null;
		}

		if (key < current.key){
		   return search(current.left, key);
		} else if (key > current.key){
		   return search(current.right, key);
		}

		return current;
	}



}