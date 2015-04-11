package problem18;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem18 {
	
	static final String dataFile = "./src/problem18/data1";
	
	public static void importData() throws IOException {
		File file = new File(dataFile);
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			System.out.print(sc.next() + " ");
		}
		sc.close();
	}	
	
	public static void main(String[] args) throws IOException {
		importData();
	}
	
}
