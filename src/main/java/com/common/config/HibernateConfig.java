package com.common.config;

import com.common.dao.GenericDao;
import com.common.dao.impl.PurchaseDao;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.NamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by Kirill Stoianov on 28/08/17.
 */
@Configuration
@EnableTransactionManagement
/**
 * enable defining implementation of interfaces as Bean (GenericDao implementation)
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class HibernateConfig {

    @Bean
    public PurchaseDao getPurchaseDao(){
        return new PurchaseDao();
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {

        //be sure that the all POJO's are insede 'dao' package
        final String daoPackage = GenericDao.class.getPackage().getName();

        return new LocalSessionFactoryBuilder(getDataSource())
                //.addAnnotatedClasses(Avatar.class,Purchase.class)
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

}
