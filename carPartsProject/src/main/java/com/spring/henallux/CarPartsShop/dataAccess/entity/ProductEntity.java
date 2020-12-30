package com.spring.henallux.CarPartsShop.dataAccess.entity;

import com.spring.henallux.CarPartsShop.model.Category;

import javax.persistence.*;
import java.sql.Date;


@Entity(name="product")
public class ProductEntity {

    @Id
    @Column(name = "reference")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity_left")
    private Integer quantityLeft;

    @Column(name = "is_salable")
    private Boolean salable;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_category")
    private CategoryEntity categoryEntity;

    @Column(name = "image")
    private String image;


    public ProductEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(Integer quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public Boolean isSalable() {
        return salable;
    }

    public void setSalable(Boolean salable) {
        this.salable = salable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
