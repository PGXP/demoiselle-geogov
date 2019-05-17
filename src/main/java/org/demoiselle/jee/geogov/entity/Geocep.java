/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demoiselle.jee.geogov.entity;

import java.io.Serializable;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author PauloGladson
 */
public class Geocep implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Geocep.class.getName());
    private Long id;
    private String cep;
    private String numero;
    private Double latitude;
    private Double longitude;

    /**
     *
     */
    public Geocep() {
    }

    /**
     *
     * @param id
     */
    public Geocep(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geocep)) {
            return false;
        }
        Geocep other = (Geocep) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
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

        if (numero != null) {
            sb.append("numero=").append(numero).append("&");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "org.demoiselle.cep.entity.Geocep[ id=" + id + " ]";
    }

}
