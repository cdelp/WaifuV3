package guessNumber;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Masako
 */
@ManagedBean(name = "UserNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable {

    // copied from login.java and changed first number from 1 to 3.
    private static final long serialVersionUID = 3094801825228386363L;
    
    Connection con = null;
    PreparedStatement ps = null;
    
    String userNumber; //Name
    Integer hair;
    Integer face;
    Integer eyes;
    Integer outfit;
    String response;
    Integer goodt1, goodt2, goodt3, badt;

    Integer randomInt1, randomInt2, randomInt3, randomInt4;

    // inserts new waifu into waifus table
    public String getResponse() throws SQLException {

        con = DataConnect.getConnection();

        Random randomGR = new Random();
        randomInt1 = randomGR.nextInt(5);
        randomInt2 = randomGR.nextInt(5);
        randomInt3 = randomGR.nextInt(5);
        randomInt4 = randomGR.nextInt(5);

        setGoodT1(randomInt1);
        setGoodT2(randomInt2);
        setGoodT3(randomInt3);
        setBadT(randomInt4);

        try {
            ps = con.prepareStatement("insert into WAIFUS VALUES (?,?,?,?,?,?,?,?,?)");
            try {
                //name hair face hat outfit eyes
                if (userNumber == null) {
                    ps.setString(1, "waifu");
                } else {
                    ps.setString(1, userNumber);
                }
                if (hair == null) {
                    ps.setInt(2, 1);
                } else {
                    ps.setInt(2, hair);
                }
                if (face == null) {
                    ps.setInt(3, 1);
                } else {
                    ps.setInt(3, face);
                }
                if (outfit == null) {
                    ps.setInt(4, 1);
                } else {
                    ps.setInt(4, outfit);
                }
                if (eyes == null) {
                    ps.setInt(5, 1);
                } else {

                    ps.setInt(5, eyes);
                }
                ps.setInt(6, randomInt1);
                ps.setInt(7, randomInt2);
                ps.setInt(8, randomInt3);
                ps.setInt(9, randomInt4);

                // need to confirm whether this needs to be assigned to a variable. 
                boolean execute = ps.execute();
            } finally {
                        ps.close();
                      } 
        }finally {
                con.close();
                }
            
        return "Look at your beautiful waifu!";
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String name) {
        this.userNumber = name;
    }

    //Change these to query the images.
    public String getUserHair() {
        return "hair/" + this.hair + ".png";
    }

    public void setUserHair(Integer hair) {
        this.hair = hair;
    }

    public String getUserFace() {
        return "face/" + this.face + ".png";
    }

    public void setUserFace(Integer face) {

        this.face = face;
    }

    public String getUserEyes() {
        return "eyes/" + eyes + ".png";
    }

    public void setUserEyes(Integer eyes) {
        this.eyes = eyes;
    }

    public String getUserOutfit() {
        return "outfit/" + this.outfit + ".png";
    }

    public void setUserOutfit(Integer outfit) {
        this.outfit = outfit;
    }

    public void setGoodT1(Integer goodt1) {
        this.goodt1 = goodt1;
    }

    public String getGoodT1() {
        // "field never initialized within any constructor but derefereced without null check" warning per FindBugs
        switch (this.goodt1) {
            case 0:
                return "Likes to clean.";
            case 1:
                return "Will share spaghetti.";
            case 2:
                return "Dances like Michael Jackson.";
            case 3:
                return "Cleans up chip crumbs for you. ";
            case 4:
                return "Is actually the best.";
        }
        return "error";
    }

    //New stuff. Traits! 
    public void setGoodT2(Integer goodt2) {
        this.goodt2 = goodt2;
    }

    public String getGoodT2() {
        // "field never initialized within any constructor but derefereced without null check" warning per FindBugs
        switch (this.goodt2) {
            case 0:
                return "Likes to cuddle.";
            case 1:
                return "Able to rap freestyle.";
            case 2:
                return "Backstory 10/10.";
            case 3:
                return "Will clean your belly button.";
            case 4:
                return "Is the coolest.";
        }
        return "error";
    }

    public void setGoodT3(Integer goodt3) {
        this.goodt3 = goodt3;
    }

    public String getGoodT3() {
        // "field never initialized within any constructor but derefereced without null check" warning per FindBugs
        switch (this.goodt3) {
            case 0:
                return "Cooks like Gordon Ramsay.";
            case 1:
                return "Likes to draw.";
            case 2:
                return "Face 10/10.";
            case 3:
                return "Personality 200/10.";
            case 4:
                return "Plot 10/10.";
        }
        return "error";
    }

    public void setBadT(Integer badt) {
        this.badt = badt;
    }

    public String getBadT() {
       // "field never initialized within any constructor but derefereced without null check" warning per FindBugs
        switch (this.badt) {
            case 0:
                return "Lazier than Snorlax.";
            case 1:
                return "Scared of cotton balls.";
            case 2:
                return "Sings just like William Hung.";
            case 3:
                return "Thinks she is an alien from another universe.";
            case 4:
                return "Is secretly a man.";
        }
        return "error";
    }

    /**
     * Creates a new instance of UserNumberBean
     *
     * public UserNumberBean() { Random randomGR = new Random(); randomInt = new
     * Integer(randomGR.nextInt(10)); System.out.println("Duke's number: " +
     * randomInt); }
     */
    //Makes new waifu
    public void UserNumberBean() {
        // may need to remove void and make set methods private or final, per FindBugs
        setUserHair(1);
        setUserFace(1);
        setUserOutfit(1);
        setUserEyes(1);

    }

    public void setWaifu(String name, Integer hair, Integer eyes, Integer face, Integer outfit) {
        setUserNumber(name);
        setUserHair(hair);
        setUserFace(face);
        setUserOutfit(outfit);
        setUserEyes(eyes);

    }
}
