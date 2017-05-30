package com.example.mcervantes.petsapp.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mcervantes on 30/05/17.
 */

public class PetDbHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_VERSION = "1";
    public static final String DATABASE_NAME = "pets.db";

    public PetDbHelper()
    {

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
