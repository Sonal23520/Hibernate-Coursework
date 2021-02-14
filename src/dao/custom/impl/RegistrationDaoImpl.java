package dao.custom.impl;

import dao.custom.RegistrationDao;
import entity.Registration;
import entity.Student;
import entity.SuperEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDaoImpl implements RegistrationDao {

    @Override
    public boolean save(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }

    @Override
    public Registration search(Integer integer) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query from_registration_= session.createQuery("from Registration ");
        List list = from_registration_.list();
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")? (ArrayList<Registration>) list :null;
    }
}
