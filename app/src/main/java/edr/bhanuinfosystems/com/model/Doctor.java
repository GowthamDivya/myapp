package edr.bhanuinfosystems.com.model;

public class Doctor {

    private int
            dmob,		dexp,	dregno;
    private String dname,	dgen, demail,	dcity,	dspec;

    public Doctor(int dmob, int dexp, int dregno, String dname, String dgen, String demail, String dcity, String dspec) {
        this.dmob = dmob;
        this.dexp = dexp;
        this.dregno = dregno;
        this.dname = dname;
        this.dgen = dgen;
        this.demail = demail;
        this.dcity = dcity;
        this.dspec = dspec;
    }

    public int getDmob() {
        return dmob;
    }

    public int getDexp() {
        return dexp;
    }

    public int getDregno() {
        return dregno;
    }

    public String getDname() {
        return dname;
    }

    public String getDgen() {
        return dgen;
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
}
