package org.example.comfing;

import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Course;
import org.example.entity.Student;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @Baiysh155f. Hibernateexemple
 * 31.01.2023
 * admin
 * вт
 **/
public class HibernateConnection {
    public static EntityManagerFactory createEntityManagerFactory() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "1234");

        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Course.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
