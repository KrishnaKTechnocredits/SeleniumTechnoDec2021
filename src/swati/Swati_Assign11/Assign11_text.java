package swati.Swati_Assign11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assign11_text {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file1 = new File(
				"C:\\Users\\sagarparab\\Desktop\\techno git\\SeleniumTechnoDec2021\\src\\swati\\test.txt");

		Scanner scan = new Scanner(file1);
		String line = "";
		ArrayList<String> a = new ArrayList<String>();
		int count = 0;

		while (scan.hasNext()) {
			line = scan.next();
			a.add(line);
		}
		for (String arr : a) {
			if (arr.contains("technocredits")) {
				count++;
			}
		}

		System.out.println(count);
		scan.close();
	}

}
