package com.example.btl.model;

public class CartItem {
    private String name;
    private int image;
    private String price;

    public CartItem(String name, int image, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }
}

