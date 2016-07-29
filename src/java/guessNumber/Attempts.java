package guessNumber;

/**
 *
 * @author Masako
 */
public class Attempts {

    public String name;
    public Integer hair;
    public Integer face;
    public Integer outfit;
    public Integer eyes;
    public Integer goodt1, goodt2, goodt3, badt;

//Change to name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//Change to hair

    public Integer getHair() {
        return hair;
    }

    public void setHair(Integer hair) {
        this.hair = hair;
    }
// change to eyes/body

    public Integer getFace() {
        return face;
    }

    public void setFace(Integer face) {
        this.face = face;
    }

    public void setEyes(Integer eyes) {
        this.eyes = eyes;
    }

    public Integer getEyes() {
        return eyes;
    }

    public void setOutfit(Integer outfit) {
        this.outfit = outfit;
    }

    public Integer getOutfit() {
        return outfit;
    }

    //Good traits
    public void setGoodT1(Integer goodt1) {
        this.goodt1 = goodt1;
    }

    public Integer getGoodT1() {
        return goodt1;
    }

    public void setGoodT2(Integer goodt2) {
        this.goodt2 = goodt2;
    }

    public Integer getGoodT2() {
        return goodt2;
    }

    public void setGoodT3(Integer goodt3) {
        this.goodt3 = goodt3;
    }

    public Integer getGoodT3() {
        return goodt3;
    }

    //Bad trait
    public void setBadT(Integer badt) {
        this.badt = badt;
    }

    public Integer getBadT() {
        return badt;
    }
}
