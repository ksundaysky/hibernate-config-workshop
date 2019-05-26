package pl.ksundaysky;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseConnection {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.h2.Driver");
            settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/test");
            settings.put(Environment.USER, "sa");
            settings.put(Environment.PASS, "takjest");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Person.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }
}
