package com.example.blog_app;

public class Blog {
    private int id;
    private final String title;
    private final String text;
    private final String auther;
    

    public Blog(int id, String title, String text,String auther) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.auther = auther;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getAuther() {
        return auther;
    }
    

}
