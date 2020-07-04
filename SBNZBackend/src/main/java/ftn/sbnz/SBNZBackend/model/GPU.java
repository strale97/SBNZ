package ftn.sbnz.SBNZBackend.model;

import javax.persistence.*;

@Entity
@Table
public class GPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private int memorija;

    @Column(nullable = false)
    private String tipMemorije;

    @Column(nullable = false)
    private String ime;

    public GPU() {
    }

    public GPU(int memorija, String tipMemorije, String ime) {
        this.memorija = memorija;
        this.tipMemorije = tipMemorije;
        this.ime = ime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
