package com.proyect.vortex.pruebavortex.application.datatransferobject;

public class CustomersDTO extends RegistrationCustomerDTO {

    private boolean isActive;

    public CustomersDTO() {
    }

    public CustomersDTO(String name, String email, String phone, boolean isActive) {
        super(name, email, phone, phone);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "CustomersDTO [isActive=" + isActive + ", toString()=" + super.toString() + "]";
    }

    
}
