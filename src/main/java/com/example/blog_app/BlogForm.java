package com.example.blog_app;

public class BlogForm {
    private String title;
    private String text;
    private String auther; // スペルミスでauthorがauther

   
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getAuther() { return auther; }
    public void setAuther(String auther) { this.auther = auther; }
}