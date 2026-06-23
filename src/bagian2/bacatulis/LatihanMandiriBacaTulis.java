package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LatihanMandiriBacaTulis {
    public static void main(String[] args) {
        
        // 1. Menulis data awal ke hari.txt
        // Objek FileWriter dideklarasikan di dalam tanda kurung try (...) agar otomatis ditutup
        try (FileWriter tulis = new FileWriter("hari.txt")) {
            tulis.write("Senin\n");
            tulis.write("Selasa\n");
            tulis.write("Rabu\n");
            tulis.write("Kamis\n");
            tulis.write("Jumat\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis awal: " + e.getMessage());
        }

        System.out.println("Isi hari.txt:");

        // 2. Membaca data awal dari hari.txt
        try (BufferedReader baca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = baca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca awal: " + e.getMessage());
        }

        // 3. Menambahkan data (append) ke hari.txt
        try (FileWriter tambah = new FileWriter("hari.txt", true)) {
            tambah.write("Sabtu\n");
            tambah.write("Minggu\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menambah data: " + e.getMessage());
        }

        System.out.println("\nIsi hari.txt setelah ditambah:");

        // 4. Membaca data setelah ditambah dari hari.txt
        try (BufferedReader baca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = baca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca setelah ditambah: " + e.getMessage());
        }

        int jumlahBaris = 0;

        // 5. Menghitung jumlah baris dalam hari.txt
        try (BufferedReader baca = new BufferedReader(new FileReader("hari.txt"))) {
            while (baca.readLine() != null) {
                jumlahBaris++;
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menghitung baris: " + e.getMessage());
        }

        System.out.println("\nJumlah baris dalam hari.txt: " + jumlahBaris);
    }
}