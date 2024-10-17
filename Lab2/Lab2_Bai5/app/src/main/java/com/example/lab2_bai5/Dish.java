package com.example.lab2_bai5;

public class Dish {
    private String name;
    private int thumbnail;
    private boolean isPromotion;

    public Dish(String name, int thumbnail, boolean isPromotion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.isPromotion = isPromotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public void setPromotion(boolean isPromotion) {
        this.isPromotion = isPromotion;
    }
}
