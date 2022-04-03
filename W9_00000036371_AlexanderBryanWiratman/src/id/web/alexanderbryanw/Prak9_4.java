package id.web.alexanderbryanw;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class Prak9_4 {
	private Formatter output;
	// objek untuk menulis teks ke file

	public void bukaFileOutput() {// membuat file keluaran.txt
		try {
			output = new Formatter("keluaran.txt");
		} catch (SecurityException excpt1) {
			System.err.println("Anda tidak boleh" + "menulis ke file ini");
			System.exit(1);
		} catch (FileNotFoundException excpt2) {
			System.err.println("File tidak ditemukan");
			System.exit(1);
		}
	}

	public void menambahDataOutput() {// input data ke keluaran.txt
		try {
			File file = new File("dataku.txt");
			Scanner scan = new Scanner(file);
			Peserta[] peserta = new Peserta[1];
			for (int i = 0; i < peserta.length; i++) {
				peserta[i] = new Peserta();
			}
			int speedbaru = 0;
			for (int i = 0; i < peserta.length; i++) {
				peserta[i].nama = scan.next();
				peserta[i].speed = scan.nextInt();
				speedbaru = peserta[i].speed - 1;
			}
			scan.close();
			
			// menulis data ke file
			output.format("10 Pelari Tercepat di Serpong\n===============================================\n");
			for (int i = 0; i < 1; i++) {
				output.format("%d" + "." + " %s" + ":" + "%d" + " m/s ", i + 1, peserta[i].nama, speedbaru);
			}
		} catch (Exception ex) {
			System.err.println("Ada error nih");
			System.exit(1);
		}
	}// end menambah data

	public void menampilkanFileOutput() {// menampilkan isi keluaran.txt ke console
		try {
			File file = new File("keluaran.txt");
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			scan.close();
		} catch (Exception ex) {
			System.err.println("Error nih");
		}
	}

	public void menutupFileOutput() {// menutup file
		if (output != null) {
			output.close();
		}
	}

	public static void main(String[] args) {
		Prak9_4 myKeluaran = new Prak9_4();

		myKeluaran.bukaFileOutput();
		myKeluaran.menambahDataOutput();
		myKeluaran.menutupFileOutput();
		myKeluaran.menampilkanFileOutput();

	}

}
