package com.example.mcervantes.newsapp;

/**
 * Created by mcervantes on 6/16/17.
 */

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

  public String getSEction()
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
