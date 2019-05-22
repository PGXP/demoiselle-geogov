package org.demoiselle.jee.geogov.consume;

import com.google.gson.Gson;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.demoiselle.jee.core.exception.DemoiselleException;
import org.demoiselle.jee.geogov.security.Token;

/**
 *
 * @author 70744416353
 */
public class Nodes {

    private static final Logger LOG = Logger.getLogger(Nodes.class.getName());

    private final String service = "api/nodes";

    @Inject
    private Util util;

    /**
     *
     * @param group
     * @param token
     * @return
     */
    public List getGroups(String group, Token token) {

        String hostSent = service + "/group/" + group;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, List.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param group
     * @return
     */
    public List<Nodes> getGroups(String group) {
        return getGroups(group, null);
    }

    /**
     *
     * @param token
     * @return
     */
    public List getCategorys(Token token) {

        String hostSent = service + "/category";
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, List.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @return
     */
    public List getCategorys() {
        return getCategorys(null);
    }

    /**
     *
     * @param token
     * @return
     */
    public List getSummary(Token token) {

        String hostSent = service + "/summary";
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, List.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @return
     */
    public List getSummary() {
        return getSummary(null);
    }

}
