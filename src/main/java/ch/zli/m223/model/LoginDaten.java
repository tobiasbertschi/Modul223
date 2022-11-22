package ch.zli.m223.model;

import javax.validation.constraints.NotBlank;

public class LoginDaten {
    
@NotBlank
private String email;

@NotBlank
private String passwort;

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPasswort() {
    return passwort;
}

public void setPasswort(String passwort) {
    this.passwort = passwort;
}

}