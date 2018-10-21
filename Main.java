import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) {
		/*Tree tree = new Tree();
		tree.insert(4);
		tree.insert(3);
		tree.insert(3);
		tree.insert(1);


		if(tree.search(4)){
			System.out.println("achei");
		}else{
			System.out.println("não achei");
		}

		tree.remove(4);


		if(tree.search(4)){
			System.out.println("achei");
		}else{
			System.out.println("não achei");
		}

		 */
		try {
			FileReader file = new FileReader("ArquivodeComandos");
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