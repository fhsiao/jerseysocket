package com.ztalk.jerseysocket.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendorDao {
    public List<Vendor> getDBVendors() throws NamingException, SQLException {

        ArrayList<Vendor> vendorList = new ArrayList<>();

        Context initContext = null;
        {
            initContext = new InitialContext();
        }
        Context envContext = null;
        {
            envContext = (Context) initContext.lookup("java:comp/env");
        }
        DataSource ds = null;
        {
            ds = (DataSource) envContext.lookup("jdbc/mysql");
        }
        {
            Connection conn = ds.getConnection();

            Statement statement = conn.createStatement();
            String sql = "select * from vendors";

            ResultSet rset = statement.executeQuery(sql);  // Send the query to the server

            int count = 0;
            while (rset.next()) {
                vendorList.add(new Vendor(count,rset.getString("VENDOR_ID"),"VENDOR_NAME"));
                ++count;
            }
        }
        return vendorList;
    }
}