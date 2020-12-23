package com.spring.henallux.carPartsProject.model;

public class Category {
    private String name;
    private int categoryId;
    private String image;



    public Category(String name, int categoryId,String image) {
        this.name = name;
        this.categoryId = categoryId;
        this.image = image;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
