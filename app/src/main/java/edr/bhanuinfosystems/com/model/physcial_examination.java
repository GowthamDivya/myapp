package edr.bhanuinfosystems.com.model;

public class physcial_examination {

    String height,weight,temp,bp,sugar;

    public physcial_examination(String height, String weight, String temp, String bp, String sugar) {
        this.height = height;
        this.weight = weight;
        this.temp = temp;
        this.bp = bp;
        this.sugar = sugar;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getTemp() {
        return temp;
    }

    public String getBp() {
        return bp;
    }

    public String getSugar() {
        return sugar;
    }
}
