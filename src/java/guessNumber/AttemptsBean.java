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
import javax.sql.DataSource;

/**
 *
 * @author Masako
 */
@ManagedBean(name = "AttemptsBean")
@RequestScoped
public class AttemptsBean implements Serializable {

    @Resource(name = "jdbc:derby://localhost:1527/ics")
    private DataSource ds;

    //Clone this for grabbing traits on list, except do search on name.
    public List<Attempts> getAttemptsList() throws SQLException {
        String dbURL = "jdbc:derby://localhost:1527/ics";
        String user = "DBUSER";
        String password = "ics";

        if (ds == null) {
            throw new SQLException("Cannot get data source");
        }
        //hard coded password. needs to be corrected
        //need to close connection afterward
        //see DataConnect file for example
        Connection con = DriverManager.getConnection(dbURL, user, password);
        //  : Connections select statement

        List<Attempts> list = new ArrayList<Attempts>();
        PreparedStatement ps;
        ResultSet resInfo = null;
        String sqlstatement = "select * from WAIFUS";
        ps = con.prepareStatement(sqlstatement);
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
        return list;
    }

    public List<Attempts> getTraits() throws SQLException {
        String dbURL = "jdbc:derby://localhost:1527/ics";
        String user = "DBUSER";
        String password = "ics";

        if (ds == null) {
            throw new SQLException("Cannot get data source");
        }
        //hard coded connection password. Need to correct.
        // need to close connection afterward.
        //see DataConnect file for example
        Connection con = DriverManager.getConnection(dbURL, user, password);
        //  : Connections select statement

        List<Attempts> list = new ArrayList<Attempts>();
        PreparedStatement ps;
        ResultSet resInfo = null;
        String sqlstatement = "select * from WAIFUS where name = ";
        ps = con.prepareStatement(sqlstatement);
        // may need to close/clean up, per FindBugs
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
        return list;
    }

    /**
     * Creates a new instance of AttemptsBean
     */
    public AttemptsBean() {
    }

}
