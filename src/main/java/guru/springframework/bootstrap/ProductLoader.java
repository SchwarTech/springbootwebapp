package guru.springframework.bootstrap;

import guru.springframework.domain.Product;
//import guru.springframework.domain.Task;
import guru.springframework.repositories.ProductRepository;
//import guru.springframework.repositories.TaskRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
//    private TaskRepository taskRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Autowired
//    public void setTaskRepository(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
        
        
/*        
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
*/
    }
}
