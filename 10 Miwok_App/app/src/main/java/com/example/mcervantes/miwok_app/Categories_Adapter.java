package com.example.mcervantes.miwok_app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Categories_Adapter extends FragmentPagerAdapter
{
    private Context mContext;

    public Categories_Adapter(Context context, FragmentManager fm)
    {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0)
        {
            return new fNumbers();
        }
        else if (position == 1)
        {
            return new fFamily_Members();
        }
        else if(position==2)
        {
            return new fColors();
        }
        else
        {
            return new fPhrases();
        }
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        if (position == 0)
        {
            return mContext.getString(R.string.category_numbers);
        }
        else if (position == 1)
        {
            return mContext.getString(R.string.category_family);
        }
        else if(position==2)
        {
            return mContext.getString(R.string.category_colors);
        }
        else
        {
            return mContext.getString(R.string.category_phrases);
        }
    }
}
