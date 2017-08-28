package com.example.wilidflower;

import android.widget.ImageView;

/**
 * Created by USER on 2/6/2017.
 */

public class Flower {

    private String name;
    private String description;
    private Integer imageView;

    public Flower(String name,String description,Integer imageView) {
        this.name = name;
        this.description = description;
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getImageView() {
        return imageView;
    }
}
