package com.charter.jerseysocket.system;

import com.bettercloud.vault.VaultException;
import com.charter.jerseysocket.vault.VaultClient;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.IntrospectionUtils;


public class TomcatPropertyDecoder implements IntrospectionUtils.PropertySource {
    private static final Logger logger = Logger.getLogger(TomcatPropertyDecoder.class);

    @Override
    public String getProperty(String arg0) {
        try {
            String sVault = VaultClient.getVault();
            logger.debug("getProperty: "+sVault);
            return sVault;
        } catch (VaultException e) {
            logger.debug("getProperty() error: "+e.fillInStackTrace());
            e.printStackTrace();
        }
        return "";
    }

}
