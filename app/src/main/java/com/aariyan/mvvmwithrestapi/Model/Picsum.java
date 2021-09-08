package com.aariyan.mvvmwithrestapi.Model;

public class Picsum {
    private String authorName,imageUrl;

    public Picsum(){}

    public Picsum(String authorName, String imageUrl) {
        this.authorName = authorName;
        this.imageUrl = imageUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
