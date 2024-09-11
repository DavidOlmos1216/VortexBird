package com.proyect.vortex.pruebavortex.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Integer id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private String synopsis;

    @Column(name = "is_active")
    private Boolean isActive;

    public Movies() {
    }

    public Movies(Integer id, String title, String gender, String synopsis, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.synopsis = synopsis;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getisActive() {
        return isActive;
    }

    public void setisActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Movies [id=" + id + ", title=" + title + ", gender=" + gender + ", synopsis=" + synopsis
                + ", isActive=" + isActive + "]";
    }

}
