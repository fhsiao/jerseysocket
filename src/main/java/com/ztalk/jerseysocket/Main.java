package com.ztalk.jerseysocket;

import com.bettercloud.vault.VaultException;
import com.ztalk.jerseysocket.system.Arg;
import com.ztalk.jerseysocket.system.PROP;
import com.ztalk.jerseysocket.vault.VaultClient;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 *
 *  The Main class with the main() method is part of the executable jar application to facilitate the need of testing the functionality
 *          without Tomcat to be involved.
 *
 * Auther: Frank
 */

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

//        Properties properties = System.getProperties();
//        LinkedHashMap<String, String> collect = properties.entrySet().stream()
//                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
//                .entrySet().stream().sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//        collect.forEach((k, v) -> System.out.println(k + ":" + v));
//
//
//        Configurator.initialize(LogManager.ROOT_LOGGER_NAME,
//                Thread.currentThread().getContextClassLoader(),
//                "log4j2.xml");


        Arg arg = Arg.getInstance();
        arg.setArgs(args);
        //// Testing global settings
        if (PROP.getGlobalSize() > 0) {
            try {
                System.out.println(VaultClient.getVault());
            } catch (VaultException e) {
                logger.debug(e.getMessage(),e.fillInStackTrace());
            }
        }
        //// Testing resource settings
        String resourceName = "resource-1";
        PROP.addResource(resourceName);
        if (PROP.getGlobalSize() > 0) {
            try {
                System.out.println(VaultClient.getVault(resourceName));
            } catch (VaultException e) {
                logger.debug(e.getMessage(), e.fillInStackTrace());
            }
        } else {
            logger.debug("Unexpecting size of global map to be 0");
        }
        //// Testing args resources if any
        HashMap map = PROP.getResourceMap();
        map.forEach((k,v) -> {
            try {
                System.out.println(VaultClient.getVault((String)k));
            } catch (VaultException e) {
                logger.debug(e.getMessage(),e.fillInStackTrace());
            }
        });
    }
}
