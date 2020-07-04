package ftn.sbnz.SBNZBackend.model;

import ftn.sbnz.SBNZBackend.web.DTO.ZahteviDTO;

public class Zahtevi {

    private boolean koristioPre = false;
    private String os = "NA";
    private String upotreba = "NA";
    private int budzet = 0;
    private boolean laptop = false;
    private String prefGpu = "NA";
    private String prefCpu = "NA";

    public Zahtevi() {
    }

    public Zahtevi(ZahteviDTO zahteviDTO) {
        this.koristioPre = zahteviDTO.isKoristioPre();
        this.os = zahteviDTO.getOs();
        this.upotreba = zahteviDTO.getUpotreba();
        this.budzet = zahteviDTO.getBudzet();
        this.laptop = zahteviDTO.isLaptop();
        this.prefGpu = zahteviDTO.getPrefGpu();
        this.prefCpu = zahteviDTO.getPrefCpu();
    }

    public Zahtevi(boolean koristioPre, String os, String upotreba, int budzet, boolean laptop, String prefGpu, String prefCpu) {
        this.koristioPre = koristioPre;
        this.os = os;
        this.upotreba = upotreba;
        this.budzet = budzet;
        this.laptop = laptop;
        this.prefGpu = prefGpu;
        this.prefCpu = prefCpu;
    }

    public boolean isKoristioPre() {
        return koristioPre;
    }

    public void setKoristioPre(boolean koristioPre) {
        this.koristioPre = koristioPre;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPrefGpu() {
        return prefGpu;
    }

    public void setPrefGpu(String prefGpu) {
        this.prefGpu = prefGpu;
    }

    public String getPrefCpu() {
        return prefCpu;
    }

    public void setPrefCpu(String prefCpu) {
        this.prefCpu = prefCpu;
    }

    public String getUpotreba() {
        return upotreba;
    }

    public void setUpotreba(String upotreba) {
        this.upotreba = upotreba;
    }

    public int getBudzet() {
        return budzet;
    }

    public void setBudzet(int budzet) {
        this.budzet = budzet;
    }

    public boolean isLaptop() {
        return laptop;
    }

    public void setLaptop(boolean laptop) {
        this.laptop = laptop;
    }
}
