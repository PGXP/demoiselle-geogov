package org.demoiselle.jee.geogov.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author PauloGladson
 */
public class Ways implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Ways.class.getName());

    private Long id;
    private Integer vrs;
    private Date tstamp;
    private String description;
    private String group;
    private String linestring;
    private String tags;

    /**
     *
     */
    public Ways() {
    }

    /**
     *
     * @param id
     */
    public Ways(Long id) {
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
    public Integer getVrs() {
        return vrs;
    }

    /**
     *
     * @param vrs
     */
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
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
    public String getGroup() {
        return group;
    }

    /**
     *
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     *
     * @return
     */
    public Date getTstamp() {
        return tstamp;
    }

    /**
     *
     * @param tstamp
     */
    public void setTstamp(Date tstamp) {
        this.tstamp = tstamp;
    }

    /**
     *
     * @return
     */
    public String getLinestring() {
        return linestring;
    }

    /**
     *
     * @param linestring
     */
    public void setLinestring(String linestring) {
        this.linestring = linestring;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ways)) {
            return false;
        }
        Ways other = (Ways) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "org.demoiselle.geo.entity.sgdb.Ways[ id=" + id + " ]";
    }

}
