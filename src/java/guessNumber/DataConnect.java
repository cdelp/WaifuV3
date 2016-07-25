/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessNumber;

/**
 * Connects to our db
 * @author Masako
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

    public static Connection getConnection() {
        try {
            /* Edit the username whatever here */
            String dbURL = "jdbc:derby://localhost:1527/ics";
            String user = "DBUSER";
            String password = "ics";
            //hard coded connection password. Need to correct.
            Connection con = DriverManager.getConnection(dbURL, user, password);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->"
                    + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
