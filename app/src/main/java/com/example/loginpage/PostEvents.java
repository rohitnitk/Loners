package com.example.loginpage;

public class PostEvents {

    public String date, description, fullname, eventimage, time, uid;

    public PostEvents(){
    }

    public PostEvents(String date, String description, String fullname, String eventimage, String time, String uid) {
        this.date = date;
        this.description = description;
        this.fullname = fullname;
        this.eventimage = eventimage;
        this.time = time;
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEventimage() {
        return eventimage;
    }

    public void setEventimage(String eventimage) {
        this.eventimage = eventimage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
