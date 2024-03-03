package pl.project.plannerapp.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("pl.project.plannerapp.repo")
@EnableTransactionManagement
public class JPAConfiguration {
    @Bean
    public DataSourceBuilder getDataSourceBuilder() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/plannerapp?useUnicode=true&characterEncoding=utf8&" +
                "useSSL=false@useLegacyDatetimeCode=false@serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSourceBuilder.username("planner");
        dataSourceBuilder.password("planner");
        return dataSourceBuilder.build();
    }

}
