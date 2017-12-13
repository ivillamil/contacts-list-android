package com.ivillamil.contacts;

/**
 * Created by ivillamil on 12/12/17.
 */

public class Contact {

    public int id;
    public String avatar;
    public String address;
    public String description;
    public String email;
    public String name;
    public String phone;
    public String title;

    public Contact() {}

    public Contact(int id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public Contact(int id, String avatar, String address, String description, String email, String name, String phone, String title) {
        this.id = id;
        this.avatar = avatar;
        this.address = address;
        this.description = description;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
