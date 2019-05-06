package edr.bhanuinfosystems.com.model;

public class Patient_History {

    String Clinical_notes,examination;

    public Patient_History(String clinical_notes, String examination) {
        Clinical_notes = clinical_notes;
        this.examination = examination;
    }

    public String getClinical_notes() {
        return Clinical_notes;
    }

    public String getExamination() {
        return examination;
    }
}
