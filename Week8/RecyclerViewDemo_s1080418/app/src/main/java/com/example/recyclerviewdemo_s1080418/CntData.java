package com.example.recyclerviewdemo_s1080418;

public class CntData {
    private String name;
    private String id;
    private String email;

    public CntData(String name, String id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
    };

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }


}
