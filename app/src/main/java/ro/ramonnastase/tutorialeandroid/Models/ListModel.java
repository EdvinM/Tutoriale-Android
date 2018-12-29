package ro.ramonnastase.tutorialeandroid.Models;

public class ListModel {

    private String name;
    private String number;
    private String imageUrl;

    public ListModel() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
