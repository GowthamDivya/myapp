package edr.bhanuinfosystems.com.model;

public class Patient {

    private  int id;
    private String pname;
    private String pgen;
    private int page;
    private int pmob;

    private String pemail;
    private String pcity;
    private int did;

    public Patient(int id, String pname, String pgen, int page, int pmob, String pemail, String pcity, int did) {
        this.id = id;
        this.pname = pname;
        this.pgen = pgen;
        this.page = page;
        this.pmob = pmob;
        this.pemail = pemail;
        this.pcity = pcity;
        this.did = did;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public String getPname() {
        return pname;
    }

    public String getPgen() {
        return pgen;
    }

    public int getPage() {
        return page;
    }

    public int getPmob() {
        return pmob;
    }

    public String getPemail() {
        return pemail;
    }

    public String getPcity() {
        return pcity;
    }

    public int getDid() {
        return did;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPgen(String pgen) {
        this.pgen = pgen;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPmob(int pmob) {
        this.pmob = pmob;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    public void setDid(int did) {
        this.did = did;
    }
}


