import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    void handleLoginButtonAction() {
        // Logic for login authentication
        // Validate username and password
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("password")) {
            try {
                // Load inventory scene
                Parent root = FXMLLoader.load(getClass().getResource("album.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading inventory scene: " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Username or password is incorrect!");
            alert.showAndWait();
        }
    }
}