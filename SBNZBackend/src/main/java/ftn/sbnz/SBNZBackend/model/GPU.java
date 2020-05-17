package ftn.sbnz.SBNZBackend.model;

public class GPU {
    private int memorija;
    private String tipMemorije;
    private String ime;

    public GPU() {
    }

    public GPU(int memorija, String tipMemorije, String ime) {
        this.memorija = memorija;
        this.tipMemorije = tipMemorije;
        this.ime = ime;
    }

    public int getMemorija() {
        return memorija;
    }

    public void setMemorija(int memorija) {
        this.memorija = memorija;
    }

    public String getTipMemorije() {
        return tipMemorije;
    }

    public void setTipMemorije(String tipMemorije) {
        this.tipMemorije = tipMemorije;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
