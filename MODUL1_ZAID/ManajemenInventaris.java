package MODUL1_ZAID;
import java.util.ArrayList;
import java.util.Scanner;


public class ManajemenInventaris {
    private ArrayList<Barang> daftarBarang;

    public ManajemenInventaris() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarangElektronik() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang Elektronik: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jumlah Barang: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan Harga Barang: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan Garansi Barang: ");
        String garansi = scanner.nextLine();

        BarangElektronik barang = new BarangElektronik(nama, jumlah, harga, garansi);
        daftarBarang.add(barang);

        System.out.println("Barang Elektronik berhasil ditambahkan!\n");
    }

    public void tambahBarangNonElektronik() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang Non-Elektronik: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jumlah Barang: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan Harga Barang: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Masukkan Material Barang: ");
        String material = scanner.nextLine();

        BarangNonElektronik barang = new BarangNonElektronik(nama, jumlah, harga, material);
        daftarBarang.add(barang);

        System.out.println("Barang Non-Elektronik berhasil ditambahkan!\n");
    }

    public void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang di inventaris.\n");
        } else {
            System.out.println("\nDaftar Semua Barang:");
            for (Barang barang : daftarBarang) {
                barang.tampilkanData();
            }
        }
    }
}
