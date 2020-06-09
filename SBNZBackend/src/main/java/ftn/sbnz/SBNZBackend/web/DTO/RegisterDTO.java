package ftn.sbnz.SBNZBackend.web.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class RegisterDTO {
    @Size(min = 1, message = "First name must not be empty")
    private String name;
    @Size(min = 1, message = "Last name must not be empty")
    private String lastName;
    @Email
    private String email;
    @Size(max = 32, min = 6, message = "Password size should be between 6 and 32 characters")
    private String password1;
    @Size(max = 32, min = 6, message = "Password size should be between 6 and 32 characters")
    private String password2;

    public RegisterDTO() {
    }

    public RegisterDTO(String name, String lastName, String email, String password1, String password2) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
