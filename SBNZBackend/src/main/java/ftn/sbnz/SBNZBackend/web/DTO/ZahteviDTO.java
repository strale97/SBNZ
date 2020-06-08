package ftn.sbnz.SBNZBackend.web.DTO;

public class ZahteviDTO {
    private boolean koristioPre;
    private String os;
    private String upotreba;
    private int budzet;
    private boolean laptop;
    private String prefGpu;
    private String prefCpu;

    public ZahteviDTO() {
    }

    public ZahteviDTO(boolean koristioPre, String os, String upotreba, int budzet, boolean laptop, String prefGpu, String prefCpu) {
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
}
