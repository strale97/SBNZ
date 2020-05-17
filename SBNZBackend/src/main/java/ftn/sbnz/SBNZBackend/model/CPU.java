package ftn.sbnz.SBNZBackend.model;

public class CPU {
    private double brzina;
    private int jezgra;
    private int tredovi;
    private String ime;

    public CPU() {
    }

    public CPU(double brzina, int jezgra, int tredovi, String ime) {
        this.brzina = brzina;
        this.jezgra = jezgra;
        this.tredovi = tredovi;
        this.ime = ime;
    }

    public double getBrzina() {
        return brzina;
    }

    public void setBrzina(double brzina) {
        this.brzina = brzina;
    }

    public int getJezgra() {
        return jezgra;
    }

    public void setJezgra(int jezgra) {
        this.jezgra = jezgra;
    }

    public int getTredovi() {
        return tredovi;
    }

    public void setTredovi(int tredovi) {
        this.tredovi = tredovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
