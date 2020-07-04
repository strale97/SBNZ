package ftn.sbnz.SBNZBackend.model;

import org.kie.api.definition.type.Position;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Konfiguracija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Position(0)
    private int id;

    @OneToOne(cascade={CascadeType.ALL})
    private CPU cpu;

    @OneToOne(cascade={CascadeType.ALL})
    private GPU gpu;

    @OneToOne(cascade={CascadeType.ALL})
    private RAM ram;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private List<HardDrive> hardDrives;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int cena;

    @Column(nullable = false)
    @Position(1)
    private String os;

    @Column(nullable = false)
    @Position(2)
    private boolean laptop;

    @OneToOne(cascade={CascadeType.ALL})
    private Skor skor = new Skor();

    public Konfiguracija() {
    }

    public Konfiguracija(CPU cpu, GPU gpu, RAM ram, ArrayList<HardDrive> hardDrives, String ime, String link, int cena, String os, boolean laptop, Skor skor) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.hardDrives = hardDrives;
        this.ime = ime;
        this.link = link;
        this.cena = cena;
        this.os = os;
        this.laptop = laptop;
        this.skor = skor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public List<HardDrive> getHardDrives() {
        return hardDrives;
    }

    public void setHardDrives(List<HardDrive> hardDrives) {
        this.hardDrives = hardDrives;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Skor getSkor() {
        return skor;
    }

    public void setSkor(Skor skor) {
        this.skor = skor;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public boolean isLaptop() {
        return laptop;
    }

    public void setLaptop(boolean laptop) {
        this.laptop = laptop;
    }
}
