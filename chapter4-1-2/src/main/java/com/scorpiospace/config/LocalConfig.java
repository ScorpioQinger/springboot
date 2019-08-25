package com.scorpiospace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "localEntityManagerFactory",// 实体管理工厂类
        transactionManagerRef = "localTransactionManager",// 事务管理类
        basePackages = {"com.scorpiospace.repository.local"}// repository所在位置
)
public class LocalConfig {

    @Autowired
    @Qualifier("localDataSource")
    private DataSource localDataSource;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean("localEntityManager")
    public EntityManager localEntityManager(EntityManagerFactoryBuilder builder) {
        return localEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean("localEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());

        return builder.dataSource(localDataSource)
                .properties(properties)
                .packages("com.scorpiospace.domain.local")
                .persistenceUnit("linePersistenceUnit")
                .build();
    }

    @Bean("localTransactionManager")
    public PlatformTransactionManager localTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(localEntityManagerFactory(builder).getObject());

    }

}
