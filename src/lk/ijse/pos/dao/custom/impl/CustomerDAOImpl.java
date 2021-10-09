package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO Customer VALUES(?,?,?,?)",
                        customer.getId(),customer.getName(),
                        customer.getAddress(),customer.getSalary());
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public Customer get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",id);
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4));
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            customerList.add(
                    new Customer(
                            resultSet.getString(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getDouble(4))
            );
        }
        return customerList;
    }
}
