package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Task;
import aicha.pfe.tasks.entity.TaskStatus;
import aicha.pfe.tasks.service.task.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskRestController {

    private final ITaskService taskService;

    @Autowired
    public TaskRestController(ITaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/retrieve-all-tasks")
    @ResponseBody
    public List<Task> getTasks() {
        return taskService.retrieve();
    }

    @GetMapping("/all-status")
    @ResponseBody
    public TaskStatus[] getAllStatusTask() {
        return TaskStatus.values();
    }

    @PostMapping("/add-task")
    @ResponseBody
    public Task addTask(@RequestBody Task task) {
        return taskService.add(task);
    }

    @DeleteMapping("/remove-task/{task-id}")
    @ResponseBody
    public void removeTask(@PathVariable("task-id") Long taskId) {
        taskService.delete(taskId);
    }

    @PutMapping("/modify-task")
    @ResponseBody
    public Task modifyTask(@RequestBody Task task) {
        return taskService.update(task);
    }
}


