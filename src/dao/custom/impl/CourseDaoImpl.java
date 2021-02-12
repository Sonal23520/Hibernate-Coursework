package dao.custom.impl;

import dao.custom.CourseDao;
import entity.Course;
import entity.Login;
import entity.SuperEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public boolean save(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;

    }

    @Override
    public boolean update(Course entity) throws Exception {
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
        Course load = session.load(Course.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public Course search(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, s);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")? course :null;

    }

    @Override
    public ArrayList<Course> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query course = session.createQuery("from Course");
        List list = course.list();
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")? (ArrayList<Course>) list :null;

    }
}
