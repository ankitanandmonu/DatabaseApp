package org.drupalchamp.createdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user
 * Date: 4/25/2016
 * CreateDatabase
 */
public class FoodHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "starbuzz1"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    FoodHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE FOOD (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertFood(db, "Burger", "Burger with spicy & crispy chicken", R.drawable.burger);
            insertFood(db, "Salad", "Mix of Various vegetables & fruits",
                    R.drawable.salad);
        }
        insertFood(db, "Samose", "Spicy and pappery", R.drawable.samose);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE FOOD ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertFood(SQLiteDatabase db, String name,
                                    String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("FOOD", null, drinkValues);
    }
}
