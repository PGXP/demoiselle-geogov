package org.demoiselle.jee.geogov.consume;

import com.google.gson.Gson;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.demoiselle.jee.core.exception.DemoiselleException;
import org.demoiselle.jee.geogov.entity.Ip2location;
import org.demoiselle.jee.geogov.security.Token;

/**
 *
 * @author 70744416353
 */
public class Ip2locations {

    private static final Logger LOG = Logger.getLogger(Ip2locations.class.getName());

    private String service = "api/ip2locations";

    @Inject
    private Util util;

    /**
     *
     * @param ip
     * @param token
     * @return
     */
    public Ip2location searchByIP(String ip, Token token) {

        String hostSent = service + "/" + ip;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Ip2location.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param ip
     * @return
     */
    public Ip2location searchByIP(String ip) {
        return searchByIP(ip, null);
    }

    /**
     *
     * @param token
     * @return
     */
    public Ip2location searchByMyIp(Token token) {

        String hostSent = service;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Ip2location.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @return
     */
    public Ip2location searchByMyIp() {
        return searchByMyIp(null);
    }

}
