package com.spring.henallux.carPartsProject.model;

public class CategoryTranslation {
    private String name;
    private int categoryId;
    private String languageName;



    public CategoryTranslation(String name, int categoryId, String languageName) {
        this.name = name;
        this.categoryId = categoryId;
        this.languageName = languageName;

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

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
