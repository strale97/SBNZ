package ftn.sbnz.SBNZBackend.model;

public class RAM {
    private int memorija;
    private String tipMemorije;
    private int brzina;
    private String ime;

    public RAM() {
    }

    public RAM(int memorija, String tipMemorije, int brzina, String ime) {
        this.memorija = memorija;
        this.tipMemorije = tipMemorije;
        this.brzina = brzina;
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

    public int getBrzina() {
        return brzina;
    }

    public void setBrzina(int brzina) {
        this.brzina = brzina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
