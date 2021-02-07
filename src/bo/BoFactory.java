package bo;

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
        LOGIN
    }
    public <T extends SuperBO> T getBo(BoType boType){
        switch (boType){
            case LOGIN:
                return (T) new LoginBoImpl();
            default:
                return null;
        }
    }
}
