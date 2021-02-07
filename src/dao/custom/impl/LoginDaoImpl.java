package dao.custom.impl;

import dao.custom.LoginDao;
import entity.Login;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean save(Login entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        System.out.println(transaction.getStatus());
        return (transaction.getStatus().toString()=="COMMITTED")?true:false;
    }

    @Override
    public boolean update(Login entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }

    @Override
    public Login search(Integer integer) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Login> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List from_login = session.createQuery("from Login").list();
        transaction.commit();
        session.close();
        return (transaction.getStatus().toString()=="COMMITTED")? (ArrayList<Login>) from_login :null;
    }
}
