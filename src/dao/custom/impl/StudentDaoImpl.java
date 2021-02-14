package dao.custom.impl;

import dao.custom.StudentDao;
import entity.Course;
import entity.Student;
import entity.SuperEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student load = session.load(Student.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public Student search(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?student:null;
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query from_student_ = session.createQuery("from Student ");
        List list = from_student_.list();
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")? (ArrayList<Student>) list :null;
    }
}
