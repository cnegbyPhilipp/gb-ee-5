package ru.gb.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    return new org.hibernate.cfg.Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();
  }

  @Bean
  public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
    return entityManagerFactory.createEntityManager();
  }
}
