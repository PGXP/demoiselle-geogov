package org.demoiselle.jee.geogov.consume;

import com.google.gson.Gson;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.demoiselle.jee.geogov.DemoiselleGeoGovConfig;
import org.demoiselle.jee.geogov.security.Credentials;
import org.demoiselle.jee.geogov.security.Token;

/**
 *
 * @author PauloGladson
 */
@RequestScoped
public class Auth {

    private static final Logger LOG = getLogger(Auth.class.getName());

    @Inject
    private DemoiselleGeoGovConfig config;

    @Inject
    private Util util;

    /**
     *
     * @return
     */
    public Token login() {

        Credentials credentials = new Credentials();
        credentials.setUsername(config.getUsername());
        credentials.setPassword(config.getPassword());
        String hostSent = "api/auth";
        String resposta = util.doPOST(hostSent, new Gson().toJson(credentials), null);
        return (new Gson().fromJson(resposta, Token.class));

    }

}
