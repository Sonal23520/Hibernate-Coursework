package dao;

import dao.custom.impl.LoginDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DaoFactory():daoFactory;
    }
    public enum DaoType {
    LOGIN
    }
    public <T extends SuperDAO> T getDao(DaoType daoType){
        switch (daoType){
            case LOGIN:
                return (T) new LoginDaoImpl();
            default:
                return null;
        }
    }
}
