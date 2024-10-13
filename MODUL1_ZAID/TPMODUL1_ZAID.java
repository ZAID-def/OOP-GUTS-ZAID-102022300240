package MODUL1_ZAID; 

import java.util.ArrayList;
import java.util.Scanner;

public class TPMODUL1_ZAID {
    private ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
    private Penumpang penumpang;
    private Scanner scanner = new Scanner(System.in);

    // Method untuk menambahkan daftar penerbangan
    public void tambahPenerbangan() {
        daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", 
                                              "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", 
                                              "09:00", "11:45", 1350000));
    }

    // Method untuk menampilkan daftar penerbangan
    public void tampilkanDaftarPenerbangan() {
        System.out.println("======= Daftar Penerbangan =======");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            System.out.println((i + 1) + ".");
            daftarPenerbangan.get(i).tampilkanDetailPenerbangan();
        }
    }

    // Method untuk membeli tiket
    public void beliTiket() {
        if (penumpang != null) {
            System.out.println("Anda sudah memiliki pesanan tiket.");
            return;
        }

        System.out.println("Silakan isi data diri Anda terlebih dahulu");
        System.out.print("Masukkan NIK: ");
        String NIK = scanner.nextLine();
        System.out.print("Masukkan Nama Depan: ");
        String namaDepan = scanner.nextLine();
        System.out.print("Masukkan Nama Belakang: ");
        String namaBelakang = scanner.nextLine();

        System.out.println("Terima kasih telah mengisi data penumpang. Silakan pilih penerbangan:");
        tampilkanDaftarPenerbangan();

        System.out.print("Pilih nomor penerbangan (contoh: 1): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (pilihan > 0 && pilihan <= daftarPenerbangan.size()) {
            Penerbangan penerbanganTerpilih = daftarPenerbangan.get(pilihan - 1);
            penumpang = new Penumpang(NIK, namaDepan, namaBelakang, penerbanganTerpilih);
            System.out.println("Pemesanan tiket berhasil dilakukan.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Method untuk menampilkan pesanan tiket
    public void tampilkanPesananTiket() {
        if (penumpang == null) {
            System.out.println("Pesanan tiket tidak ada.");
        } else {
            penumpang.tampilkanTiket();
        }
    }

    // Method untuk menampilkan menu
    public void tampilkanMenu() {
        while (true) {
            System.out.println("======= EAD Ticket Booking System =======");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silakan pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    tampilkanDaftarPenerbangan();
                    break;
                case 2:
                    beliTiket();
                    break;
                case 3:
                    tampilkanPesananTiket();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {
        TPMODUL1_ZAID pembelian = new TPMODUL1_ZAID();
        pembelian.tambahPenerbangan();
        pembelian.tampilkanMenu();
    }
}
