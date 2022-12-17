//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VehicleLogger {
	PrintWriter pw;
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	static int counter;
	int counter1;

	public VehicleLogger(int num) throws IOException {
		fw = new FileWriter("C:\\Users\\dimap\\eclipse-workspace\\Ass2_1\\log.txt");
		pw = new PrintWriter(fw);
		fr = new FileReader("C:\\Users\\dimap\\eclipse-workspace\\Ass2_1\\log.txt");
		br = new BufferedReader(fr);
		counter = num;
		counter1 = 0;
	}

	public synchronized void write(String str) {

		pw.print(str);

		if (str.toString().equals("!!!end of program!!!!")) {
			pw.close();
		}

	}

	public synchronized void read() throws IOException {

		String s1 = br.readLine();
		while (s1 != null) {
			System.out.println(s1);
			s1 = br.readLine();

		}

		br.close();
		fr.close();
	}

}
