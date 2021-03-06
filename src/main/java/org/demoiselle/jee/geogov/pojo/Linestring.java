/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demoiselle.jee.geogov.pojo;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author PauloGladson
 */
public class Linestring {

    private static final Logger LOG = getLogger(Linestring.class.getName());

    private String type;
    private Double[][] coordinates;

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Double[][] getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @param coordinates
     */
    public void setCoordinates(Double[][] coordinates) {
        this.coordinates = coordinates;
    }

}
