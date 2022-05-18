package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan("web.dao")
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DbConfig {
//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        Properties props = additionalProperties(); // new Properties();
//        factoryBean.setHibernateProperties(props);
//        factoryBean.setAnnotatedClasses(User.class);
//        return factoryBean;
//    }
//
//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        return transactionManager;
//    }
//    private Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.pool_size", "1");
//        properties.setProperty("hibernate.current_session_context_class", "thread");
//        properties.setProperty("hibernate.show_sql", "true");
//        return properties;
//    }
//    private DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        dataSource.setUsername("root");
//        dataSource.setPassword("Root@12345");
//        return dataSource;
//    }
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("web_model_User");
        return entityManagerFactory;
    }
    @Bean (name = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

}
