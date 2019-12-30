/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demoiselle.jee.geogov.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author gladson
 */
public class Cep implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Cep.class.getName());
    private Integer id;
    private String logradouro;
    private String cep;
    private String uf;
    private String cidade;
    private String bairroIni;
    private String bairroFim;
    private List<Geocep> geo;

    /**
     *
     */
    public Cep() {
    }

    /**
     *
     * @param id
     */
    public Cep(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     *
     * @param logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     *
     * @return
     */
    public String getCep() {
        return cep;
    }

    /**
     *
     * @param cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     *
     * @return
     */
    public String getUf() {
        return uf;
    }

    /**
     *
     * @param uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     *
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return
     */
    public String getBairroIni() {
        return bairroIni;
    }

    /**
     *
     * @param bairroIni
     */
    public void setBairroIni(String bairroIni) {
        this.bairroIni = bairroIni;
    }

    /**
     *
     * @return
     */
    public String getBairroFim() {
        return bairroFim;
    }

    /**
     *
     * @param bairroFim
     */
    public void setBairroFim(String bairroFim) {
        this.bairroFim = bairroFim;
    }

    /**
     *
     * @return
     */
    public List<Geocep> getGeo() {
        return Collections.unmodifiableList(geo);
    }

    /**
     *
     * @param geo
     */
    public void setGeo(List<Geocep> geo) {
        this.geo = geo;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cep other = (Cep) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    public String toQueryString() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");

        if (cep != null) {
            sb.append("cep=").append(cep).append("&");
        }

        if (logradouro != null) {
            sb.append("logradouro=").append(logradouro).append("&");
        }

        if (uf != null) {
            sb.append("uf=").append(uf).append("&");
        }

        if (cidade != null) {
            sb.append("cidade=").append(cidade).append("&");
        }

        if (bairroIni != null) {
            sb.append("bairroIni=").append(bairroIni).append("&");
        }

        if (bairroFim != null) {
            sb.append("bairroFim=").append(bairroFim).append("&");
        }

        return sb.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "app.entity.Cep[ id=" + id + " ]";
    }

}
