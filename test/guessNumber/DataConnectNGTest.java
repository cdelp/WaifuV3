package guessNumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;//reading included file Templates/UnitTests/Templates/Licenses/license-default.txt

/**
 * Tests database connection opening and closing.
 * 
 * @author Cynthia Okuno, Christie Reidle, ChristopherDelp
 */

public class DataConnectNGTest {
    
    public Connection con;
    
    @Test(priority = 1)
    public DataConnectNGTest() {
        System.out.println("Open connection");
     
            String dbURL = "jdbc:derby://localhost:1527/ics";
            String user = "DBUSER";
            String password = "ics";
        
            con = null;
        try {
            con = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DataConnectTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of getConnection method, of class DataConnect.
     * @throws java.sql.SQLException
     */
    @Test(priority = 2)
    public void testGetConnection() throws SQLException {
        System.out.println("test connection");
        int timeout = 0;
            con.isValid(timeout);
    }

    /**
     * Test of close method, of class DataConnect.
     * @throws java.sql.SQLException
     */
    @Test(priority = 3)
    public void testClose() throws SQLException {
        System.out.println("close connection");
        DataConnect.close(con);
        
        con.isClosed();
        
    }
    
}
