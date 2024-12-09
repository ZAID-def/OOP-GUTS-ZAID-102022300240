

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlbumController {

    @FXML
    private TableView<Album> albumTableView;

    @FXML
    private TableColumn<Album, Integer> availableColumn;

    @FXML
    private TableColumn<Album, Integer> totalColumn;

    @FXML
    private TableColumn<Album, String> artistColumn;

    @FXML
    private TableColumn<Album, String> albumNameColumn;

    @FXML
    private TextField judulAlbumField;

    @FXML
    private TextField namaArtisField;

    @FXML
    private TextField jumlahTotalField;

    @FXML
    private TextField jumlahRentedField;

    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("rented"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        albumNameColumn.setCellValueFactory(new PropertyValueFactory<>("albumName"));

        albumTableView.setItems(albumList);
    }

    @FXML
    void handleTambahAction(ActionEvent event) {
        try {
            String albumName = judulAlbumField.getText();
            String artist = namaArtisField.getText();
            int total = Integer.parseInt(jumlahTotalField.getText());
            int rented = Integer.parseInt(jumlahRentedField.getText());

            if (rented > total) {
                showAlert("Error", "Jumlah Rented tidak bisa lebih besar dari Total.");
                return;
            }

            Album newAlbum = new Album(albumName, artist, total, rented);
            albumList.add(newAlbum);
            albumTableView.setItems(albumList); // Update the table view

            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Pastikan jumlah Total dan Rented adalah angka.");
        }
    }

    @FXML
    void handleHapusAction(ActionEvent event) {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
        } else {
            showAlert("Peringatan", "Silakan pilih album yang ingin dihapus.");
        }
    }

    @FXML
    void handleUpdateAction(ActionEvent event) {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                selectedAlbum.setAlbumName(judulAlbumField.getText());
                selectedAlbum.setArtist(namaArtisField.getText());
                selectedAlbum.setTotal(Integer.parseInt(jumlahTotalField.getText()));
                selectedAlbum.setRented(Integer.parseInt(jumlahRentedField.getText()));

                if (selectedAlbum.getRented() > selectedAlbum.getTotal()) {
                    showAlert("Error", "Jumlah Rented tidak bisa lebih besar dari Total.");
                    return;
                }

                albumTableView.refresh();
                clearFields();
            } catch (NumberFormatException e) {
                showAlert("Error", "Pastikan jumlah Total dan Rented adalah angka.");
            }
        } else {
            showAlert("Peringatan", "Silakan pilih album yang ingin diupdate.");
        }
    }

    @FXML
    void handleRentSelectedAction(ActionEvent event) {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            if (selectedAlbum.getRented() < selectedAlbum.getTotal()) {
                selectedAlbum.setRented(selectedAlbum.getRented() + 1);
                albumTableView.refresh();
            } else {
                showAlert("Peringatan", "Album sudah habis disewa.");
            }
        } else {
            showAlert("Peringatan", "Silakan pilih album yang ingin disewa.");
        }
    }

    private void clearFields() {
        judulAlbumField.clear();
        namaArtisField.clear();
        jumlahTotalField.clear();
        jumlahRentedField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}