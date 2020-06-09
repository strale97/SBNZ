package ftn.sbnz.SBNZBackend.web.DTO;

public class FilterDTO {
    private String os;
    private boolean laptop;

    public FilterDTO() {
    }

    public FilterDTO(String os, boolean laptop) {
        this.os = os;
        this.laptop = laptop;
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
