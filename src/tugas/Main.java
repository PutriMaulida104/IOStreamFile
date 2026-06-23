package tugas;

public class Main {
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak();

        // Memuat data lama jika ada
        buku.muatDariBerkas();

        System.out.println("=== Mengisi Data Kontak Baru ===");
        // Mengisi kontak lengkap dengan email (Soal 2)
        buku.tambahKontak(new Kontak("Budi", "081234", "budi@email.com"));
        buku.tambahKontak(new Kontak("Andi", "085678", "andi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "089999", "citra@email.com"));
        
        // Simpan data awal ke berkas
        buku.simpanKeBerkas();

        System.out.println("\n=== Semua Kontak Saat Ini ===");
        buku.tampilkanSemua();

        // Pengujian Soal 1: Cari Kontak
        System.out.println("\n=== Uji Fitur Cari Kontak ===");
        buku.cariKontak("Andi");  // Skenario: Ada
        buku.cariKontak("Zaki");  // Skenario: Tidak ada

        // Pengujian Soal 3: Hapus Kontak dan Simpan
        System.out.println("\n=== Uji Fitur Hapus Kontak ===");
        buku.hapusKontak("Andi"); // Menghapus Andi dan otomatis simpan berkas

        System.out.println("\n=== Semua Kontak Setelah Penghapusan ===");
        buku.tampilkanSemua();
    }
}
