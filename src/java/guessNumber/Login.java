/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 Using http://www.journaldev.com/7252/jsf-authentication-login-logout-database-example 
 And also https://platform.netbeans.org/tutorials/60/nbm-login.html for the md5 hash code

A bunch of getters and setters (for now)
When registration is implemented, we will need to change some things. 
 */
package guessNumber;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import guessNumber.LoginDAO;
import guessNumber.SessionUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    //I honestly don't know what this is for. This is just copied for now until we need to modify this for md5 hashing, which will come later
    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "index"; // changed this from "admin"
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }
    
    // ************************* UID needs to be figured out *******************************
    //create new user login
    public String createUsernamePassword() {
        
        Connection con = null;
        PreparedStatement ps = null;
               
        try {
            con = DataConnect.getConnection();  
            
            // failed attempt to check for username's existence before allowing another user
            // to use add the same one to the db
            ps = con.prepareStatement("SELECT USERNAME from Users where USERNEAME = ?");
            try {
                ps.setString(1, user);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    //result found, means username already exists
                    FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "User name already exists",
                            "Please choose another user name"));
                    return "login";
                }
                } finally {
                    ps.close();
                }
        
                    ps = con.prepareStatement("INSERT INTO USERS VALUES (?, ?, ?)");
                    try {
                        // not adding to db consistently. Sometimes adds, sometimes doesn't.
                        // set UID
                        ps.setInt(1, 666); // don't want hard coded int, need to figure out way to set UID
                        // set username
                        ps.setString(2, user); 
                        // set password
                        ps.setString(3, pwd); 

                        ps.execute();   

                    } finally {
                        ps.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Login error -->" + ex.getMessage());

                } finally {
                    DataConnect.close(con);
                }

                return "login";
    }
    
    // ************************* end not working *******************************

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }

    //This will be used at a later date, along with the md5 hashing
    private static String byteArrToString(byte[] b) {
        String res = null;
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int j = b[i] & 0xff;
            if (j < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(j));
        }
        res = sb.toString();
        return res.toUpperCase();
    }

    /* Commented out for now. This will be implemented for registration
    Sets passwords to md5 hash (in theory)
    
     String passwordMD5 = null;
     MessageDigest md5;
     try {
     md5 = MessageDigest.getInstance("MD5");
     byte[] tmp = pwd.getBytes();
     md5.update(tmp);
     passwordMD5 = byteArrToString(md5.digest());
     this.pwd = passwordMD5;
     } catch (NoSuchAlgorithmException ex) {
     Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
     }              
     */
}
