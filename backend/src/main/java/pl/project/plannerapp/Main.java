package pl.project.plannerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.project.plannerapp.service.LoggingDataService;

@ComponentScan(
        basePackages = {
                "org.bitbucket.tek.nik.simplifiedswagger", "pl.project.plannerapp"
        }
)
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
      ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
      for (String beanDefinitionName : context.getBeanDefinitionNames()) {
        System.out.println(beanDefinitionName);
      }
    }
}