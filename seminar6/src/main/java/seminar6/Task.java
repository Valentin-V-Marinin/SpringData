package seminar6;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "tasks")
public class Task {

    public enum STATUS { TO_DO, IN_PROGRESS, DONE }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated
    @Column(nullable = false)
    private STATUS status;

    @Column(nullable = false)
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


}
