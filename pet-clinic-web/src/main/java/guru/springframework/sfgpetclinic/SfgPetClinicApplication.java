package guru.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SfgPetClinicApplication {

    public static void main(String[] args) {
        System.out.println("xxxx MAIN thrad = " + Thread.currentThread().getName());
        ConfigurableApplicationContext run = SpringApplication.run(SfgPetClinicApplication.class, args);
    }
}
