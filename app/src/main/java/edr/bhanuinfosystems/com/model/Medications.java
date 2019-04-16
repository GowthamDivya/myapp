package edr.bhanuinfosystems.com.model;

public class Medications {
    String Medname,frequency,days,qty,afbf,instruction;

    public Medications(String medname, String frequency, String days, String qty, String afbf, String instruction) {
        Medname = medname;
        this.frequency = frequency;
        this.days = days;
        this.qty = qty;
        this.afbf = afbf;
        this.instruction = instruction;
    }

    public String getMedname() {
        return Medname;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getDays() {
        return days;
    }

    public String getQty() {
        return qty;
    }

    public String getAfbf() {
        return afbf;
    }

    public String getInstruction() {
        return instruction;
    }
}
