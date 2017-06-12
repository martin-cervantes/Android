package com.example.mcervantes.booklistingapp;

public class Book
{
    private String title;

    private String author;
    
    private String selfLink;
    
    public Book(String t, String a, String s)
    {
        title = t;

        author = a;
        
        selfLink = s;
    }
    
    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }
    
    public String getSelfLink()
    {
        return selfLink;
    }
}
