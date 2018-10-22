package com.example.andreii.firstaplication.HW7.comon;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {

    String name;
    String year;
    String imageURL;

    int photoID;

    public Album(String name, String year, String imageURL) {
        this.name = name;
        this.year = year;
        this.imageURL = imageURL;
    }

    private List<Album> discography;


    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return imageURL;
    }

    public int getPhotoID() {
        return photoID;
    }

    public List<Album> getDiscography() {
        return discography;
    }

    public void setNameA(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
