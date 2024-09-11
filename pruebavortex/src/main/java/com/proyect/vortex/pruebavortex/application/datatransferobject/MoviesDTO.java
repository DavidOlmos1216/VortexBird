package com.proyect.vortex.pruebavortex.application.datatransferobject;

public class MoviesDTO {

    private int id;
    private String title;
    private String gender;
    private String synopsis;
    private boolean isActive;

    public MoviesDTO() {
    }

    public MoviesDTO(int id, String title, String gender, String synopsis, boolean isActive) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.synopsis = synopsis;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "MoviesDTO [id=" + id + ", title=" + title + ", gender=" + gender + ", synopsis=" + synopsis
                + ", isActive=" + isActive + "]";
    }

}
