package com.example.paincare.Bean;

import java.util.Date;

public class blogBean {
    private Integer id;
    private String title;
    private String description;
    private Date created_at;
    private String imageLink;


    private Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    // Getter pour imageLink
    public String getImageLink() {
        return imageLink;
    }

    // Setter pour imageLink
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

}