package ftn.sbnz.SBNZBackend.model;

import org.kie.api.definition.type.Position;

import java.util.ArrayList;

public class Konfiguracija {
    @Position(0)
    private int id;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private ArrayList<HardDrive> hardDrives;
    private String ime;
    private String link;
    private int cena;
    @Position(1)
    private String os;
    @Position(2)
    private boolean laptop;
    private boolean popularno = false;
    private Skor skor = new Skor();

    public Konfiguracija() {
    }

    public Konfiguracija(int id, CPU cpu, GPU gpu, RAM ram, ArrayList<HardDrive> hardDrives, String ime, String link, int cena, String os, boolean laptop, boolean popularno, Skor skor) {
        this.id = id;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.hardDrives = hardDrives;
        this.ime = ime;
        this.link = link;
        this.cena = cena;
        this.os = os;
        this.laptop = laptop;
        this.popularno = popularno;
        this.skor = skor;
    }

    public boolean isPopularno() {
        return popularno;
    }

    public void setPopularno(boolean popularno) {
        this.popularno = popularno;
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

    public ArrayList<HardDrive> getHardDrives() {
        return hardDrives;
    }

    public void setHardDrives(ArrayList<HardDrive> hardDrives) {
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
