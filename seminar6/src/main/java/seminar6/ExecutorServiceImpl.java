package seminar6;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecutorServiceImpl implements ExecutorService{

    private final ExecutorRepository executorRepository;
    public  final TaskService taskService;

    public ExecutorServiceImpl(ExecutorRepository executorRepository, TaskService taskService) {
        this.executorRepository = executorRepository;
        this.taskService = taskService;
    }

    public List<Executor> findByTask(Long taskId){
        Task task = taskService.getTaskById(taskId);
        return executorRepository.findByTask(task);
    }

    @Override
    public List<Executor> getAllExecutors() {
        return executorRepository.findAll();
    }

    @Override
    public Executor getExecutorById(Long id) {
        return executorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Executor not found"));
    }

    @Override
    public Executor createExecutor(Executor executor) {
        return executorRepository.save(executor);
    }

    @Override
    public Executor updateExecutor(Long id, String name) {
        Executor executor = getExecutorById(id);
        executor.setName(name);
        return executorRepository.save(executor);
    }

    public Executor assignTask(Long taskId, Long executorId) {
        Task task = taskService.getTaskById(taskId);
        Executor executor = getExecutorById(executorId);
        executor.setTask(task);
        return executorRepository.save(executor);
    }

    @Override
    public void deleteExecutor(Long id) {
        getExecutorById(id);
        executorRepository.deleteById(id);
    }
}
