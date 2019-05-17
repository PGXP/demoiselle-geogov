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
 * @author 70744416353
 */
public class Layers implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Layers.class.getName());
    private Long id;
    private String layer;
    private String description;
    private String source;

    /**
     *
     */
    public Layers() {
    }

    /**
     *
     * @param id
     */
    public Layers(Long id) {
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
    public String getLayer() {
        return layer;
    }

    /**
     *
     * @param layer
     */
    public void setLayer(String layer) {
        this.layer = layer;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
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
        if (!(object instanceof Layers)) {
            return false;
        }
        Layers other = (Layers) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.demoiselle.geo.entity.sgdb.Layers[ id=" + id + " ]";
    }

}
