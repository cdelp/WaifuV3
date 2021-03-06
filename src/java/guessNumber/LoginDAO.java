/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 Validates logins
 */
package guessNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import guessNumber.DataConnect;

public class LoginDAO {

    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();          
            ps = con.prepareStatement("Select USERNAME, Password from Users where USERNAME = ? and password = ?");
            try {
                ps.setString(1, user);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    //result found, means valid inputs
                    return true;
                }
            } finally {
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
}
