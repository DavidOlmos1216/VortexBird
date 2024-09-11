package com.proyect.vortex.pruebavortex.application.datatransferobject;

public class CustomersDTO {

    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean isActive;

    public CustomersDTO() {
    }

    public CustomersDTO(int id, String name, String email, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "CustomersDTO [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", isActive="
                + isActive + "]";
    }

}
