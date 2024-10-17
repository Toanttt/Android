package com.example.lab2_bai5;

public enum Thumbnail {
    Thumbnail1("Bun Dau", R.drawable.img1),
    Thumbnail2("Com ga", R.drawable.img2),
    Thumbnail3("Bun Bo", R.drawable.img3),
    Thumbnail4("Com Tam", R.drawable.img4);

    private String name;
    private int img;

    // Constructor cho enum
    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    // Getter cho tên thumbnail
    public String getName() {
        return name;
    }

    // Getter cho hình ảnh thumbnail
    public int getImg() {
        return img;
    }
}
