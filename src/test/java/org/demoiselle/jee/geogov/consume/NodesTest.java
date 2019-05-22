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
public class NodesTest {

    @Inject
    private Nodes instance;

    @Inject
    private Auth auth;

    public NodesTest() {
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
     * Test of getGroups method, of class Nodes.
     */
    @Test
    public void testGetGroups_String_Token() {
        System.out.println("getGroups");
        String group = "amenity";
        Token token = auth.login();
        List result = instance.getGroups(group, token);
        assertNotEquals(0, result.size());
    }

    /**
     * Test of getGroups method, of class Nodes.
     */
    @Test
    public void testGetGroups_String() {
        System.out.println("getGroups");
        String group = "amenity";
        List<String> expResult = new ArrayList<>();
        List result = instance.getGroups(group);
        assertNotEquals(expResult.size(), result.size());
    }

    /**
     * Test of getCategorys method, of class Nodes.
     */
    @Test
    public void testGetCategorys_Token() {
        System.out.println("getCategorys");
        Token token = auth.login();
        List expResult = new ArrayList<>();
        List result = instance.getCategorys(token);
        assertNotEquals(expResult.size(), result.size());
    }

    /**
     * Test of getCategorys method, of class Nodes.
     */
    @Test
    public void testGetCategorys() {
        System.out.println("getCategorys");
        List expResult = new ArrayList<>();
        List result = instance.getCategorys();
        assertNotEquals(expResult.size(), result.size());
    }

    /**
     * Test of getSummary method, of class Nodes.
     */
    @Test
    public void testGetSummary_Token() {
        System.out.println("getSummary");
        Token token = auth.login();
        List expResult = new ArrayList<>();
        List result = instance.getSummary(token);
        assertNotEquals(expResult.size(), result.size());
    }

    /**
     * Test of getSummary method, of class Nodes.
     */
    @Test
    public void testGetSummary() {
        System.out.println("getSummary");
        List expResult = new ArrayList<>();
        List result = instance.getSummary();
        assertNotEquals(expResult.size(), result.size());
    }

}
