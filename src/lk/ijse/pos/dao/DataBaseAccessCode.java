package lk.ijse.pos.dao;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessCode {

    //----------- Customer data-------------

    public boolean saveCustomer(CustomerDTO dto) throws ClassNotFoundException, SQLException {
        return false;
    }

    public CustomerDTO getCustomer(String id) throws ClassNotFoundException, SQLException {
        return null;

    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        return null;
    }

    //----------- Item data-------------

    public boolean saveItem(ItemDTO dto) throws ClassNotFoundException, SQLException {
       return false;
    }

    public ItemDTO getItem(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException {
       return null;
    }
}
