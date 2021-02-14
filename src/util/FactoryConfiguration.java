package util;

import entity.Course;
import entity.Login;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfigurationInstance;
    private SessionFactory sessionFactory;
    private FactoryConfiguration() throws IOException {
        Properties properties=new Properties();
        properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        Configuration configuration = new Configuration()
                .mergeProperties(properties)
                .addAnnotatedClass(Login.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Registration.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() throws IOException {
        if (factoryConfigurationInstance == null) {
            factoryConfigurationInstance = new FactoryConfiguration();
        }
        return factoryConfigurationInstance;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
