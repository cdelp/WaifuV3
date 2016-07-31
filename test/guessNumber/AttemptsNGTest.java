package guessNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Class only has setters and getters, so testing not particularly useful.
 * 
 * @author Cynthia Okuno, Christie Reindle, ChristopherDelp
 */


public class AttemptsNGTest {
    
    private Connection con = DataConnect.getConnection();
    private PreparedStatement ps = null;
    Attempts instance = new Attempts();
    
    public AttemptsNGTest() {       
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
     * Test of getName method, of class Attempts.
     */
    @Test(priority = 11)
    public void testGetName() {
        System.out.println("getName");
       // Attempts instance = new Attempts();
        String expResult = "Test Name";
        String result = instance.getName();
        assertEquals(result, expResult);
    }

    /**
     * Test of setName method, of class Attempts.
     */
    @Test(priority = 1)
    public void testSetName() {
        System.out.println("setName");
        String name = "Test Name";
        //Attempts instance = new Attempts();
        instance.setName(name);
    }

    /**
     * Test of getHair method, of class Attempts.
     */
    @Test(priority = 12)
    public void testGetHair() {
        System.out.println("getHair");
       // Attempts instance = new Attempts();
        Integer expResult = 1;
        Integer result = instance.getHair();
        assertEquals(result, expResult);
    }

    /**
     * Test of setHair method, of class Attempts.
     */
    @Test(priority = 2)
    public void testSetHair() {
        System.out.println("setHair");
        Integer hair = 1;
        //Attempts instance = new Attempts();
        instance.setHair(hair);
    }

    /**
     * Test of getFace method, of class Attempts.
     */
    @Test(priority = 13)
    public void testGetFace() {
        System.out.println("getFace");
        //Attempts instance = new Attempts();
        Integer expResult = 1;
        Integer result = instance.getFace();
        assertEquals(result, expResult);
    }

    /**
     * Test of setFace method, of class Attempts.
     */
    @Test(priority = 3)
    public void testSetFace() {
        System.out.println("setFace");
        Integer face = 1;
        //Attempts instance = new Attempts();
        instance.setFace(face);
        
    }

    /**
     * Test of setEyes method, of class Attempts.
     */
    @Test(priority = 4)
    public void testSetEyes() {
        System.out.println("setEyes");
        Integer eyes = 1;
        //Attempts instance = new Attempts();
        instance.setEyes(eyes);
    }

    /**
     * Test of getEyes method, of class Attempts.
     */
    @Test(priority = 14)
    public void testGetEyes() {
        System.out.println("getEyes");
        //Attempts instance = new Attempts();
        Integer expResult = 1;
        Integer result = instance.getEyes();
        assertEquals(result, expResult);
    }

    /**
     * Test of setOutfit method, of class Attempts.
     */
    @Test(priority = 5)
    public void testSetOutfit() {
        System.out.println("setOutfit");
        Integer outfit = 1;
        //Attempts instance = new Attempts();
        instance.setOutfit(outfit);
        
    }

    /**
     * Test of getOutfit method, of class Attempts.
     */
    @Test(priority = 15)
    public void testGetOutfit() {
        System.out.println("getOutfit");
        //Attempts instance = new Attempts();
        Integer expResult = 1;
        Integer result = instance.getOutfit();
        assertEquals(result, expResult);
    }

    /**
     * Test of setGoodT1 method, of class Attempts.
     */
    @Test(priority = 6)
    public void testSetGoodT1() {
        System.out.println("setGoodT1");
        Integer goodt1 = 1;
        //Attempts instance = new Attempts();
        instance.setGoodT1(goodt1);
    }

    /**
     * Test of getGoodT1 method, of class Attempts.
     */
    @Test(priority = 16)
    public void testGetGoodT1() {
        System.out.println("getGoodT1");
        //Attempts instance = new Attempts();
        Integer expResult = 1;
        Integer result = instance.getGoodT1();
        assertEquals(result, expResult);
    }

    /**
     * Test of setGoodT2 method, of class Attempts.
     */
    @Test(priority = 8)
    public void testSetGoodT2() {
        System.out.println("setGoodT2");
        Integer goodt2 = 2;
        //Attempts instance = new Attempts();
        instance.setGoodT2(goodt2);
    }

    /**
     * Test of getGoodT2 method, of class Attempts.
     */
    @Test(priority = 17)
    public void testGetGoodT2() {
        System.out.println("getGoodT2");
        //Attempts instance = new Attempts();
        Integer expResult = 2;
        Integer result = instance.getGoodT2();
        assertEquals(result, expResult);
    }

    /**
     * Test of setGoodT3 method, of class Attempts.
     */
    @Test(priority = 9)
    public void testSetGoodT3() {
        System.out.println("setGoodT3");
        Integer goodt3 = 3;
        //Attempts instance = new Attempts();
        instance.setGoodT3(goodt3);
    }

    /**
     * Test of getGoodT3 method, of class Attempts.
     */
    @Test(priority = 18)
    public void testGetGoodT3() {
        System.out.println("getGoodT3");
        //Attempts instance = new Attempts();
        Integer expResult = 3;
        Integer result = instance.getGoodT3();
        assertEquals(result, expResult);
    }

    /**
     * Test of setBadT method, of class Attempts.
     */
    @Test(priority = 10)
    public void testSetBadT() {
        System.out.println("setBadT");
        Integer badt = 1;
        //Attempts instance = new Attempts();
        instance.setBadT(badt);
    }

    /**
     * Test of getBadT method, of class Attempts.
     */
    @Test(priority = 19)
    public void testGetBadT() {
        System.out.println("getBadT");
        //Attempts instance = new Attempts();
        Integer expResult = 1;
        Integer result = instance.getBadT();
        assertEquals(result, expResult);
        
    }
    
}
