
import java.time.LocalDate;

public class Task {
    // Atribut private untuk kelas Task
    private String title;
    private String priority;
    private LocalDate dueDate;
    private String status;

    // Constructor untuk kelas Task
    public Task(String title, String priority, LocalDate dueDate, String status) {
        this.title = title;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getter untuk title
    public String getTitle() {
        return title;
    }

    // Setter untuk title (opsional, jika diperlukan)
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter untuk priority
    public String getPriority() {
        return priority;
    }

    // Setter untuk priority (opsional, jika diperlukan)
    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Getter untuk dueDate
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Setter untuk dueDate (opsional, jika diperlukan)
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Getter untuk status
    public String getStatus() {
        return status;
    }

    // Setter untuk status
    public void setStatus(String status) {
        this.status = status;
    }
}
