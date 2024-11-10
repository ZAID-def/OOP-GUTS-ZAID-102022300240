public class Main {
    public static void main(String[] args) throws Exception {
        kucing kucing = new kucing("Tom", 3, "Anggora");
        kucing.suara();
        kucing.infoHewan();

        System.out.println();

        burung burung = new burung("Tweety", 2, "Kuning");
        burung.suara();
        burung.infoHewan();
    }
}
