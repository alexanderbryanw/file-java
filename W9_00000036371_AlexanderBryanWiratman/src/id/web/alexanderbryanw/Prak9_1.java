package id.web.alexanderbryanw;

import java.io.File;
import java.util.Scanner;

public class Prak9_1 {

	public static void observasiFile(String alamatFile) {
		File fileDicari = new File(alamatFile);
		if (fileDicari.exists()) {
			System.out.printf("%s %s\n", alamatFile, "ada");

			boolean apakahFile = fileDicari.isFile();
			if (apakahFile = true) {
				System.out.printf("%s %s\n", alamatFile, "adalah file");
			} else {
				System.out.printf("%s %s\n", alamatFile, "bukan file");
			}

			boolean apakahDirektori = fileDicari.isDirectory();
			if (apakahDirektori == true) {
				System.out.printf("%s %s\n", alamatFile, "adalah direktori");
				String[] arrDir = fileDicari.list();
				System.out.println("Isi: ");
				for (int index = 0; index < arrDir.length; index++) {
					System.out.println("\t" + arrDir[index]);
				}
			} else {
				System.out.printf("%s %s\n", alamatFile, "bukan direktori");
			}
		} else {
			System.out.printf("%s %s", alamatFile, "tidak ada");
		}
	}

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		System.out.print("Masukkan alamat atau direktori: ");
		String alamat = myScan.nextLine();
		observasiFile(alamat);

	}

}
