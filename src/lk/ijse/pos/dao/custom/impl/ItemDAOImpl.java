package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws Exception {
        return CrudUtil.execute("INSERT INTO Item VALUES(?,?,?,?)",item.getCode(),item.getDescription(),item.getPrice(),item.getQtyOnHand());
    }

    @Override
    public boolean update(Item item) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?",id);
    }

    @Override
    public Item get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Item WHERE code=?",id);
        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Item");
        ArrayList<Item> items = new ArrayList<>();
        while (resultSet.next()) {
            items.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return items;
    }
}
