package tugas;

public class Kontak {
    private String nama;
    private String telepon;
    private String email; // Tambahan Atribut Email (Soal 2)

    // Constructor yang disesuaikan (Soal 2)
    public Kontak(String nama, String telepon, String email) {
        this.nama = nama;
        this.telepon = telepon;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return telepon;
    }

    // Getter untuk Email (Soal 2)
    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi baris teks untuk disimpan ke file (Soal 2)
    public String keBaris() {
        return nama + "," + telepon + "," + email;
    }

    // Menampilkan informasi lengkap kontak (Soal 2)
    public void info() {
        System.out.println("Nama    : " + nama);
        System.out.println("Telepon : " + telepon);
        System.out.println("Email   : " + email);
    }
}
