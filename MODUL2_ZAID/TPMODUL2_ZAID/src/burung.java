public class burung extends hewan {
    private String warnaBulu;

    public burung(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void suara() {
        System.out.println("Burung berkicau");
    }

    @Override
    public void infoHewan() {
        System.out.println("Nama: " + nama + ", Umur: " + umur + ", Warna Bulu: " + warnaBulu);
    }
}
