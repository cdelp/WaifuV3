package guessNumber;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Tests adding new waifu to table.
 * 
 * @author Cynthia Okuno, Christie Reidle, ChristopherDelp
 */

public class UserNumberBeanNGTest {
    
    UserNumberBean instance = new UserNumberBean();
    
    public UserNumberBeanNGTest() {
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
     * Test of getResponse method, of class UserNumberBean.
     * should insert new waifu into table and return string.
     * @throws java.lang.Exception
     */
    @Test(priority = 1)
    public void testGetResponse() throws Exception {
        System.out.println("getResponse");
       // UserNumberBean instance = new UserNumberBean();
        String expResult = "Look at your beautiful waifu!";
        String result = instance.getResponse();
        assertEquals(result, expResult);        
    }

    /**
     * Test of getUserNumber method, of class UserNumberBean.
     */
    @Test(priority = 3)
    public void testGetUserNumber() {
        System.out.println("getUserNumber");
       // UserNumberBean instance = new UserNumberBean();
        String expResult = "waifUnit";
        String result = instance.getUserNumber();
        assertEquals(result, expResult);
    }

    /**
     * Test of setUserNumber method, of class UserNumberBean.
     */
    @Test(priority = 2)
    public void testSetUserNumber() {
        System.out.println("setUserNumber");
        String name = "waifUnit";
    //    UserNumberBean instance = new UserNumberBean();
        instance.setUserNumber(name);
    }

    /**
     * Test of getUserHair method, of class UserNumberBean.
     */
    @Test(priority = 5)
    public void testGetUserHair() {
        System.out.println("getUserHair");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "hair/1.png";
        String result = instance.getUserHair();
        assertEquals(result, expResult);
    }

    /**
     * Test of setUserHair method, of class UserNumberBean.
     */
    @Test(priority = 4)
    public void testSetUserHair() {
        System.out.println("setUserHair");
        Integer hair = 1;
     //   UserNumberBean instance = new UserNumberBean();
        instance.setUserHair(hair);
    }

    /**
     * Test of getUserFace method, of class UserNumberBean.
     */
    @Test(priority = 7)
    public void testGetUserFace() {
        System.out.println("getUserFace");
      //  UserNumberBean instance = new UserNumberBean();
        String expResult = "face/1.png";
        String result = instance.getUserFace();
        assertEquals(result, expResult);
    }

    /**
     * Test of setUserFace method, of class UserNumberBean.
     */
    @Test(priority = 6)
    public void testSetUserFace() {
        System.out.println("setUserFace");
        Integer face = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setUserFace(face);
    }

    /**
     * Test of getUserEyes method, of class UserNumberBean.
     */
    @Test(priority = 9)
    public void testGetUserEyes() {
        System.out.println("getUserEyes");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "eyes/1.png";
        String result = instance.getUserEyes();
        assertEquals(result, expResult);
    }

    /**
     * Test of setUserEyes method, of class UserNumberBean.
     */
    @Test(priority = 8)
    public void testSetUserEyes() {
        System.out.println("setUserEyes");
        Integer eyes = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setUserEyes(eyes);
    }

    /**
     * Test of getUserOutfit method, of class UserNumberBean.
     */
    @Test(priority = 11)
    public void testGetUserOutfit() {
        System.out.println("getUserOutfit");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "outfit/1.png";
        String result = instance.getUserOutfit();
        assertEquals(result, expResult);
    }

    /**
     * Test of setUserOutfit method, of class UserNumberBean.
     */
    @Test(priority = 10)
    public void testSetUserOutfit() {
        System.out.println("setUserOutfit");
        Integer outfit = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setUserOutfit(outfit);
    }

    /**
     * Test of setGoodT1 method, of class UserNumberBean.
     */
    @Test(priority = 12)
    public void testSetGoodT1() {
        System.out.println("setGoodT1");
        Integer goodt1 = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setGoodT1(goodt1);
    }

    /**
     * Test of getGoodT1 method, of class UserNumberBean.
     */
    @Test(priority = 13)
    public void testGetGoodT1() {
        System.out.println("getGoodT1");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "Will share spaghetti.";
        String result = instance.getGoodT1();
        assertEquals(result, expResult);
    }

    /**
     * Test of setGoodT2 method, of class UserNumberBean.
     */
    @Test(priority = 14)
    public void testSetGoodT2() {
        System.out.println("setGoodT2");
        Integer goodt2 = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setGoodT2(goodt2);
    }

    /**
     * Test of getGoodT2 method, of class UserNumberBean.
     */
    @Test(priority = 15)
    public void testGetGoodT2() {
        System.out.println("getGoodT2");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "Able to rap freestyle.";
        String result = instance.getGoodT2();
        assertEquals(result, expResult);
    }

    /**
     * Test of setGoodT3 method, of class UserNumberBean.
     */
    @Test(priority = 16)
    public void testSetGoodT3() {
        System.out.println("setGoodT3");
        Integer goodt3 = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setGoodT3(goodt3);
    }

    /**
     * Test of getGoodT3 method, of class UserNumberBean.
     */
    @Test(priority = 17)
    public void testGetGoodT3() {
        System.out.println("getGoodT3");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "Likes to draw.";
        String result = instance.getGoodT3();
        assertEquals(result, expResult);
    }

    /**
     * Test of setBadT method, of class UserNumberBean.
     */
    @Test(priority = 18)
    public void testSetBadT() {
        System.out.println("setBadT");
        Integer badt = 1;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setBadT(badt);
    }

    /**
     * Test of getBadT method, of class UserNumberBean.
     */
    @Test(priority = 19)
    public void testGetBadT() {
        System.out.println("getBadT");
    //    UserNumberBean instance = new UserNumberBean();
        String expResult = "Scared of cotton balls.";
        String result = instance.getBadT();
        assertEquals(result, expResult);
    }

    /**
     * Test of UserNumberBean method, of class UserNumberBean.
     */
    @Test
    public void testUserNumberBean() {
        System.out.println("UserNumberBean");
    //    UserNumberBean instance = new UserNumberBean();
        instance.UserNumberBean();
    }

    /**
     * Test of setWaifu method, of class UserNumberBean.
     */
    @Test
    public void testSetWaifu() {
        System.out.println("setWaifu");
        String name = "setWaifUint";
        Integer hair = 3;
        Integer eyes = 3;
        Integer face = 3;
        Integer outfit = 3;
    //    UserNumberBean instance = new UserNumberBean();
        instance.setWaifu(name, hair, eyes, face, outfit);
    }
    
}
