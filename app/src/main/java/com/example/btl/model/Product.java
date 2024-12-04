package com.example.btl.model;

public class Product {
    private String name;
    private String price;
    private int imageResId; // ID tài nguyên hình ảnh
    private String specifications; // Thông số kỹ thuật
    private String description; // Mô tả sản phẩm

    public Product(String name, String price, int imageResId, String specifications, String description) {
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
        this.specifications = specifications;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getSpecifications() {
        return specifications; // Trả về thông số kỹ thuật
    }

    public String getDescription() {
        return description; // Trả về mô tả
    }
}
