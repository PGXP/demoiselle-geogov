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
import org.demoiselle.jee.geogov.pojo.Features;
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
     * Test of fts method, of class Nodes.
     */
    @Test
    public void testFts_String_Token() {
        System.out.println("fts");
        String texto = "SERPRO";
        Token token = auth.login();
        Features result = instance.fts(texto, token);
        assertNotEquals(0, result.getFeatures().size());
    }

    /**
     * Test of searchByCategoryDescription method, of class Nodes.
     */
    @Test
    public void testSearchByCategoryDescription_3args() {
        System.out.println("searchByCategoryDescription");
        String category = "amenity";
        String description = "banco";
        Token token = auth.login();
        Features result = instance.searchByCategoryDescription(category, description, token);
        assertNotEquals(0, result.getFeatures().size());
    }

    /**
     * Test of searchByCategoryGroupDescription method, of class Nodes.
     */
    @Test
    public void testSearchByCategoryGroupDescription_4args() {
        System.out.println("searchByCategoryGroupDescription");
        String category = "amenity";
        String group = "atm";
        String description = "banco";
        Token token = auth.login();
        Features result = instance.searchByCategoryGroupDescription(category, group, description, token);
        assertNotEquals(0, result.getFeatures().size());
    }

    /**
     * Test of searchByCategory method, of class Nodes.
     */
    @Test
    public void testSearchByCategory_5args() {
        System.out.println("searchByCategory");
        String category = "amenity";
        Double lat = -25.414826529374;
        Double lng = -49.268403053283;
        Double rad = 14.0;
        Token token = auth.login();
        Features result = instance.searchByCategory(category, lat, lng, rad, token);
        assertNotEquals(0, result.getFeatures().size());
    }

    /**
     * Test of searchByCategoryGroup method, of class Nodes.
     */
    @Test
    public void testSearchByCategoryGroup_6args() {
        System.out.println("searchByCategoryGroup");
        String group = "atm";
        String category = "amenity";
        Double lat = -25.414826529374;
        Double lng = -49.268403053283;
        Double rad = 14.0;
        Token token = auth.login();
        Features result = instance.searchByCategoryGroup(category, group, lat, lng, rad, token);
        assertNotEquals(0, result.getFeatures().size());
    }

}
