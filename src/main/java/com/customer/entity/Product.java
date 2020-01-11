package com.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String productName;
    private String type;
    private String color;
    private int barcode;
    private double numberOfItems;
    private double listPrice;
    private double ourPrice;
    private boolean active=true;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductToCartItem> productToCartItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public double getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(double numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ProductToCartItem> getProductToCartItems() {
        return productToCartItems;
    }

    public void setProductToCartItems(List<ProductToCartItem> productToCartItems) {
        this.productToCartItems = productToCartItems;
    }
}
