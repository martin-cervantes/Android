package com.example.mcervantes.newsapp;

public class News
{
  private String section;

  private String title;

  private String url;

  public News(String sec, String ti, String u)
  {
    section = sec;

    title = ti;

    url = u;
  }

  public String getSection()
  {
    return section;
  }

  public String getTitle()
  {
    return title;
  }

  public String getUrl()
  {
    return url;
  }
}
