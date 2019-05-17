/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demoiselle.jee.geogov.consume;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.demoiselle.jee.geogov.entity.Geocep;
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
public class GeocepsTest {

    @Inject
    private Auth auth;

    @Inject
    private Geoceps instance;

    public GeocepsTest() {
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
     * Test of geocep method, of class Geoceps.
     */
    @Test
    public void testGeocep_String_Token() {
        System.out.println("geocep");
        String cep = "80520170";
        Token token = auth.login();
        Geocep geocep = new Geocep();
        geocep.setCep(cep);
        List<Geocep> expResult = new ArrayList<>();
        expResult.add(geocep);
        List<Geocep> result = instance.geocep(cep, token);
        assertEquals(expResult.get(0).getCep(), result.get(0).getCep());
    }

    /**
     * Test of queryString method, of class Geoceps.
     */
    @Test
    public void testQueryString_String_Token() {
        System.out.println("queryString");
        String cep = "80520170";
        Token token = auth.login();
        Geocep geocep = new Geocep();
        geocep.setCep(cep);
        List<Geocep> expResult = new ArrayList<>();
        expResult.add(geocep);
        List<Geocep> result = instance.queryString("?cep=80520170", token);
        assertEquals(expResult.get(0).getCep(), result.get(0).getCep());
    }

    /**
     * Test of searchByExample method, of class Geoceps.
     */
    @Test
    public void testSearchByExample_Geocep_Token() {
        System.out.println("searchByExample");
        String cep = "80520170";
        Token token = auth.login();
        Geocep geocep = new Geocep();
        geocep.setCep(cep);
        List<Geocep> expResult = new ArrayList<>();
        expResult.add(geocep);
        List<Geocep> result = instance.searchByExample(geocep, token);
        assertEquals(expResult.get(0).getCep(), result.get(0).getCep());
    }

}
