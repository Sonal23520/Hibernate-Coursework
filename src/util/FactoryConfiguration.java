package util;

import entity.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfigurationInstance;
    private SessionFactory sessionFactory;
    private FactoryConfiguration() {
        Configuration configuration = new Configuration().addAnnotatedClass(Login.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        if (factoryConfigurationInstance == null) {
            factoryConfigurationInstance = new FactoryConfiguration();
        }
        return factoryConfigurationInstance;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
