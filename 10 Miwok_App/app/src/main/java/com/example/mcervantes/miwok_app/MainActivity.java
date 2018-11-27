package com.example.mcervantes.miwok_app;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;

import android.support.design.widget.TabLayout;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        Categories_Adapter adapter = new Categories_Adapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
    }
}
