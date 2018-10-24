import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Tree abb = new Tree();
		try {
			FileReader file = new FileReader("ArquivodeComandos");
			BufferedReader readFile = new BufferedReader(file);
			
			String line = readFile.readLine();
			while(line != null) {
				if(line.contains("INSIRA")) {
					abb.insert(Integer.parseInt(line.substring(7)));
				}
				else if(line.contains("REMOVA")) {
					abb.remove(Integer.parseInt(line.substring(7)));
				}
				else if(line.contains("ENESIMO")) {
					int enesimo = abb.enesimoElemento(Integer.parseInt(line.substring(9)));
					System.out.println("O " + Integer.parseInt(line.substring(9)) + "o elemento eh: " + enesimo);
				}
				else if(line.contains("POSICAO")) {
					int posicao = abb.posicao( Integer.parseInt(line.substring(9)) );
					System.out.println("A Posicao do elemento " + Integer.parseInt(line.substring(9)) + " eh: " + posicao);
				}
				else if(line.contains("MEDIANA")) {
					int mediana = abb.mediana();
					System.out.println("A mediana da arvore eh: " + mediana);
				}
				else if(line.contains("CHEIA")) {
					if(abb.ehCheia()) {
						System.out.println("A arvore eh cheia!");
					} else {
						System.out.println("A arvore nao eh cheia!");
					}
				}
				else if(line.contains("COMPLETA")) {
					if(abb.ehCompleta()) {
						System.out.println("A arvore eh completa!");
					} else {
						System.out.println("A arvore nao eh completa!");
					}
				}
				else if(line.contains("IMPRIMA")) {
					System.out.println(abb);
				}
				else {
					System.out.println("Comando nao reconhecido!");
				}
				line = readFile.readLine();
			}
			
			file.close();
		} catch(IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
			e.getMessage());
		}
	}
}