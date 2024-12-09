import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainAppController {

    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> titleCol, priorityCol, statusCol;
    @FXML
    private TableColumn<Task, LocalDate> dueDateCol;
    @FXML
    private TextField titleField;
    @FXML
    private ComboBox<String> priorityBox;
    @FXML
    private DatePicker dueDatePicker;

    private ObservableList<Task> taskList;

    @FXML
    public void initialize() {
        taskList = FXCollections.observableArrayList(TaskFileManager.loadTasks());

        // Konfigurasi kolom tabel untuk setiap atribut task
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        priorityCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        // Konfigurasi lebar kolom agar lebih rapi
        titleCol.setPrefWidth(150);
        priorityCol.setPrefWidth(100);
        statusCol.setPrefWidth(100);
        dueDateCol.setPrefWidth(150);

        taskTable.setItems(taskList);

        // Tambahkan options prioritas ke ComboBox
        priorityBox.getItems().addAll("High", "Medium", "Low");
    }

    @FXML
    private void addTask() {
        try {
            if (titleField.getText().isEmpty() || priorityBox.getValue() == null || dueDatePicker.getValue() == null) {
                throw new MissingFieldException("All fields must be filled.");
            }

            if (dueDatePicker.getValue().isBefore(LocalDate.now())) {
                throw new InvalidDateException("Due date cannot be in the past.");
            }

            // Buat objek task baru dengan value dari field pada form
            Task task = new Task(
                titleField.getText(),
                priorityBox.getValue(),
                dueDatePicker.getValue(),
                "Incomplete"
            );

            // Tambahkan objek task yang telah dibuat ke taskList
            taskList.add(task);

            clearData();
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (MissingFieldException | InvalidDateException e) {
            showError(e.getMessage());
        }
    }

    private void clearData() {
        // Hapus semua value dari field pada form
        titleField.clear();
        priorityBox.getSelectionModel().clearSelection();
        dueDatePicker.setValue(null);
    }

    @FXML
    private void deleteTask() {
        try {
            Task selected = taskTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("No task selected to delete.");
            }

            taskList.remove(selected);
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (TaskNotSelectedException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void markTaskComplete() {
        try {
            Task selected = taskTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("No task selected to mark complete.");
            }

            // Ubah status task menjadi "Complete"
            selected.setStatus("Complete");

            taskTable.refresh();
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (TaskNotSelectedException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    // Kelas MissingFieldException
    class MissingFieldException extends Exception {
        public MissingFieldException(String message) {
            super(message);
        }
    }

    // Kelas TaskNotSelectedException
    class TaskNotSelectedException extends Exception {
        public TaskNotSelectedException(String message) {
            super(message);
        }
    }

    // Kelas InvalidDateException
    class InvalidDateException extends Exception {
        public InvalidDateException(String message) {
            super(message);
        }
    }

    // Kelas MissingDateException
    class MissingDateException extends Exception {
        public MissingDateException(String message) {
            super(message);
        }
    }
}
