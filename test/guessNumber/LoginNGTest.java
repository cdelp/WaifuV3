package guessNumber;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 *
 * @author Cynthia Okuno, Christie Reindle, ChristopherDelp
 */


public class LoginNGTest {
    
    Login instance = new Login();
    
    public LoginNGTest() {
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
     * Test of getPwd method, of class Login.
     */
    @Test(priority = 2)
    public void testGetPwd() {
        System.out.println("getPwd");
    //    Login instance = new Login();
        String expResult = "p@$$word";
        String result = instance.getPwd();
        assertEquals(result, expResult);
    }

    /**
     * Test of setPwd method, of class Login.
     */
    @Test(priority = 1)
    public void testSetPwd() {
        System.out.println("setPwd");
        String pwd = "p@$$word";
    //    Login instance = new Login();
        instance.setPwd(pwd);
    }

    /**
     * Test of getMsg method, of class Login.
     */
    @Test(priority = 6)
    public void testGetMsg() {
        System.out.println("getMsg");
    //    Login instance = new Login();
        String expResult = "m3$$ag3";
        String result = instance.getMsg();
        assertEquals(result, expResult);
    }

    /**
     * Test of setMsg method, of class Login.
     */
    @Test(priority = 5)
    public void testSetMsg() {
        System.out.println("setMsg");
        String msg = "m3$$ag3";
    //    Login instance = new Login();
        instance.setMsg(msg);        
    }

    /**
     * Test of getUser method, of class Login.
     */
    @Test(priority = 4)
    public void testGetUser() {
        System.out.println("getUser");
    //    Login instance = new Login();
        String expResult = "u$er";
        String result = instance.getUser();
        assertEquals(result, expResult);
    }

    /**
     * Test of setUser method, of class Login.
     */
    @Test(priority = 3)
    public void testSetUser() {
        System.out.println("setUser");
        String user = "u$er";
    //    Login instance = new Login();
        instance.setUser(user);
    }

    /**
     * Test of validateUsernamePassword method, of class Login.
     */
    @Test(priority = 7)
    public void testValidateUsernamePassword() {
        System.out.println("validateUsernamePassword");
        
        Login instance2 = new Login();
        instance2.setUser("Chadmin");
        instance2.setPwd("sadmin");
        
        String expResult = "index";
        String result = instance2.validateUsernamePassword();
        assertEquals(result, expResult);
    }

    /**
     * Test of createUsernamePassword method, of class Login.
     */
    @Test(priority = 8)
    public void testCreateUsernamePassword() {
        System.out.println("createUsernamePassword");
    //    Login instance = new Login();
        String expResult = "login";
        String result = instance.createUsernamePassword();
        assertEquals(result, expResult);
    }

    /**
     * Test of logout method, of class Login.
     */
    @Test(priority = 9)
    public void testLogout() {
        System.out.println("logout");
     //   Login instance = new Login();
        String expResult = "login";
        String result = instance.logout();
        assertEquals(result, expResult);
    }
    
}
