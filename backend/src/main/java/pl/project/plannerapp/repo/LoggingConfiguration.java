package pl.project.plannerapp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.service.LoggingDataServiceImpl;

@Configuration
public class LoggingConfiguration {

  @Bean
  public LoggingDataService loggingDataService(@Autowired LoggingDataRepo loggingDataRepo){
    return new LoggingDataServiceImpl(loggingDataRepo);
  }
}
