package com.MainApp.HQLDemo;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.student.entity.Student;
import com.Hibernate.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // 1. Named Parameter
        Query<Student> q1 = session.createQuery(
                "FROM Student WHERE department = :dept", Student.class);
        q1.setParameter("dept", "CSE");

        List<Student> list1 = q1.list();
        System.out.println("Students from CSE:");
        list1.forEach(s -> System.out.println(s.getName()));

        // 2. Positional Parameter
        Query<Student> q2 = session.createQuery(
                "FROM Student WHERE marks > ?0", Student.class);
        q2.setParameter(0, 70);

        List<Student> list2 = q2.list();
        System.out.println("\nStudents with marks > 70:");
        list2.forEach(s -> System.out.println(s.getName()));

        // 3. Aggregate Function
        Query<Long> q3 = session.createQuery(
                "SELECT count(s.id) FROM Student s", Long.class);
        Long count = q3.uniqueResult();
        System.out.println("\nTotal Students: " + count);

        // 4. Sorting
        Query<Student> q4 = session.createQuery(
                "FROM Student ORDER BY marks DESC", Student.class);
        List<Student> sortedList = q4.list();
        sortedList.forEach(s ->
                System.out.println(s.getName() + " - " + s.getMarks()));

        // 5. Pagination
        Query<Student> q5 = session.createQuery("FROM Student", Student.class);
        q5.setFirstResult(0);
        q5.setMaxResults(3);

        List<Student> pageList = q5.list();
        pageList.forEach(s -> System.out.println(s.getName()));

        // 6. Criteria API
        Criteria c = session.createCriteria(Student.class);
        c.add(Restrictions.gt("marks", 80));

        List<Student> criteriaList = c.list();
        criteriaList.forEach(s -> System.out.println(s.getName()));

        tx.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
