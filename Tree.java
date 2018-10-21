public class Tree {
	
	private Node root;
	private int elementCount;

	public Tree() {  
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
		//retorna current em todas as itera?es, a menos que ache um local onde key est?		//se encontrar, retorna current tamb? se encontrou o valor que deveria ser inserido
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

	public void remove(int key){
		root = nodeReplacement(root, key);
	}

	//deleta recursivamente
	private Node nodeReplacement(Node current, int value){
		//nó nulo, deletar o pai
		if(current == null){
			return null;
		}
		
		//verifica por chave se o nó procurado está à direita ou à esquerda
		if(value < current.key){
			//Chamada recursiva para o filho que pode levar à chave
			//substitui um dos filhos pelo que retornar
            current.left = nodeReplacement(current.left, value); 
		}else if (value > current.key){
            current.right = nodeReplacement(current.right, value);
		}else{

			//chave igual à do nó atual deletar.
			//um filho. substituir por ele
            if (current.left == null){
                return current.right;
            }else if (current.right == null){
                return current.left; 
            }

            //2 filhos, escolhe o sucessor 
            current.key = smallestValue(current.right); 
  
            // Deleta o sucessor
            current.right = nodeReplacement(current.right, current.key);
        } 
  
        return current; 
    }


	private int smallestValue(Node node){
		while(node.left != null){
			node = node.left;
		}
		return node.key;
	}



}