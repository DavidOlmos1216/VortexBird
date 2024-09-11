package com.proyect.vortex.pruebavortex.application.datatransferobject;

import java.sql.Date;

public class TicketsDTO {

    private int id;
    private int movieId;
    private int customerId;
    private Date purchaseDate;
    private int quantity;
    private int totalPrice;

    public TicketsDTO() {
    }

    public TicketsDTO(int id, int movieId, int customerId,Date purchaseDate, int quantity, int totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.movieId = movieId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "TicketsDTO [id=" + id + ", movieId=" + movieId + ", purchaseDate=" + purchaseDate + ", quantity="
                + quantity + ", totalPrice=" + totalPrice + "]";
    }

}
