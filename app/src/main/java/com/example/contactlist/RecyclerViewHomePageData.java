package com.example.contactlist;

public class RecyclerViewHomePageData {
    String name;
    String number;
    int image;
    boolean isSelected;

    public RecyclerViewHomePageData(String name, String number, int image, boolean isSelected) {
        this.name = name;
        this.number = number;
        this.image = image;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
