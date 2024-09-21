package com.insurance.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@CompoundIndex(name = "email_unique", def = "{'email' : 1}", unique = true)
public class User {

    @Id
    private String id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String fullname;
    private String mobilenumber;
    private String email;
    private String password;
    private String photo;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
        updateFullname();
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
        updateFullname();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        updateFullname();
    }

    public String getFullname() {
        return fullname;
    }

    private void updateFullname() {
        // Simplifying the logic for creating full name
        this.fullname = String.format("%s %s %s",
            firstname != null ? firstname : "",
            middlename != null ? middlename : "",
            lastname != null ? lastname : "").trim();
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
