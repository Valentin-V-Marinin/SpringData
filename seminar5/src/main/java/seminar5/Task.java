package seminar5;


import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;


@Entity
@Table(name = "tasks")
public class Task {

    public enum STATUS { TO_DO, IN_PROGRESS, DONE }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated
    @Column(name = "status")
    private STATUS status;

    @Column(name = "date")
    private Date date;


    public Task() {}


    // region Getters&Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Date getDate() {   return date;  }

    public void setDate(Date date) {
        this.date = date;
    }

    // endregion


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}
