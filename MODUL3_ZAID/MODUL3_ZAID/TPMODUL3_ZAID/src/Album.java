

public class Album {
    private String albumName;
    private String artist;
    private int total;
    private int rented;

    public Album(String albumName, String artist, int total, int rented) {
        this.albumName = albumName;
        this.artist = artist;
        this.total = total;
        this.rented = rented;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRented() {
        return rented;
    }

    public void setRented(int rented) {
        this.rented = rented;
    }

    public String getAvailable() {
        return (total - rented) > 0 ? "Available" : "Not Available";
    }
}