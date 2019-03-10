package edr.bhanuinfosystems.com.model;

public class Patient {

    private int mrno, page, pmob,doc_id;
    private String pname, pgen, pemail, pbg, pcity, padd;

    public Patient(int mrno, int page, int pmob, int doc_id, String pname, String pgen, String pemail, String pbg, String pcity, String padd) {
        this.mrno = mrno;
        this.page = page;
        this.pmob = pmob;
        this.doc_id = doc_id;
        this.pname = pname;
        this.pgen = pgen;
        this.pemail = pemail;
        this.pbg = pbg;
        this.pcity = pcity;
        this.padd = padd;
    }

    public int getMrno() {
        return mrno;
    }

    public int getPage() {
        return page;
    }

    public int getPmob() {
        return pmob;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public String getPname() {
        return pname;
    }

    public String getPgen() {
        return pgen;
    }

    public String getPemail() {
        return pemail;
    }

    public String getPbg() {
        return pbg;
    }

    public String getPcity() {
        return pcity;
    }

    public String getPadd() {
        return padd;
    }
}

