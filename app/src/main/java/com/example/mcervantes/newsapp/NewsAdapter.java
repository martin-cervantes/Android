package com.example.mcervantes.newsapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by mcervantes on 7/5/17.
 */

public class NewsAdapter extends ArrayAdapter<News>
{
    public NewsAdapter(Context context, List<News> earthquakes)
    {
        super(context, 0, earthquakes);
    }
}
