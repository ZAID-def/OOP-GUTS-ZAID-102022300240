public class BarangNonElektronik extends Barang {
    private String material;
    public BarangNonElektronik(String nama, int jumlah, double harga, String material) {
        super(nama, jumlah, harga);
        this.material = material;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
        
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("material" + material);
        System.out.println("=================");

    }
}
