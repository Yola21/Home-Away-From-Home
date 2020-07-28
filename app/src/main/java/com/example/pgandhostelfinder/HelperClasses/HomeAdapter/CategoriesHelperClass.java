package com.example.pgandhostelfinder.HelperClasses.HomeAdapter;

public class CategoriesHelperClass {

    int cimage;
    String ctitle;

    public CategoriesHelperClass(int cimage, String ctitle) {
        this.cimage = cimage;
        this.ctitle = ctitle;
    }

    public int getCimage() {
        return cimage;
    }

    public String getCtitle() {
        return ctitle;
    }
}
