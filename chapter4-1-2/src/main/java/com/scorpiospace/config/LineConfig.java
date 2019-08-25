package com.scorpiospace.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "lineEntityManagerFactory",// 实体管理工厂类
        transactionManagerRef = "lineTransactionManager",// 事务管理类
        basePackages = {"com.scorpiospace.repository.line"}// repository所在位置
)
public class LineConfig {

    @Autowired
    @Qualifier("lineDataSource")
    private DataSource lineDataSource;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    private JpaProperties jpaProperties;

    /**
     *
     * @param builder
     * @return
     */
    @Primary
    @Bean("lineEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){

        return lineEntityManagerFactory(builder).getObject().createEntityManager();
    }

    /**
     * 设置实体类所在位置
     * @param builder
     * @return
     */
    @Primary
    @Bean("lineEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean lineEntityManagerFactory(EntityManagerFactoryBuilder builder){

        Map<String,Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(),new HibernateSettings());

        return builder
                .dataSource(lineDataSource)
                .packages("com.scorpiospace.domain.line")
                .properties(properties)
                .persistenceUnit("linePersistenceUnit")
                .build();

    }

    @Primary
    @Bean("lineTransactionManager")
    public PlatformTransactionManager lineTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(lineEntityManagerFactory(builder).getObject());
    }

}
