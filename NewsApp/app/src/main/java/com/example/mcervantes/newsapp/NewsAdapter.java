package com.example.mcervantes.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News>
{
    public NewsAdapter(Context context, List<News> earthquakes)
    {
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);

        titleView.setText(currentNews.getTitle());

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);

        sectionView.setText(currentNews.getSection());

        return listItemView;
    }
}
