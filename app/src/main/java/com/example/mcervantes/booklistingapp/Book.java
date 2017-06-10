package com.example.mcervantes.booklistingapp;

public class Book
{
    private String title;
    
    private String description;
    
    private String volumeCount;
    
    private String selfLink;
    
    public Book(String t, String d, String v, String s)
    {
        title = t;
        
        description = d;
        
        volumeCount = v;
        
        selfLink = s;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getVolumeCount()
    {
        return volumeCount;
    }
    
    public String getSelfLink()
    {
        retunr selfLink;
    }
}
