package com.spring.henallux.carPartsProject.dataAccess.entity;

import javax.persistence.*;


@Entity(name="category")
public class CategoryEntity {


    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "image")
    private String image;


    public CategoryEntity() {
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

    public void setCcategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
