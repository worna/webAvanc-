package com.spring.henallux.carPartsProject.dataAccess.entity;

import javax.persistence.*;


@Entity(name="category")
public class CategoryEntity {



    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "image")
    private String image;


    public CategoryEntity() {
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
