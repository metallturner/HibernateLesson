package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainSavePerson {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Joe");
            Person person1 = new Person("Ross");
            Person person2 = new Person("Monika");

            session.save(person);
            session.save(person1);
            session.save(person2);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}

