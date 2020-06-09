package ftn.sbnz.SBNZBackend.web.DTO;

public class DrlDTO {
    private String text;
    private String ime;

    public DrlDTO() {
    }

    public DrlDTO(String text, String ime) {
        this.text = text;
        this.ime = ime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
