package com.proyect.vortex.pruebavortex.application.datatransferobject;

public class LoginResponseDTO {
    private String email;
    private String jwtToke;

    public LoginResponseDTO(String email, String jwtToke) {
        this.email = email;
        this.jwtToke = jwtToke;
    }

    public String getEmail() {
        return email;
    }

    public String getJwtToke() {
        return jwtToke;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO [email=" + email + ", jwtToke=" + jwtToke + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((jwtToke == null) ? 0 : jwtToke.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LoginResponseDTO other = (LoginResponseDTO) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (jwtToke == null) {
            if (other.jwtToke != null)
                return false;
        } else if (!jwtToke.equals(other.jwtToke))
            return false;
        return true;
    }

    
    
}
