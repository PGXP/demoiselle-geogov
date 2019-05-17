/*
 * Demoiselle Framework
 *
 * License: GNU Lesser General Public License (LGPL), version 3 or later.
 * See the lgpl.txt file in the root directory or <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.demoiselle.jee.geogov;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;
import org.demoiselle.jee.configuration.annotation.Configuration;
import org.demoiselle.jee.configuration.annotation.ConfigurationSuppressLogger;

/**
 *
 * @author SERPRO
 */
@Configuration(prefix = "demoiselle.geogov")
public class DemoiselleGeoGovConfig implements Serializable {

    private static final Logger LOG = Logger.getLogger(DemoiselleGeoGovConfig.class.getName());

    @ConfigurationSuppressLogger
    private String username;

    @ConfigurationSuppressLogger
    private String password;

    private String url;

    private boolean disableTrustCerts;

    private Map<String, String> properties;

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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

    /**
     *
     * @return
     */
    public boolean isDisableTrustCerts() {
        return disableTrustCerts;
    }

    /**
     *
     * @param disableTrustCerts
     */
    public void setDisableTrustCerts(boolean disableTrustCerts) {
        this.disableTrustCerts = disableTrustCerts;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     *
     * @param properties
     */
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

}
