package ftn.sbnz.SBNZBackend.model;

import java.util.ArrayList;

public class Konfiguracija {
    private int id;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private ArrayList<HardDrive> hardDrives;
    private String ime;
    private String link;
    private int poeni;
    private int cena;
    private String os;
    private boolean laptop;

    public Konfiguracija() {
    }

    public Konfiguracija(int id, CPU cpu, GPU gpu, RAM ram, ArrayList<HardDrive> hardDrives, String ime, String link, int poeni, int cena, String os, boolean laptop) {
        this.id = id;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.hardDrives = hardDrives;
        this.ime = ime;
        this.link = link;
        this.poeni = poeni;
        this.cena = cena;
        this.os = os;
        this.laptop = laptop;
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

    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public void addPoeni(int poeni){
        this.poeni += poeni;
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
