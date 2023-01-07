package com.example.npkapp.data;

import java.util.ArrayList;

public class DetailCase {
    private String title;
    private ArrayList<String> content;

    public DetailCase(){
        this.title = "";
        this.content = new ArrayList<>();
    }

    public DetailCase(String title, ArrayList<String> content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public ArrayList<String> getContent() {return content;}
    public void setContent(ArrayList<String> content) {this.content = content;}
}
