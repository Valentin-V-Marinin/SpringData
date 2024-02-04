package seminar6;

import jakarta.persistence.*;

@Entity
@Table(name = "executors")
public class Executor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;


    public Executor() {}


    // region Getters&Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    // endregion



}
