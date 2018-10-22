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
				else if(line.contains("ENENSIMO")) {
					int enesimo = abb.enesimoElemento(Integer.parseInt(line.substring(9)));
					System.out.println("O " + Integer.parseInt(line.substring(9)) + "� elemento �: " + enesimo);
				}
				else if(line.contains("POSICAO")) {
					int posicao = abb.posicao();
					System.out.println("A Posi��o do elemento " + Integer.parseInt(line.substring(9)) + " �: " + posicao);
				}
				else if(line.contains("MEDIANA")) {
					int mediana = abb.mediana();
					System.out.println("A mediana da �rvore �: " + mediana);
				}
				else if(line.contains("CHEIA")) {
					if(abb.ehCheia()) {
						System.out.println("A �rvore � cheia!");
					} else {
						System.out.println("A �rvore n�o � cheia!");
					}
				}
				else if(line.contains("COMPLETA")) {
					if(abb.ehCompleta()) {
						System.out.println("A �rvore � completa!");
					} else {
						System.out.println("A �rvore n�o � completa!");
					}
				}
				else if(line.contains("IMPRIMA")) {
					System.out.println(abb.toString());
				}
				else {
					System.out.println("Comando n�o reconhecido!");
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