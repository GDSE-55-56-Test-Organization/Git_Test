package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.QueryDAO;

import java.sql.ResultSet;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public String getId() throws Exception {
        ResultSet set = CrudUtil.
                execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        String id="C001";
        if (set.next()){
            String temp=set.getString(1);
            String[] cs = temp.split("C");
            int selectedId=Integer.parseInt(cs[1])+1;
            if (selectedId>10){
                id="C0"+(selectedId+1);
            }
        }
        return id;
    }
}
