package dao;

import dao.custom.impl.CourseDaoImpl;
import dao.custom.impl.LoginDaoImpl;
import dao.custom.impl.QueryDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DaoFactory():daoFactory;
    }
    public enum DaoType {
    LOGIN,QUERY,COURSE
    }
    public <T extends SuperDAO> T getDao(DaoType daoType){
        switch (daoType){
            case LOGIN:
                return (T) new LoginDaoImpl();
            case QUERY:
                return (T) new QueryDaoImpl();
            case COURSE:
                return (T) new CourseDaoImpl();
            default:
                return null;
        }
    }
}
