package bo;

import bo.custom.impl.CourseBoImpl;
import bo.custom.impl.LoginBoImpl;

public class BoFactory {

    private static BoFactory boFactoryInstance;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactoryInstance == null) {
            boFactoryInstance = new BoFactory();
        }
        return boFactoryInstance;
    }
    public enum BoType{
        LOGIN,COURSE
    }
    public <T extends SuperBO> T getBo(BoType boType){
        switch (boType){
            case LOGIN:
                return (T) new LoginBoImpl();
            case COURSE:
                return (T) new CourseBoImpl();
            default:
                return null;
        }
    }
}
