package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftarKontak = new ArrayList<>();
    private final String namaBerkas = "kontak.txt";

    public void tambahKontak(Kontak k) {
        daftarKontak.add(k);
    }

    public void tampilkanSemua() {
        if (daftarKontak.isEmpty()) {
            System.out.println("Buku kontak kosong.");
            return;
        }
        for (Kontak k : daftarKontak) {
            k.info();
            System.out.println("--------------------");
        }
    }

    // 1. Method Cari Kontak (Soal 1)
    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftarKontak) {
            // Menggunakan equalsIgnoreCase agar pencarian tidak sensitif huruf besar/kecil
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("\n[Kontak Ditemukan]");
                k.info();
                ditemukan = true;
                break; 
            }
        }
        if (!ditemukan) {
            System.out.println("\nKontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // 3. Method Hapus Kontak & Otomatis Simpan (Soal 3)
    public void hapusKontak(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarKontak.size(); i++) {
            if (daftarKontak.get(i).getNama().equalsIgnoreCase(nama)) {
                daftarKontak.remove(i);
                System.out.println("\nKontak '" + nama + "' berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }
        
        if (ditemukan) {
            simpanKeBerkas(); // Perubahan langsung disimpan ke berkas
        } else {
            System.out.println("\nGagal menghapus. Kontak '" + nama + "' tidak ditemukan.");
        }
    }

    // Menyimpan seluruh list ke file teks
    public void simpanKeBerkas() {
        try (FileWriter tulis = new FileWriter(namaBerkas)) {
            for (Kontak k : daftarKontak) {
                tulis.write(k.keBaris() + "\n");
            }
            System.out.println("Data berhasil disinkronisasi ke berkas.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // 2. Memuat data dari berkas dengan pecahan 3 kolom (Soal 2)
    public void muatDariBerkas() {
        daftarKontak.clear(); // Bersihkan list sebelum memuat ulang
        try (BufferedReader baca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = baca.readLine()) != null) {
                // Memecah baris menjadi 3 bagian berdasarkan tanda koma
                String[] bagian = baris.split(",");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    String telepon = bagian[1];
                    String email = bagian[2];
                    daftarKontak.add(new Kontak(nama, telepon, email));
                }
            }
        } catch (IOException e) {
            System.out.println("Berkas tidak ditemukan atau belum dibuat. Memulai dengan data baru.");
        }
    }
}
