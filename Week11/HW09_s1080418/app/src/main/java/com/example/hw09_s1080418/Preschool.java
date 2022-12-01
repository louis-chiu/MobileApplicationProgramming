package com.example.hw09_s1080418;

public class Preschool {
    private int id;
    private  String type;
    private String name;
    private String address;
    private String number_of_enrollment;

    public Preschool(int id, String type, String name, String address, String number_of_enrollment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.address = address;
        this.number_of_enrollment = number_of_enrollment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber_of_enrollment() {
        return number_of_enrollment;
    }

    public void setNumber_of_enrollment(String number_of_enrollment) {
        this.number_of_enrollment = number_of_enrollment;
    }
}
