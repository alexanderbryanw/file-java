package id.web.alexanderbryanw;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Prak9_2A {
	private Formatter output;
	// objek untuk menulis teks ke file

	public void bukaFile() {
		try {
			output = new Formatter("cobadata.txt");
		} catch (SecurityException excpt1) {
			System.err.println("Anda tidak boleh" + "menulis ke file ini");
			System.exit(1);
		} catch (FileNotFoundException excpt2) {
			System.err.println("File tidak ditemukan");
			System.exit(1);
		}
	}

	public void menambahData() {
		Scanner myScan = new Scanner(System.in);
		System.out.print("Masukkan no, nama, dan sisa dana: ");
		while (myScan.hasNext()) {
			try {
				int no = myScan.nextInt();
				String nama = myScan.next();
				double sisaDana = myScan.nextDouble();
				// membuat baris pemisah
				String separator = System.getProperty("line.separator");
				// menulis data ke file
				output.format("%d %s %.2f%s", no, nama, sisaDana, separator);
			} catch (FormatterClosedException e) {
				System.err.println("Error ketika menulis: " + "ke file");
				return;
			} catch (NoSuchElementException e) {
				System.err.println("Terjadi kesalahan input");
				myScan.nextLine();
			}
			System.out.print("Masukkan no, nama, dan " + "sisa dana: ");
		} // end while
	}// end menambah data

	public void menutupFile() {
		if (output != null) {
			output.close();
		}

	}

}
