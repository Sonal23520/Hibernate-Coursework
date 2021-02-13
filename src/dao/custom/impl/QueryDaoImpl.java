package dao.custom.impl;

import dao.custom.QueryDAO;
import entity.Course;
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
}
