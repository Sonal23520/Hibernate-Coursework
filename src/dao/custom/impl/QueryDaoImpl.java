package dao.custom.impl;

import dao.custom.QueryDAO;
import entity.Course;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;


public class QueryDaoImpl implements QueryDAO {

    @Override
    public Course getLastCourse() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query from_course = session.createQuery("from Course");
        List list = from_course.list();
        Course course = (Course) list.get(list.size() - 1);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")? course:null;
    }

    @Override
    public Student getLastStudent() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query from_student_ = session.createQuery("from Student ");
        List list = from_student_.list();
        Student student= (Student) list.get(list.size() - 1);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?student:null;
    }

    @Override
    public Registration getLastRegistration() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query from_registration_ = session.createQuery("from Registration ");
        List list = from_registration_.list();
        Registration registration= (Registration) list.get(list.size() - 1);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?registration:null;
    }
}
