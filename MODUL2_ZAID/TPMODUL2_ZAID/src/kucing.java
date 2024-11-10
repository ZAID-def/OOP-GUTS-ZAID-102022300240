public class kucing extends hewan {
    private String ras;

    public kucing(String nama, int umur, String ras) {
        super(nama, umur);
        this.ras = ras;
    }

    @Override
    public void suara() {
        System.out.println("Kucing mengeong");
    }

    @Override
    public void infoHewan() {
        System.out.println("Nama: " + nama + ", Umur: " + umur + ", Ras: " + ras);
    }
}
