package com.proyect.vortex.pruebavortex.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Integer id;

    @Column(name = "customer_id", nullable = true)
    private Integer customerId;

    @Column(name = "movie_id", nullable = true)
    private Integer movieId;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(nullable = true)
    private Integer quantity;

    @Column(name = "total_price", nullable = true)
    private Integer totalPrice;

    public Tickets() {
    }

    public Tickets(Integer id, Integer customerId, Integer movieId, Date purchaseDate, Integer quantity,
            Integer totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.movieId = movieId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Tickets [id=" + id + ", customerId=" + customerId + ", movieId=" + movieId + ", purchaseDate="
                + purchaseDate + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
    }

}
