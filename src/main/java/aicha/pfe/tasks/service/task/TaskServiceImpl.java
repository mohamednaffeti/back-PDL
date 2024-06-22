package aicha.pfe.tasks.service.task;

import aicha.pfe.tasks.entity.Task;
import aicha.pfe.tasks.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements ITaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> retrieve() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task add(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task) {
        taskRepository.save(task);
        return task;
    }

}
