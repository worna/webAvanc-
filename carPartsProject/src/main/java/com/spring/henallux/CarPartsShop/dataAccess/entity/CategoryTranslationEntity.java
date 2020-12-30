package com.spring.henallux.CarPartsShop.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity(name="category_translation")
@IdClass(categoryTranslationKey.class)
public class CategoryTranslationEntity {

    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Id
    @Column(name = "language_name")
    private String languageName;

    @Column(name = "category_name")
    private String name;


    public CategoryTranslationEntity() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
