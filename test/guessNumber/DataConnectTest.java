// Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package guessNumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataConnectTest {
    
    public Connection con;
    
    public DataConnectTest() {
        System.out.println("getConnection");
     
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
     * Test of getConnection method, of class DataConnect.
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetConnection() throws SQLException {
        
        int timeout = 0;
            con.isValid(timeout);
        
    }

    /**
     * Test of close method, of class DataConnect.
     * @throws java.sql.SQLException
     */
    @Test
    public void testClose() throws SQLException {
        System.out.println("close");
      
        DataConnect.close(con);
        
        con.isClosed();
    }
    
}
