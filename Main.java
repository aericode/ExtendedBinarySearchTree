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
					abb.
				}
				else if(line.contains("POSICAO")) {
					abb.
				}
				else if(line.contains("MEDIANA")) {
					abb.
				}
				else if(line.contains("CHEIA")) {
					abb.
				}
				else if(line.contains("COMPLETA")) {
					abb.
				}
				else if(line.contains("IMPRIMA")) {
					abb.
				}
				else {
					System.out.println("Comando não reconhecido!");
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