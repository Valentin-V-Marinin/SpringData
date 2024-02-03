package seminar5;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getTaskByStatus(Task.STATUS status){
        return repository.findByStatus(status);
    }
    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task updateTask(Long id, Task.STATUS status) {
        Task existingTask = getTaskById(id);
        existingTask.setStatus(status);
        return repository.save(existingTask);
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        getTaskById(id);
        repository.deleteById(id);
    }
}
