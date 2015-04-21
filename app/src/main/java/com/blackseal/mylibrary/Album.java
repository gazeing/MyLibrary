package com.blackseal.mylibrary;

import android.support.annotation.DrawableRes;

/**
 * Created by Steven on 21/04/2015.
 */
public class Album {

    String title;
    String Author;
    int ImageDrawableId;

    public Album(int imageDrawableId, String title, String author) {
        ImageDrawableId = imageDrawableId;
        Author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getImageDrawableId() {
        return ImageDrawableId;
    }
}
