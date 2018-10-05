package com.charter.jerseysocket.vault;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;

public class VaultClient {
    private static final long serialVersionUID = 1L;
    private static String token     = "25e4df62-4633-603c-1bdb-001d5f0154b9";
    private static String proto     = "http";
    private static String address   = "172.17.0.5";
    private static String port      = "8200";
    private static String path      = "secret/hello";
    private static String user      = "spectrum_admin";
    private static int openTimeout  = 5;
    private static int readTimeout  = 5;

    public static String getVault() throws VaultException {
        final VaultConfig config =
                new VaultConfig()
                        .address(proto+"://"+address+":"+port)
                        .token(token)
                        .openTimeout(openTimeout)
                        .readTimeout(readTimeout)
                        //    .sslPemFile("/path/on/disk.pem")
                        ////  See also: "sslPemUTF8()" and "sslPemResource()"
                        //    .sslVerify(false)
                        .build();

        final Vault vault = new Vault(config);

        //final Map<String, Object> secrets = new HashMap<>();
        //secrets.put("value", "world");
        //secrets.put("other_value", "You can store multiple name/value pairs under a single key");
        //secrets.put("tomcat", "vault3123");

        // Write operation
        //final LogicalResponse writeResponse = vault.logical().write("secret/hello", secrets);

        // Read operation
        final String value = vault.logical()
                .read(path)
                .getData().get(user);
        return value;
    }
}
