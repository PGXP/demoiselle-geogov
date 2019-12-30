/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demoiselle.jee.geogov.consume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import static javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier;
import static javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory;
import javax.net.ssl.SSLContext;
import static javax.net.ssl.SSLContext.getInstance;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import org.demoiselle.jee.core.exception.DemoiselleException;
import org.demoiselle.jee.geogov.DemoiselleGeoGovConfig;
import org.demoiselle.jee.geogov.security.Token;

/**
 *
 * @author PauloGladson
 */
@RequestScoped
public class Util {

    @Inject
    private DemoiselleGeoGovConfig config;

    /**
     *
     * @param uri
     * @param token
     * @return
     */
    public String doGET(String uri, Token token) {
        try {

            if (config.isDisableTrustCerts()) {
                disableTrustCerts();
            }

            URL url = new URL(config.getUrl() + uri);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            config.getProperties().entrySet().forEach((en) -> {
                connection.setRequestProperty(en.getKey(), en.getValue());
            });

            if (token != null) {
                connection.setRequestProperty("Authorization", token.getType() + " " + token.getKey());
            }

            if (config.getGatewayKey() != null && !config.getGatewayKey().isEmpty()) {
                connection.setRequestProperty("x-demoiselle-gateway-token", config.getGatewayKey());
            }

            connection.setDoOutput(true);
            connection.setUseCaches(true);

            connection.connect();

            StringBuilder response = new StringBuilder();

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            connection.disconnect();

            if (connection.getResponseCode() == 200 || connection.getResponseCode() == 206) {
                return response.toString();
            } else {
                throw new DemoiselleException(" Serviço retornou " + connection.getResponseCode() + " - " + url.toString());
            }

        } catch (ProtocolException ex) {
            Logger.getLogger(Ceps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ceps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param uri
     * @param body
     * @param token
     * @return
     */
    public String doPOST(String uri, String body, Token token) {
        try {

            if (config.isDisableTrustCerts()) {
                disableTrustCerts();
            }

            URL url = new URL(config.getUrl() + uri);

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            config.getProperties().entrySet().forEach((en) -> {
                connection.setRequestProperty(en.getKey(), en.getValue());
            });

            if (token != null) {
                connection.setRequestProperty("Authorization", token.getType() + " " + token.getKey());
            }

            connection.setDoOutput(true);
            connection.setUseCaches(true);

            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(body);

            connection.connect();

            StringBuilder response = new StringBuilder();

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            if (connection.getResponseCode() == 200) {
                connection.disconnect();
                return response.toString();
            } else {
                throw new DemoiselleException(" Serviço retornou " + connection.getResponseCode() + " - " + url.toString() + " <-> " + response.toString());
            }

        } catch (ProtocolException ex) {
            Logger.getLogger(Ceps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ceps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Util() {
    }

    /**
     *
     */
    public void disableTrustCerts() {

        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509ExtendedTrustManager() {

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] xcs, String string, Socket socket) throws java.security.cert.CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] xcs, String string, Socket socket) throws java.security.cert.CertificateException {

                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] xcs, String string, SSLEngine ssle) throws java.security.cert.CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] xcs, String string, SSLEngine ssle) throws java.security.cert.CertificateException {

                    }

                }
            };

            SSLContext sc = getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = (String hostname, SSLSession session) -> true;
            // Install the all-trusting host verifier
            setDefaultHostnameVerifier(allHostsValid);
            /*
     * end of the fix
             */
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            getLogger(Auth.class.getName()).log(SEVERE, null, e);
        }
    }
}
