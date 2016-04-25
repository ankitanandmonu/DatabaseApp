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
public class StoresHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "starbuzz3"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    StoresHelper(Context context) {
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
            db.execSQL("CREATE TABLE STORE (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertStores(db, "ToothPaste", "Various companies toothpaste are available", R.drawable.toothpaste);
            insertStores(db, "Biscuits", "All Flavours are available",
                    R.drawable.britannia_biscuits);
        }
        insertStores(db, "EveryDayUse", "All things are available of everyday use.", R.drawable.kirana_shops);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE STORE ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertStores(SQLiteDatabase db, String name,
                                   String description, int resourceId) {
        ContentValues storesValues = new ContentValues();
        storesValues.put("NAME", name);
        storesValues.put("DESCRIPTION", description);
        storesValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("STORE", null, storesValues);
    }
}
