package edr.bhanuinfosystems.com.model;

public class Doctor {

    private  int id;
    private String dname;
    private String dgen;
    private int dmob;
    private String demail;

    private String dcity;
    private String dspec;
    private int dexp;
    private int dreg;
    private int status;

    public Doctor() {
        this.id = this.id;
        this.dname = this.dname;
        this.dgen = this.dgen;
        this.dmob = this.dmob;
        this.demail = this.demail;
        this.dcity = this.dcity;
        this.dspec = this.dspec;
        this.dexp = this.dexp;
        this.dreg = this.dreg;
        this.status = this.status;
    }

    public int getId() {
        return id;
    }

    public String getDname() {
        return dname;
    }

    public String getDgen() {
        return dgen;
    }

    public int getDmob() {
        return dmob;
    }

    public String getDemail() {
        return demail;
    }



    public String getDcity() {
        return dcity;
    }

    public String getDspec() {
        return dspec;
    }

    public int getDexp() {
        return dexp;
    }

    public int getDreg() {
        return dreg;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setDgen(String dgen) {
        this.dgen = dgen;
    }

    public void setDmob(int dmob) {
        this.dmob = dmob;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public void setDcity(String dcity) {
        this.dcity = dcity;
    }

    public void setDspec(String dspec) {
        this.dspec = dspec;
    }

    public void setDexp(int dexp) {
        this.dexp = dexp;
    }

    public void setDreg(int dreg) {
        this.dreg = dreg;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
