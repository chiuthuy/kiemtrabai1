package com.example.baiKiemTra;

import android.widget.ImageButton;

import java.io.Serializable;

public class model implements Serializable {
    private String Mname;
    private   int Mimg;
    private String Mgia;
    private ImageButton Mnut;
    public model(){}
    public model(String mname, int mimg, String mgia ) {
        Mname = mname;
        Mimg = mimg;
        Mgia = mgia;

    }

    public ImageButton getMnut() {
        return Mnut;
    }

    public void setMnut(ImageButton mnut) {
        Mnut = mnut;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public int getMimg() {
        return Mimg;
    }

    public void setMimg(int mimg) {
        Mimg = mimg;
    }

    public String getMgia() {
        return Mgia;
    }

    public void setMgia(String mgia) {
        Mgia = mgia;
    }
}
