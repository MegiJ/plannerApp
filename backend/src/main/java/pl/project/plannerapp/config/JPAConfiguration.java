package pl.project.plannerapp.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("pl.project.plannerapp.repo")
@EnableTransactionManagement
public class JPAConfiguration {

    @Bean
    public DataSource getDataSourceBuilder() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/plannerapp");
        dataSourceBuilder.username("planner");
        dataSourceBuilder.password("planner");
        return dataSourceBuilder.build();
    }

    @Bean public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        return adapter; }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSourceBuilder dataSourceBuilder, HibernateJpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSourceBuilder.build());
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        entityManagerFactoryBean.setPackagesToScan(
//                "pl.project.plannerapp.model",
//                "pl.project.plannerapp.conventer"
//        );
//        entityManagerFactoryBean.setJpaPropertyMap(ImmutableMap.of(
//                AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect",
////                AvailableSettings.SHOW_SQL, "true",
//                AvailableSettings.HBM2DDL_AUTO, "create"
//        ));
//        return entityManagerFactoryBean;
//    }

//    @Bean
//    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//        return entityManagerFactory.createEntityManager();
//    }

//    @Bean
//    public HibernateExceptionTranslator hibernateExceptionTranslator() {
//        return new HibernateExceptionTranslator();
//    }

//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
}
