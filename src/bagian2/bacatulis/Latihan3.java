package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Latihan3 {
    public static void main(String[] args) {
        // try-with-resources: stream otomatis ditutup setelah blok selesai
        try (PrintWriter penulis = new PrintWriter(new FileWriter("mahasiswa.txt"))) {
            penulis.println("Andi");
            penulis.println("Budi");
            penulis.println("Citra");
            System.out.println("Data berhasil ditulis ke mahasiswa.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }
    }
}
