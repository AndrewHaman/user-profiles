package com.dece.userprofile.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@Profile("test")
public class TestApplicationConfig {

    @Bean
    @Primary
    public EmbeddedDatabase embeddedDatabase() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("deceuser")
                .addScript("classpath:H2_UserProfile_Create.sql")
                .addScript("classpath:H2_UserProfile_Insert.sql")
                .build();
    }

    @Lazy
    @Autowired
    JpaVendorAdapter jpaVendorAdapter;

    @Bean
    public DataSource dataSource() { return embeddedDatabase(); }

    @Bean
    public EntityManager entityManager() { return entityManagerFactory().createEntityManager(); }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("com.dece.userprofile*");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() { return new JpaTransactionManager(entityManagerFactory()); }

}
