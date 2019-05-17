package org.demoiselle.jee.geogov.entity;

import java.io.Serializable;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author 70744416353
 */
public class Fts implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Fts.class.getName());

    private Long id;
    private String tags;
    private String geojson;

    /**
     *
     */
    public Fts() {
    }

    /**
     *
     * @param id
     */
    public Fts(Long id) {
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
    public String getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     */
    public String getGeojson() {
        return geojson;
    }

    /**
     *
     * @param geojson
     */
    public void setGeojson(String geojson) {
        this.geojson = geojson;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fts)) {
            return false;
        }
        Fts other = (Fts) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "org.demoiselle.geo.entity.Nodes[ id=" + id + " ]";
    }

}
