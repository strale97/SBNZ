package ftn.sbnz.SBNZBackend.web.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginDTO {
    @Email
    private String email;
    @NotNull
    private String password;

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
