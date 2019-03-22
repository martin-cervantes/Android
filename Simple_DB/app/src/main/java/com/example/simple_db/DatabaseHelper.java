package com.example.simple_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    String sqlCreate = "CREATE TABLE Alumnos (no_control INTEGER, nombre TEXT, aPaterno TEXT, aMaterno TEXT)";

    public DatabaseHelper(Context contexto, String nombre, CursorFactory factory, int version)
    {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva)
    {
        db.execSQL("DROP TABLE IF EXISTS Alumnos");

        db.execSQL(sqlCreate);
    }
}