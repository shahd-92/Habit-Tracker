package com.udacity.shahd.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.udacity.shahd.habittracker.data.HabitContract;
import com.udacity.shahd.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new HabitDbHelper(this);
    }

    public void displayDatabaseInfo(View v) {

        // Perform this raw SQL query "SELECT * FROM habits"
        // to get a Cursor that contains all rows from the habits table.
        Cursor cursor = query();
        try {

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    public void insert(View v) {

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitsEntry.COLUMN_HABIT_NAME, "NAME OF HABIT");
        values.put(HabitContract.HabitsEntry.COLUMN_HABIT_DAY, 0);
        values.put(HabitContract.HabitsEntry.COLUMN_HABIT_DURATION, 30);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(HabitContract.HabitsEntry.TABLE_NAME, null, values);
        if (newRowId >= 0) {
            Log.d(getLocalClassName(), "habits saved with id: " + newRowId);
        } else {
            Log.d(getLocalClassName(), "Error with saving habits");
        }
    }

    private Cursor query() {

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String[] projection = {
                HabitContract.HabitsEntry._ID,
                HabitContract.HabitsEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitsEntry.COLUMN_HABIT_DAY,
                HabitContract.HabitsEntry.COLUMN_HABIT_DURATION
        };
        Cursor cursor = db.query(HabitContract.HabitsEntry.TABLE_NAME, projection, null, null, null, null, null);
        Log.d(getLocalClassName(), "habits total: " + cursor.getCount());
        return cursor;

    }
}
