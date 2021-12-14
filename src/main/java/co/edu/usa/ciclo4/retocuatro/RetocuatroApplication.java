package co.edu.usa.ciclo4.retocuatro;

import co.edu.usa.ciclo4.retocuatro.repository.crud.GadgetCrudRepository;
import co.edu.usa.ciclo4.retocuatro.repository.crud.OrderCrudRepository;
import co.edu.usa.ciclo4.retocuatro.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetocuatroApplication implements CommandLineRunner{
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;
            
	public static void main(String[] args) {
		SpringApplication.run(RetocuatroApplication.class, args);
	}

        @Override
        public void run(String... args) throws Exception{
        gadgetCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();  
        }
}
