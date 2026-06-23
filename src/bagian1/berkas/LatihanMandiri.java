package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {
        try {
            File laporan = new File("laporan.txt");

            if (laporan.createNewFile()) {
                System.out.println("Berkas dibuat : " + laporan.getName());
            } else {
                System.out.println("Berkas sudah ada : " + laporan.getName());
            }

            System.out.println("Apakah berkas ada? " + laporan.exists());
            System.out.println("Ukuran berkas : " + laporan.length() + " byte");

            File arsip = new File("arsip");

            if (arsip.mkdir()) {
                System.out.println("Folder arsip berhasil dibuat.");
            } else {
                System.out.println("Folder arsip gagal dibuat atau sudah ada.");
            }

            File sementara = new File("sementara.txt");

            if (sementara.createNewFile()) {
                System.out.println("Berkas sementara.txt berhasil dibuat.");
            } else {
                System.out.println("Berkas sementara.txt sudah ada.");
            }

            System.out.println("Status sebelum dihapus : " + sementara.exists());

            if (sementara.delete()) {
                System.out.println("Berkas berhasil dihapus.");
            } else {
                System.out.println("Berkas gagal dihapus.");
            }

            System.out.println("Status sesudah dihapus : " + sementara.exists());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan : " + e.getMessage());
        }
    }
}
