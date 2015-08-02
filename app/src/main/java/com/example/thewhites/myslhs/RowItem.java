package com.example.thewhites.myslhs;
public class RowItem {
    private int imageId;
    private String title;
    private String desc;
    private String ext;

    public RowItem(int imageId, String title, String desc, String ext) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.ext = ext;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getExt() {
        return ext;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }
    @Override
    public String toString() {
        return title + "\n" + desc + "\n" + ext;
    }
}
