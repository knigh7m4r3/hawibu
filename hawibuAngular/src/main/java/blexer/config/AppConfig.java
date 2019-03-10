package blexer.config;


import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"blexer.datalayer.repository"})
@ComponentScans(value = {
        @ComponentScan("blexer.datalayer.model"),
        @ComponentScan("blexer.config"),
        @ComponentScan("blexer.controller"),
        @ComponentScan("blexer.datalayer.repository"),
        @ComponentScan("blexer.datalayer.service"),
        @ComponentScan("blexer.datalayer.serviceImpl")
})
public class AppConfig {

    @Autowired
    Environment env;


    @Bean
    public EntityManager entityManager() {
        return this.entityManagerFactory().createEntityManager();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("thePersistenceUnit");

        return emf;
    }

    @ConfigurationProperties(prefix = "db.properties")
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean
    public HibernateTransactionManager transactionManager(){

        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setSessionFactory(entityManagerFactory().unwrap(SessionFactory.class));
        tm.setDataSource(dataSource());

        return tm;

    }
}
