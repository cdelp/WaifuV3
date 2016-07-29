// Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package guessNumber;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; //reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
//package guessNumber;

import static org.testng.Assert.*;

/**
 *
 * @author cdmm
 */


public class LoginNGTest {
    
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
    @Test
    public void testGetPwd() {
        System.out.println("getPwd");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getPwd();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPwd method, of class Login.
     */
    @Test
    public void testSetPwd() {
        System.out.println("setPwd");
        String pwd = "";
        Login instance = new Login();
        instance.setPwd(pwd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMsg method, of class Login.
     */
    @Test
    public void testGetMsg() {
        System.out.println("getMsg");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getMsg();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMsg method, of class Login.
     */
    @Test
    public void testSetMsg() {
        System.out.println("setMsg");
        String msg = "";
        Login instance = new Login();
        instance.setMsg(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Login.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getUser();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Login.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        Login instance = new Login();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateUsernamePassword method, of class Login.
     */
    @Test
    public void testValidateUsernamePassword() {
        System.out.println("validateUsernamePassword");
        Login instance = new Login();
        String expResult = "";
        String result = instance.validateUsernamePassword();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUsernamePassword method, of class Login.
     */
    @Test
    public void testCreateUsernamePassword() {
        System.out.println("createUsernamePassword");
        Login instance = new Login();
        String expResult = "";
        String result = instance.createUsernamePassword();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Login.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Login instance = new Login();
        String expResult = "";
        String result = instance.logout();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
