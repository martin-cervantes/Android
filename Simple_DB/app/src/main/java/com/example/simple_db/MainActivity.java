package com.example.simple_db;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btn_insert;
    Button btn_select;
    Button btn_delete;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_insert = findViewById(R.id.insert);
        btn_select = findViewById(R.id.select);
        btn_delete =  findViewById(R.id.delete);
        btn_update = findViewById(R.id.update);

        btn_insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatabaseHelper myDBHelper = new DatabaseHelper(MainActivity.this, "Alumnos", null, 1);

                SQLiteDatabase db = myDBHelper.getWritableDatabase();

                if(db != null)
                {
                    db.execSQL("INSERT INTO Alumnos (no_control, nombre, aPaterno, aMaterno) VALUES ( 184210, 'Martin', 'Cervantes', 'Palomo')");

                    Toast.makeText(MainActivity.this, "Registro Guardado", Toast.LENGTH_LONG).show();

                    db.close();
                }
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String registros = "";

                DatabaseHelper myDBHelper = new DatabaseHelper(MainActivity.this, "Alumnos", null, 1);

                SQLiteDatabase db = myDBHelper.getWritableDatabase();

                Cursor cursor = db.rawQuery("SELECT * FROM Alumnos", null);

                if (cursor.moveToFirst())
                {
                    do
                    {
                        registros += cursor.getInt(cursor.getColumnIndex("no_control"));
                        registros += cursor.getString(cursor.getColumnIndex("nombre"));
                        registros += "\n";
                    } while (cursor.moveToNext());
                }

                Toast.makeText(MainActivity.this, registros,Toast.LENGTH_LONG).show();

                db.close();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatabaseHelper myDBHelper = new DatabaseHelper(MainActivity.this, "Alumnos", null, 1);

                SQLiteDatabase db = myDBHelper.getWritableDatabase();

                if(db != null)
                {
                    db.execSQL("DELETE FROM Alumnos WHERE no_control = 184210");

                    Toast.makeText(MainActivity.this, "Registro Borrado", Toast.LENGTH_LONG).show();

                    db.close();
                }
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatabaseHelper myDBHelper = new DatabaseHelper(MainActivity.this, "Alumnos", null, 1);

                SQLiteDatabase db = myDBHelper.getWritableDatabase();

                if(db != null)
                {
                    db.execSQL("UPDATE Alumnos SET no_control = 151245 WHERE no_control = 184210");

                    Toast.makeText(MainActivity.this, "Registro Actualizado", Toast.LENGTH_LONG).show();

                    db.close();
                }
            }
        });
    }
}
