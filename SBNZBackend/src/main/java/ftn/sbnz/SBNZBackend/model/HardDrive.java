package ftn.sbnz.SBNZBackend.model;

public class HardDrive {
    private String tip;
    private int memorija;
    private String ime;

    public HardDrive() {
    }

    public HardDrive(String tip, int memorija, String ime) {
        this.tip = tip;
        this.memorija = memorija;
        this.ime = ime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getMemorija() {
        return memorija;
    }

    public void setMemorija(int memorija) {
        this.memorija = memorija;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
