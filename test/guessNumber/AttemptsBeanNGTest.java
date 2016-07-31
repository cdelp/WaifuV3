package guessNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

/**
 * 
 * 
 * @author Cynthia Okuno, Christie Reidle, ChristopherDelp
 */


public class AttemptsBeanNGTest {
    
    Attempts att = new Attempts();
    private Connection con = DataConnect.getConnection();
    private PreparedStatement ps = null;
    
    public AttemptsBeanNGTest() {       
    }

    @BeforeClass
    public static void setUpClass() throws Exception {       
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getAttemptsList method, of class AttemptsBean.
     * Method should return a list of all waifus saved in DB.
     */
    @Test
    public void testGetAttemptsList() throws Exception {
        System.out.println("getAttemptsList");
        ps = con.prepareStatement("select * from WAIFUS");
        AttemptsBean instance = new AttemptsBean();
        List expResult = null; //all waifus?
        List result = instance.getAttemptsList();
        assertEquals(result, expResult);
    }

    /**
     * Test of getTraits method, of class AttemptsBean.
     */
    @Test
    public void testGetTraits() throws Exception {
        System.out.println("getTraits");
        AttemptsBean instance = new AttemptsBean();
        List expResult = null;
        List result = instance.getTraits();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
