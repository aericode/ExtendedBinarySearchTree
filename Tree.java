import java.lang.Math;
import java.util.ArrayDeque;
import java.util.Deque;

public class Tree {
	
	private Node root;
	private int elementCount;

	private int completeNodeCount;
	private int fullNodeCount;


	public Tree() {  
        root = null;
        elementCount = 0;
        completeNodeCount = 0;
        fullNodeCount = 0;
    }

    //uma arvore nao cheia nao tem essa propriedade
    public boolean fullCount(){
    	//log2 propriedade logaritmica
    	double tester = Math.log(elementCount + 1) / Math.log(2);

    	//retornar true se for inteiro
    	return tester == (int)tester;
    }


    //checa se um no é completo e refaz a contagem
	public void debug(){
		System.out.println( "Node Count    : " + elementCount );
		System.out.println( "Complete Nodes: " + completeNodeCount );
		System.out.println( "Full Nodes    : " + fullNodeCount );


		if(ehCompleta()){
			System.out.println( "eh completa" );
		}else{
			System.out.println( "nao eh completa" );
		}

		if(ehCheia()){
			System.out.println( "eh cheia" );
		}else{
			System.out.println( "nao eh cheia" );
		}
	}


    //checa se um no é completo e refaz a contagem
	private void reviewComplete(Node current, boolean auxComplete){
		//alterações de estado são contabilizadas pela tree
		if(auxComplete && !current.isComplete()){
			//era completo e não é mais
			completeNodeCount--;
		} else if(!auxComplete && current.isComplete()){
			//não era completo e agora é
			completeNodeCount++;
		}
	}


	//checa se um no é cheio e refaz a contagem
	private void reviewFull(Node current, boolean auxFull){
		//alterações de estado são contabilizadas pela tree
		if(auxFull && !current.isFull()){
			//era cheio e não é mais
			fullNodeCount--;
		} else if(!auxFull && current.isFull()){
			//não era cheio e agora é
			fullNodeCount++;
		}
	}



	public boolean insert(int key){
		int auxCount = elementCount;
    	root = insertCall(root, key);

    	//retorna se foi possivel inserir ou não
    	return (auxCount!=elementCount);
	}



	private Node insertCall(Node current, int key){

		if (current == null){
			elementCount++; //aumenta em um o numero de elementos
			completeNodeCount++; //todo nó a princípio é completo
			fullNodeCount++; //todo nó a princípio é cheio
		    return new Node(key);
		}

		int     auxCount    = elementCount;//armazena o numero de elementos na arvore antes da chamada recursiva
		boolean auxComplete = current.isComplete();//grava se o elemento era completo no inicio da operação
		boolean auxFull     = current.isFull(); //grava se o elemento era cheio no inicio da operação

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

		//Revisa ao fim da operação se o nó ainda é cheio ou completo
		reviewComplete(current, auxComplete);
		reviewFull(current, auxFull);

		//retorna current em todas as iteracoes, a menos que ache um local onde key esta
		//se encontrar, retorna current tambem se encontrou o valor que deveria ser inserido
		return current;
	}


	public boolean ehCompleta(){
    	return completeNodeCount == elementCount;
	}

	public boolean ehCheia(){
    	return fullNodeCount == elementCount;
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
		//nó nulo, apenas para a raiz vazia
		if(current == null){
			return null;
		}
		
		int auxCount        = elementCount;//armazena o numero de elementos na arvore antes da chamada recursiva
		boolean auxComplete = current.isComplete(); //grava se o elemento era completo no inicio da operação
		boolean auxFull     = current.isFull(); //grava se o elemento era cheio no inicio da operação

		//verifica por chave se o nó procurado está à direita ou à esquerda
		if(value < current.key){
			//Chamada recursiva para o filho que pode levar à chave
			//substitui um dos filhos pelo que retornar
            current.left = nodeReplacement(current.left, value);

			
            //só ocorre caso tenha ocorrido alteração
            if(auxCount!=elementCount){
            	current.leftCount--;//reduz em um o numero de nós da esquerda
            	reviewComplete(current, auxComplete);//ver se ainda é completo
            	reviewFull(current, auxFull);//ver se ainda é cheio
            }
		}else if (value > current.key){

            current.right = nodeReplacement(current.right, value);

            //só ocorre caso tenha ocorrido alteração
            if(auxCount!=elementCount){
            	current.rightCount--;//reduz em um o numero de nós da direita
            	reviewComplete(current, auxComplete);//ver se ainda é completo
            	reviewFull(current, auxFull);//ver se ainda é cheio
            }
		}else{

			//chave igual à do nó atual deletar.
			//um filho. substituir por ele

			//alguém certamente será deletado
					

			//"salto de trajeto", o num de filhos abaixo deles não se altera
			//ou seja, sem alterações em left e right counts
			//se ambos os filhos forem null, retorna null
            if (current.left == null){
            	elementCount--;

            	//se ambos são nulls o elemento deletado é uma folha
            	if (current.right == null){
            		completeNodeCount--;//toda folha é completa
            		fullNodeCount--;    //toda folha é cheia
            	}

            	//entrega o right para o pai sobrescrever em seu lugar
                return current.right;
            }else if (current.right == null){
            	elementCount--;
            	//entrega o left para o pai sobrescrever em seu lugar
                return current.left;
            }

            //2 filhos, escolhe o sucessor

            //não reduz o element count agora, só na chamada recursiva para deletar o sucessor
            current.key   = smallestValue(current.right);
  
            // Deleta o sucessor
            //pela natureza de smallestValue, vai encontrar um nó com left null e reduzir um o elementCount
            current.right = nodeReplacement(current.right, current.key);

            reviewComplete(current, auxComplete);//ver se ainda é completo
            reviewFull(current, auxFull);//ver se ainda é cheio
        }
        //o comportamento padrão é retornar a si próprio para ser "substituido" pelo pai
        return current; 
    }

    
	private int smallestValue(Node node){
		while(node.left != null){
			node = node.left;
			node.leftCount--;
		}
		return node.key;
	}



	public int enesimoElemento(int n){
		return enesimoElementoCall(root, root.leftCount + 1, n);
	}


	//a ordem simetrica percorre todos os da esquerda, o próprio nó é o (+1)
	private int enesimoElementoCall(Node current,int selfIndex, int target){

		//fora do limite da arvore
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
	
	@Override
	public String toString() {
		if(root == null) return "";
		return readTreeInLevel(root);
	}
	
	private String readTreeInLevel(Node no) {
		String t = "";
		if (no == null) t = "";
		else {
			Deque <Node> fila = new ArrayDeque<>();
			fila.add(no);
			while(!fila.isEmpty()) {
				Node current =  fila.removeFirst();
				t += " " + current.getKey();
				if(current.getLeft() != null) fila.add(current.getLeft());
				if(current.getRight() != null) fila.add(current.getRight());
			}
		}
		return t;
	}
	
	
	//unused
	private String readTreePreOrder(Node no) {
		if(no == null) return "";
		String t = "";
		t += (t.isEmpty() ? " " : " ,") + no.toString();
		t += readTreePreOrder(no.getLeft());
		t += readTreePreOrder(no.getRight());
		return t;
	}
	
	//unused
	private String readTreeInOrder(Node no) {
		if (no == null) { return ""; }
		String t = "";
		if(no.getLeft() != null) {
			t += (t.isEmpty() ? "" : ",") + readTreeInOrder(no.getLeft());
		}
		t += (t.isEmpty() ? "" : ",") + no.toString();
		if (no.getRight() != null) {
			t+= (t.isEmpty() ? "" : ",") + readTreeInOrder(no.getRight());
		}
		return t;
	}

}