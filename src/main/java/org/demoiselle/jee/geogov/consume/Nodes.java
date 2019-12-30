package org.demoiselle.jee.geogov.consume;

import com.google.gson.Gson;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.demoiselle.jee.core.exception.DemoiselleException;
import org.demoiselle.jee.geogov.pojo.Category;
import org.demoiselle.jee.geogov.pojo.Features;
import org.demoiselle.jee.geogov.security.Token;

/**
 *
 * @author PauloGladson
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
    public List<Category> getSummary(Token token) {

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
    public List<Category> getSummary() {
        return getSummary(null);
    }

    /**
     *
     * @param texto
     * @param token
     * @return
     */
    public Features fts(String texto, Token token) {

        String hostSent = service + "/fts/" + texto;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Features.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param texto
     * @return
     */
    public Features fts(String texto) {
        return fts(texto, null);
    }

    /**
     *
     * @param category
     * @param description
     * @param token
     * @return
     */
    public Features searchByCategoryDescription(String category, String description, Token token) {

        String hostSent = service + "/" + category + "/" + description;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Features.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param category
     * @param description
     * @return
     */
    public Features searchByCategoryDescription(String category, String description) {
        return searchByCategoryDescription(category, description, null);
    }

    /**
     *
     * @param category
     * @param group
     * @param description
     * @param token
     * @return
     */
    public Features searchByCategoryGroupDescription(String category, String group, String description, Token token) {

        String hostSent = service + "/" + category + "/" + group + "/" + description;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Features.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param category
     * @param group
     * @param description
     * @return
     */
    public Features searchByCategoryGroupDescription(String category, String group, String description) {
        return searchByCategoryGroupDescription(category, group, description, null);
    }

    /**
     *
     * @param category
     * @param lat
     * @param lng
     * @param rad
     * @param token
     * @return
     */
    public Features searchByCategory(String category, Double lat, Double lng, Double rad, Token token) {

        String hostSent = service + "/" + category + "/" + lat + "/" + lng + "/" + rad;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Features.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param category
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    public Features searchByCategory(String category, Double lat, Double lng, Double rad) {
        return searchByCategory(category, lat, lng, rad, null);
    }

    /**
     *
     * @param category
     * @param group
     * @param lat
     * @param lng
     * @param rad
     * @param token
     * @return
     */
    public Features searchByCategoryGroup(String category, String group, Double lat, Double lng, Double rad, Token token) {

        String hostSent = service + "/" + category + "/" + group + "/" + lat + "/" + lng + "/" + rad;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            return (new Gson().fromJson(resposta, Features.class));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param category
     * @param group
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    public Features searchByCategoryGroup(String category, String group, Double lat, Double lng, Double rad) {
        return searchByCategoryGroup(category, group, lat, lng, rad, null);
    }
}
