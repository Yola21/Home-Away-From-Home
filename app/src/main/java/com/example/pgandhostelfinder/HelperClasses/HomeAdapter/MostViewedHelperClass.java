package com.example.pgandhostelfinder.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {

    int mvimage;
    String mvtitle, mvdesc;

    public MostViewedHelperClass(int mvimage, String mvtitle, String mvdesc) {
        this.mvimage = mvimage;
        this.mvtitle = mvtitle;
        this.mvdesc = mvdesc;
    }

    public int getMvimage() {
        return mvimage;
    }

    public String getMvtitle() {
        return mvtitle;
    }

    public String getMvdesc() {
        return mvdesc;
    }
}
