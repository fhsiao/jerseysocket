package com.ztalk.jerseysocket.vault;


import com.bettercloud.vault.VaultException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("getvault")
public class VaultResource {
    private static final Logger logger = LogManager.getLogger(VaultResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getVault() throws VaultException {
        logger.debug("sample debug message");
        logger.info("sample info message");
        logger.warn("sample warning message");
        logger.error("sample error message");
        return VaultClient.getVault();
    }
}
