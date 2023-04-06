package com.example.recycle_view;

public class Item {
    private int sImgResource;
    private String sText;
    public Item(int ImgResource, String text){
        sImgResource = ImgResource;
        sText = text;
    }
    public int getsImgResource() {
        return sImgResource;
    }

    public void setsImgResource(int sImgResource) {
        this.sImgResource = sImgResource;
    }
    public String getsText(){
        return sText;
    }

    public void setsText(String sText) {
        this.sText = sText;
    }
}

