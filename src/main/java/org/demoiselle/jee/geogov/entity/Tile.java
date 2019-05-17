package org.demoiselle.jee.geogov.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author 70744416353
 */
public class Tile implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Tile.class.getName());
    private Long id;
    private Integer zoom;
    private Integer coluna;
    private Integer linha;
    private Date datahora;
    private String tipo;
    private byte[] image;

    /**
     *
     */
    public Tile() {
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
    public Integer getZoom() {
        return zoom;
    }

    /**
     *
     * @param zoom
     */
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    /**
     *
     * @return
     */
    public Integer getColuna() {
        return coluna;
    }

    /**
     *
     * @param coluna
     */
    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    /**
     *
     * @return
     */
    public Integer getLinha() {
        return linha;
    }

    /**
     *
     * @param linha
     */
    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    /**
     *
     * @return
     */
    public Date getDatahora() {
        return datahora;
    }

    /**
     *
     * @param datahora
     */
    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    /**
     *
     * @return
     */
    public byte[] getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
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
        final Tile other = (Tile) obj;
        return Objects.equals(this.id, other.id);
    }

}
