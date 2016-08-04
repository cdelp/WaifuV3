package guessNumber;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Masako
 */
@ManagedBean(name = "AttemptsBean")
@RequestScoped
public class AttemptsBean implements Serializable {

    // copied from login.java and changed first number from 1 to 2.
    private static final long serialVersionUID = 2094801825228386363L;
    
    HttpSession session = SessionUtils.getSession();
    String user = (String) session.getAttribute("username"); //logged in user's username
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private DataSource ds;

    //Clone this for grabbing traits on list, except do search on name.
    public List<Attempts> getAttemptsList() throws SQLException {
 
        con = DataConnect.getConnection();        
                
        List<Attempts> list = new ArrayList<Attempts>();

        ResultSet resInfo = null;
        //Only shows waifus associated with current username
        String sqlstatement = "SELECT * FROM WAIFUS WHERE USERNAME = '" + user + "'";
        
        try {
            ps = con.prepareStatement(sqlstatement);
            try { 
                resInfo = ps.executeQuery();
                while (resInfo.next()) {
                    Attempts att = new Attempts();

                    att.setEyes(resInfo.getInt("EYES"));
                    att.setFace(resInfo.getInt("FACE"));
                    att.setHair(resInfo.getInt("HAIR"));
                    att.setName(resInfo.getString("NAME"));
                    att.setOutfit(resInfo.getInt("OUTFIT"));
                    att.setGoodT1(resInfo.getInt("GOODT1"));
                    att.setGoodT2(resInfo.getInt("GOODT2"));
                    att.setGoodT3(resInfo.getInt("GOODT3"));
                    att.setBadT(resInfo.getInt("BADT"));

                    list.add(att);
                } 
            } finally {
                        ps.close();
                      } 
        }finally {
                con.close();
                }

        return list;
    }

    public List<Attempts> getTraits() throws SQLException {

        con = DataConnect.getConnection();
        
        List<Attempts> list = new ArrayList<Attempts>();

        ResultSet resInfo = null;
        String sqlstatement = "select * from WAIFUS where USERNAME = '" + user + "name = '";
        try {
            ps = con.prepareStatement(sqlstatement);
            try {

                resInfo = ps.executeQuery();
                while (resInfo.next()) {
                    Attempts att = new Attempts();

                    att.setEyes(resInfo.getInt("EYES"));
                    att.setFace(resInfo.getInt("FACE"));
                    att.setHair(resInfo.getInt("HAIR"));
                    att.setName(resInfo.getString("NAME"));
                    att.setOutfit(resInfo.getInt("OUTFIT"));
                    att.setGoodT1(resInfo.getInt("GOODT1"));
                    att.setGoodT2(resInfo.getInt("GOODT2"));
                    att.setGoodT3(resInfo.getInt("GOODT3"));
                    att.setBadT(resInfo.getInt("BADT"));

                    list.add(att);
                }
            } finally {
                        ps.close();
                      } 
        }finally {
                con.close();
                }
        return list;
    }

    /**
     * Creates a new instance of AttemptsBean
     */
    public AttemptsBean() {
    }

}
