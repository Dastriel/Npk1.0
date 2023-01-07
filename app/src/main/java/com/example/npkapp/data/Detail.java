package com.example.npkapp.data;

public class Detail {
    private String name;
    private String type;

    public Detail(){
        this.name = "";
        this.type = "";
    }

    public Detail(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}
