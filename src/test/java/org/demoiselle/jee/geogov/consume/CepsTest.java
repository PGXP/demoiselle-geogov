package org.demoiselle.jee.geogov.consume;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.demoiselle.jee.geogov.entity.Cep;
import org.demoiselle.jee.geogov.security.Token;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiTestRunner.class)
public class CepsTest {

    @Inject
    private Ceps instance;

    @Inject
    private Auth auth;

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    public CepsTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of geocep method, of class Ceps.
     */
    @Test
    public void testGeocep_String_Token() {
        System.out.println("geocep");
        String cep = "80520170";
        Token token = auth.login();
        Cep expResult = new Cep(843_140);
        List<Cep> result = instance.geocep(cep, token);
        assertEquals(expResult, result.get(0));
    }

    /**
     * Test of queryString method, of class Ceps.
     */
    @Test
    public void testQueryString_String_Token() {
        System.out.println("queryString");
        String query = "?uf=PR&cidade=Curitiba";
        Token token = auth.login();
        List<Cep> result = instance.queryString(query, token);
        assertEquals(20, result.size());
    }

    /**
     * Test of searchByExample method, of class Ceps.
     */
    @Test
    public void testSearchByExample_Cep_Token() {
        System.out.println("searchByExample");
        String num = "80520170";
        Token token = auth.login();
        Cep cep = new Cep();
        cep.setCep(num);
        List<Cep> expResult = new ArrayList<>();
        expResult.add(cep);
        List<Cep> result = instance.searchByExample(cep, token);
        assertEquals(expResult.get(0).getCep(), result.get(0).getCep());
    }

}
