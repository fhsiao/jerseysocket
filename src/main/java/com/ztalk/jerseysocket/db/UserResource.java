package com.ztalk.jerseysocket.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("users")
public class UserResource {
    private static final Logger logger = LogManager.getLogger();
    private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<User> getDBUsers() throws SQLException, NamingException {
        //return userDao.getAllUsers();
        return userDao.getDBUsers();
    }
}
