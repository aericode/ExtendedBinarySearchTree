import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		/*Tree tree = new Tree();
		tree.insertCall(4);
		tree.insertCall(3);
		tree.insertCall(3);
		tree.insertCall(1);

		if(tree.searchCall(5)) {
			System.out.println("Found!");
		}else {
			System.out.println("Not Found!");
		}
		 */
		try {
			FileReader file = new FileReader("ArquivodeComandos. 	");
			BufferedReader readFile = new BufferedReader(file);
			
			String line = readFile.readLine();
			while(line != null) {
				System.out.println(line);
				line = readFile.readLine();
			}
			
			file.close();
		} catch(IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
			e.getMessage());
		}
	}
}