/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demoiselle.jee.geogov.consume;

import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.demoiselle.jee.geogov.entity.Ip2location;
import org.demoiselle.jee.geogov.security.Token;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author 70744416353
 */
@RunWith(CdiTestRunner.class)
public class Ip2locationTest {

    @Inject
    private Ip2locations instance;

    @Inject
    private Auth auth;

    public Ip2locationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of searchByIP method, of class Ip2location.
     */
    @Test
    public void testSearchByIP_String_Token() {
        System.out.println("searchByIP");
        String ip = "200.200.200.200";
        Token token = auth.login();
        Ip2location expResult = new Ip2location();
        expResult.setIp("200.200.200.200");
        Ip2location result = instance.searchByIP(ip, token);
        assertEquals(expResult.getIp(), result.getIp());
    }

    /**
     * Test of searchByMyIp method, of class Ip2location.
     */
    @Test
    public void testSearchByMyIp_Token() {
        System.out.println("searchByMyIp");
        Token token = auth.login();
        Ip2location expResult = new Ip2location();
        expResult.setIp("127.0.0.1");
        Ip2location result = instance.searchByMyIp(token);
        assertEquals(expResult.getIp(), result.getIp());
    }

}
