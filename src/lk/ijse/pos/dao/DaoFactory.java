package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dao.custom.impl.QueryDAOImpl;

public class DaoFactory {
    //1st Step
    private static DaoFactory daoFactory;

    //2nd Step
    private DaoFactory() {
    }

    //3rd Step
    public static DaoFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DaoFactory()) : (daoFactory);
    }

    //4th Step
    public enum DAOType {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL,QUERY
    }

    //5th Step
  /*  public SuperDAO getDao(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            default:
                return null;
        }
    }*/

    public <T> T getDao(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }

}
