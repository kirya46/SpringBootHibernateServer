package com.common.config;

import com.common.dao.GenericDao;
import com.common.dao.entity.Avatar;
import com.common.dao.impl.PurchaseDao;
import com.common.util.log.Log;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.NamingStrategy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Kirill Stoianov on 28/08/17.
 */
@Configuration
@EnableTransactionManagement
/**
 * enable defining implementation of interfaces as Bean (GenericDao implementation)
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableAutoConfiguration(exclude=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)

public class HibernateConfig {


    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {

        //be sure that the all POJO's are insede 'dao' package
        final String daoPackage = GenericDao.class.getPackage().getName();

        final LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());

        return localSessionFactoryBuilder
                .scanPackages(daoPackage)
                .buildSessionFactory();
    }

    @Bean
    public DataSource getDataSource() {


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/spring");
        dataSource.setUsername("kirya");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }


//    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder)
            throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException {

        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");
        properties.put("hibernate.generate_statistics", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put("hibernate.cache.region.factory_class",
                "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        properties.put("spring.jpa.database","POSTGRESQL");
        properties.put("spring.datasource.platform","postgres");
        properties.put("spring.database.driverClassName","org.postgresql.Driver");


        LocalContainerEntityManagerFactoryBean factoryBean = builder
                .dataSource(getDataSource())
                .packages(Avatar.class)
                .properties(properties)
                .persistenceUnit("main-pu")
                .build();

        return factoryBean;
    }

}
