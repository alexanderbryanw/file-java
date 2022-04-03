package id.web.alexanderbryanw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Prak9_3A {
	private Scanner input;

	public void bukaFile() {
		try {
			input = new Scanner(new File("cobadata.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Error membuka file");
			System.exit(1);// satu artinya ada error
		}
	}

	public void membacaData() {
		try {
			while (input.hasNext()) {
				int no = input.nextInt();
				String nama = input.next();
				double dana = input.nextDouble();

				System.out.printf("%d %s %.2f\n", no, nama, dana);
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("Format file salah");
			input.close();
			System.exit(1);
		} catch (IllegalStateException illegalStateException) {
			System.err.println("Error membaca file");
			System.exit(1);
		}
	}

	public void menutupFile() {
		if (input != null) {
			input.close();
		}
	}

}
