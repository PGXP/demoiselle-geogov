package org.demoiselle.jee.geogov.consume;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.demoiselle.jee.core.exception.DemoiselleException;
import org.demoiselle.jee.geogov.entity.Cep;
import org.demoiselle.jee.geogov.security.Token;

/**
 *
 * @author 70744416353
 */
public class Ceps {

    private static final Logger LOG = Logger.getLogger(Ceps.class.getName());

    private String service = "api/ceps";

    @Inject
    private Util util;

    /**
     *
     * @param cep
     * @param token
     * @return
     */
    public List<Cep> geocep(String cep, Token token) {

        String hostSent = service + "/geo/" + cep;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Cep>>() {
            }.getType();
            return (new Gson().fromJson(resposta, listType));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param cep
     * @return
     */
    public List<Cep> geocep(String cep) {
        return geocep(cep, null);
    }

    /**
     *
     * @param query
     * @param token
     * @return
     */
    public List<Cep> queryString(String query, Token token) {

        String hostSent = service + query;
        String resposta = util.doGET(hostSent, token);

        if (resposta != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Cep>>() {
            }.getType();
            return (new Gson().fromJson(resposta, listType));
        } else {
            throw new DemoiselleException("Serviço indisponível");
        }

    }

    /**
     *
     * @param query
     * @return
     */
    public List<Cep> queryString(String query) {
        return queryString(query, null);
    }

    /**
     *
     * @param cep
     * @param token
     * @return
     */
    public List<Cep> searchByExample(Cep cep, Token token) {
        return queryString(cep.toQueryString(), token);
    }

    /**
     *
     * @param cep
     * @return
     */
    public List<Cep> searchByExample(Cep cep) {
        return queryString(cep.toQueryString(), null);
    }

}
