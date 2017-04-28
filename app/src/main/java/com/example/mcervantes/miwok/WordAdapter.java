package com.example.mcervantes.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mcervantes on 24/04/17.
 */

public class WordAdapter extends ArrayAdapter<Word>
{
    private int colorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int resourceID)
    {
        super(context, 0, words);

        colorResourceID = resourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage())
        {
            iconView.setImageResource(currentWord.getImageResourceID());

            iconView.setVisibility(View.VISIBLE);
        }
        else
        {
            iconView.setVisibility(View.GONE);
        }

        View textContainer =  listItemView.findViewById(R.id.item);

        textContainer.setBackgroundResource(colorResourceID);

        return listItemView;
    }
}
