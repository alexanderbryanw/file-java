package id.web.alexanderbryanw;

import java.io.*;
import java.util.*;

public class Prak9_5 {
	private Formatter output;
	// objek untuk menulis teks ke file

	public void bukaFileOutput() {// membuat file struk.txt
		try {
			output = new Formatter("struk.txt");
		} catch (SecurityException excpt1) {
			System.err.println("Anda tidak boleh" + "menulis ke file ini");
			System.exit(1);
		} catch (FileNotFoundException excpt2) {
			System.err.println("File tidak ditemukan");
			System.exit(1);
		}
	}

	public void menambahDataOutput() {// input data ke struk.txt
		Scanner scan = new Scanner(System.in);
		System.out.println("					KANTINKU");
		System.out.println("============================================================");
		System.out.print("Jumlah makanan: ");
		int length = scan.nextInt();
		int[] makanan = new int[length];
		int[] kodeMakanan = new int[length];
		int[] jumMakanan = new int[length];
		for (int i = 0; i < makanan.length; i++) {
			System.out.println("\nMakanan ke - " + (i + 1));
			System.out.print("Kode: ");
			kodeMakanan[i] = scan.nextInt();
			System.out.print("Jumlah: ");
			jumMakanan[i] = scan.nextInt();
		}
		System.out.println("============================================================");
		System.out.println("\nTerima kasih atas kunjungan anda. Selamat menikmati!");

		try {
			File file = new File("kantinku.txt");
			Scanner scanFile = new Scanner(file);
			String[] data = new String[1000];
			for (int i = 0; i < 6; i++) {
				data[i] = scanFile.nextLine();
			}
			scanFile.close();
			// menulis data ke file
			output.format("				KANTINKU\n");
			output.format("==========================================================================\n");
			output.format("No	|     Makanan	|     Jumlah	|     Harga	|     Subtotal\n");
			output.format("--------------------------------------------------------------------------\n");
			int total = 0;
			for (int i = 0; i < makanan.length; i++) {
				String arrData[] = data[kodeMakanan[i] - 1].split("#");
				int harga[] = { 8000, 8500, 15000, 25000, 20000, 20500 };
				output.format("%d.	   %-20s %-14d %-15s %d\n", (i + 1), arrData[1], jumMakanan[i],
						harga[kodeMakanan[i] - 1], harga[kodeMakanan[i] - 1] * jumMakanan[i]);
				total = total + (harga[kodeMakanan[i] - 1] * jumMakanan[i]);
			}
			output.format("--------------------------------------------------------------------------\n");
			output.format("Total                                                          %d\n", total);
			output.format("Kasir : Alexander Bryan               |                 NIM : 00000036371 ");
		} catch (Exception ex) {
			System.err.println("Ada error nih");
			System.exit(1);
		}
	}// end menambah data

	public void menutupFileOutput() {// menutup file
		if (output != null) {
			output.close();
		}
	}

	public static void main(String[] args) {

		Prak9_5 myKantin = new Prak9_5();

		myKantin.bukaFileOutput();
		myKantin.menambahDataOutput();
		myKantin.menutupFileOutput();
	}

}
