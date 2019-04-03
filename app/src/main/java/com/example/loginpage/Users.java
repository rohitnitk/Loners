package com.example.loginpage;

/**
 * Created by AkshayeJH on 15/12/17.
 */

public class Users {

    private String Name, Image_Url, status;

    public Users() {

    }

    public Users(String name, String Image_Url, String status) {
        Name = name;
        this.Image_Url = Image_Url;
        this.status = status;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage_Url() {
        return Image_Url;
    }

    public void setImage_Url(String Image_Url) {
        this.Image_Url = Image_Url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

