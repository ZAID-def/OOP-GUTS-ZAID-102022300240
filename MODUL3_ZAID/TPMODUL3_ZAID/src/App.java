

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private TableView<Album> albumTableView;
    private TableColumn<Album, Integer> availableColumn;
    private TableColumn<Album, Integer> totalColumn;
    private TableColumn<Album, String> artistColumn;
    private TableColumn<Album, String> albumNameColumn;
    private TextField judulAlbumField;
    private TextField namaArtisField;
    private TextField jumlahTotalField;
    private TextField jumlahRentedField;

    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error loading login scene: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}