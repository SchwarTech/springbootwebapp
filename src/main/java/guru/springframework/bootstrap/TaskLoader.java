package guru.springframework.bootstrap;

import guru.springframework.domain.Task;
import guru.springframework.repositories.TaskRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaskLoader implements ApplicationListener<ContextRefreshedEvent> {

    private TaskRepository taskRepository;

    private Logger log = Logger.getLogger(TaskLoader.class);

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Task t1 = new Task();
        t1.setCode("ABAN");
        t1.setFrequency("Daily");
        t1.setLocation("100 Main Street");
        t1.setRemarks("Mrs Jones needs a wellness check");
        t1.setNextDate("April 18, noon");
        taskRepository.save(t1);

        log.info("Saved t1 - id: " + t1.getId());

        Task t2 = new Task();
        t2.setCode("ESC");
        t2.setFrequency("Once");
        t2.setLocation("100 State Street");
        t2.setRemarks("Funeral Escort");
        t2.setNextDate("April 19, 10:30a");
        taskRepository.save(t2);

        log.info("Saved t2 - id: " + t2.getId());
    }
}
