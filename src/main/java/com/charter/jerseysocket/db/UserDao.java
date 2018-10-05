package com.charter.jerseysocket.db;

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

public class UserDao {
    public List<User> getDBUsers() throws NamingException, SQLException {

        ArrayList<User> userList = new ArrayList<>();

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
            ds = (DataSource) envContext.lookup("jdbc/test");
        }
        {
            Connection conn = ds.getConnection();

            Statement statement = conn.createStatement();
            String sql = "select * from example";

            ResultSet rset = statement.executeQuery(sql);  // Send the query to the server

            int count = 0;
            while (rset.next()) {
                userList.add(new User(count,rset.getString("name"),"Engineer"));
                ++count;
            }
        }
        return userList;
    }
}