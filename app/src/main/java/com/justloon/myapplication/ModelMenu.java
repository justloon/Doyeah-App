package com.justloon.myapplication;

public class ModelMenu {
    private int image;
    private String name;
    private String price;
    private String deskripsi;

    public ModelMenu(int image, String name, String price, String deskripsi) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.deskripsi = deskripsi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
