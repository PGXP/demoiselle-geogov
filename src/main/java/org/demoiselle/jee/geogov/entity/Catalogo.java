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
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = getLogger(Catalogo.class.getName());

    private String nome;
    private String descricao;
    private String url;

    /**
     *
     */
    public Catalogo() {
    }

    /**
     *
     * @param nome
     */
    public Catalogo(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param nome
     * @param descricao
     * @param url
     */
    public Catalogo(String nome, String descricao, String url) {
        this.nome = nome;
        this.descricao = descricao;
        this.url = url;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        return !((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome)));
    }

    @Override
    public String toString() {
        return "org.demoiselle.geo.entity.sgdb.Catalogo[ nome=" + nome + " ]";
    }

}
