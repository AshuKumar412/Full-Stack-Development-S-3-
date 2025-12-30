package com.Hibernate.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.entity.Student;

public class HibernateUtil {
    private static SessionFactory factory;

    static {
        factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
