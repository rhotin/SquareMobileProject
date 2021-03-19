package com.test.rh.squaremobileproject.model;

import com.google.gson.annotations.SerializedName;

/*
      "uuid": "0d8fcc12-4d0c-425c-8355-390b312b909c",
      "full_name": "Justine Mason",
      "phone_number": "5553280123",
      "email_address": "jmason.demo@squareup.com",
      "biography": "Engineer on the Point of Sale team.",
      "photo_url_small": "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg",
      "photo_url_large": "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/large.jpg",
      "team": "Point of Sale",
      "Employee_type": "FULL_TIME"
 */
public class Employee {
    @SerializedName("uuid")
    public String uuid;
    @SerializedName("full_name")
    public String full_name;
    @SerializedName("phone_number")
    public String phone_number;
    @SerializedName("email_address")
    public String email_address;
    @SerializedName("biography")
    public String biography;
    @SerializedName("photo_url_small")
    public String photo_url_small;
    @SerializedName("photo_url_large")
    public String photo_url_large;
    @SerializedName("team")
    public String team;
    @SerializedName("employee_type")
    public Employee_type employee_type;

    public Employee(String uuid, String full_name, String phone_number, String email_address, String biography, String photo_url_small, String photo_url_large, String team, Employee_type employee_type) {
        this.uuid = uuid;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.biography = biography;
        this.photo_url_small = photo_url_small;
        this.photo_url_large = photo_url_large;
        this.team = team;
        this.employee_type = employee_type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhoto_url_small() {
        return photo_url_small;
    }

    public void setPhoto_url_small(String photo_url_small) {
        this.photo_url_small = photo_url_small;
    }

    public String getPhoto_url_large() {
        return photo_url_large;
    }

    public void setPhoto_url_large(String photo_url_large) {
        this.photo_url_large = photo_url_large;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Employee_type getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(Employee_type employee_type) {
        this.employee_type = employee_type;
    }
}



