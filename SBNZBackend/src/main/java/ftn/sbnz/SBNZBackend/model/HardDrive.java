package ftn.sbnz.SBNZBackend.model;

import javax.persistence.*;

@Entity
@Table
public class HardDrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private String tip;

    @Column(nullable = false)
    private int memorija;

    @Column(nullable = false)
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
