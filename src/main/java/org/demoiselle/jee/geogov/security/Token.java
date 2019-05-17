
package org.demoiselle.jee.geogov.security;

import java.util.logging.Logger;

/**
 *
 * @author 70744416353
 */
public class Token {

    private String key;
    private String type;

    /**
     *
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

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

    @Override
    public String toString() {
        return "Token{" + "token=" + key + ", type=" + type + '}';
    }
    private static final Logger LOG = Logger.getLogger(Token.class.getName());

}
