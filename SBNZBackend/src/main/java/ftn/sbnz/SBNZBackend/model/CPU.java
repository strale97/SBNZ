package ftn.sbnz.SBNZBackend.model;

import javax.persistence.*;

@Entity
@Table
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private double brzina;

    @Column(nullable = false)
    private int jezgra;

    @Column(nullable = false)
    private int tredovi;

    @Column(nullable = false)
    private String ime;

    public CPU() {
    }

    public CPU(double brzina, int jezgra, int tredovi, String ime) {
        this.brzina = brzina;
        this.jezgra = jezgra;
        this.tredovi = tredovi;
        this.ime = ime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
