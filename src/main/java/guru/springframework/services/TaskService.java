package guru.springframework.services;


import guru.springframework.domain.Task;

public interface TaskService {
    Iterable<Task> listAllTasks();

    Task getTaskById(Integer id);

    Task saveTask(Task task);
}
