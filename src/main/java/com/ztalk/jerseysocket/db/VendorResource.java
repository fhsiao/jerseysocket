package com.ztalk.jerseysocket.db;

import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("vendors")
public class VendorResource {
    private static final Logger logger = Logger.getLogger(VendorResource.class);
    private static final long serialVersionUID = 1L;
    VendorDao vendorDao = new VendorDao();
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Vendor> getDBUsers() throws SQLException, NamingException {
        return vendorDao.getDBVendors();
    }
}
