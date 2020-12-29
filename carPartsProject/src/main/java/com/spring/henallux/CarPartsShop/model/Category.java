package com.spring.henallux.carPartsProject.model;

public class Category {
    private int categoryId;
    private String image;



    public Category(int categoryId,String image) {
        this.categoryId = categoryId;
        this.image = image;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
