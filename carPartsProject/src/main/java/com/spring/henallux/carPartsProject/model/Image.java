package com.spring.henallux.carPartsProject.model;

public class Image {
    private int id;
    private byte[] image;



    public Image(int id,byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
