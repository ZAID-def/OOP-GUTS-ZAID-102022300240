package MODUL1_ZAID; 

public class Penumpang {
    private String NIK;
    private String namaDepan;
    private String namaBelakang;
    private Penerbangan penerbangan;

    // Constructor
    public Penumpang(String NIK, String namaDepan, String namaBelakang, Penerbangan penerbangan) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.penerbangan = penerbangan;
    }

    // Method untuk menampilkan detail tiket penumpang
    public void tampilkanTiket() {
        System.out.println("======= Detail Tiket Penerbangan =======");
        System.out.println("Nomor Induk Kependudukan: " + NIK);
        System.out.println("Nama Depan: " + namaDepan);
        System.out.println("Nama Belakang: " + namaBelakang);
        penerbangan.tampilkanDetailPenerbangan();
    }
}
