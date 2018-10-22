public class Tree {
	
	private Node root;
	private int elementCount;

	private int completeNodeCount;

	public Tree() {  
        root = null;
        elementCount = 0;
        completeNodeCount = 0;
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
			completeNodeCount++; //todo nó a princípio é completo
		    return new Node(key);
		}

		int     auxCount    = elementCount;//armazena o numero de elementos na arvore antes da chamada recursiva
		boolean auxComplete = current.isComplete();

		//se o numero de elementos mudar, sobe o contador do lado percorrido (porque de fato houve insercao)
		if (key < current.key){
		    current.left = insertCall(current.left, key);
		    if(auxCount!=elementCount){
		    	current.leftCount++;//aumenta a (contagem de elementos à esquerda) do current
		    }
		} else if (key > current.key){
		    current.right = insertCall(current.right, key);
		    if(auxCount!=elementCount){
		    	current.rightCount++;
		    }
		}

		//alterações de estado são contabilizadas pela tree
		if(auxComplete && !current.isComplete()){
			//era completo e não é mais
			completeNodeCount--;
		} else if(!auxComplete && current.isComplete()){
			//não era completo e agora é
			completeNodeCount++;
		}

		//retorna current em todas as iteracoes, a menos que ache um local onde key esta
		//se encontrar, retorna current tambem se encontrou o valor que deveria ser inserido
		return current;
	}


	public boolean ehCompleta(){
    	return completeNodeCount == elementCount;
	}


	public boolean search(int key){
		return searchCall(root, key);
	}	


	private boolean searchCall(Node current, int key){
		if(current == null){
			System.out.println("nao esta nessa arvore");
			return false;
		}else if (current.key == key){
			System.out.println("esta nessa arvore");
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
            current.key   = smallestValue(current.right); 
  
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



	public int enesimoElemento(int n){
		return enesimoElementoCall(root, root.leftCount + 1, n);
	}

	//a ordem simetrica percorre todos os da esquerda, o próprio nó é o (+1)
	private int enesimoElementoCall(Node current,int selfIndex, int target){

		if(target > elementCount || target < 0){
			return -1;
		}


		if(selfIndex == target){
			return current.key;
		}


		if(selfIndex < target){
			//Indice acima do alvo
			//Ir para a direita, adicionando ao indice os que vem depois do pai, mas antes do filho
			return enesimoElementoCall(current.right,  selfIndex + current.right.leftCount + 1, target);
		}


		if(selfIndex > target){
			//Indice abaixo do alvo
			//Ir para a esquerda, reduzindo do indice os que vem antes do pai, mas depois do filho do filho
			// (current.left).rightCount significa "quantidade de elementos à direita do filho da esquerda"
			return enesimoElementoCall(current.left,  selfIndex - current.left.rightCount - 1, target);
		}

		//o +1/-1 são necessários adicionam/removem o próprio pai na conta
		return -1;
	}


	//retorna o valor intermediário em percorrimento simétrico
	public int mediana(){
		if(elementCount%2 == 0){
			//requer mediana menor para o par
			return enesimoElementoCall(root, root.leftCount + 1, elementCount/2);
		}else{
			//requer elemento central para o ímpar
			return enesimoElementoCall(root, root.leftCount + 1, (elementCount/2) + 1 );
		}
	}


	public int posicao(int key){
		//leftCount + 1 resulta no índice do nó que chama a função
		return posicaoCall(root, root.leftCount + 1, key);
	}


	private int posicaoCall(Node current, int selfIndex, int key){
		if(current == null){
			return -1;
		}else if (current.key == key){
		    return selfIndex;
		}


		if (current.key < key){

			return posicaoCall(current.right, selfIndex + current.right.leftCount + 1, key);		   
		} else if (current.key > key){

			return posicaoCall(current.left,  selfIndex - current.left.rightCount - 1, key);
		}

		return -1;
	}

}