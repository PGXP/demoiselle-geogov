package org.demoiselle.jee.geogov.consume;

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
    public void testGeocep() {

        String cep = "80520170";
        Token token = auth.login();
        Cep expResult = new Cep(843_140);
        List<Cep> result = instance.geocep(cep, token);
        assertEquals(expResult, result.get(0));
    }

}
