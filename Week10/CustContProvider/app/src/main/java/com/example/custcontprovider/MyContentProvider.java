package com.example.custcontprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {

    static final String name = "name";
    static final String id = "id";
    static String PROVNAME = "com.example.custcontprovider";
    static final Uri CONTENT_URI = Uri.parse("content://" + PROVNAME + "/user");

    static final UriMatcher umar;
    static {
        umar = new UriMatcher(UriMatcher.NO_MATCH);
        umar.addURI(PROVNAME, "users", 1);
        umar.addURI(PROVNAME, "users/*", 1);
    }

    public MyContentProvider() {
    }
    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        Context ct = getContext();
        DatabaseHelper databaseHelper = new DatabaseHelper(ct);
        db = databaseHelper.getWritableDatabase();
        return db == null ? false : true ;
    }
    private static SQLiteDatabase db;

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        long rowId = db.insert("users", "", values);
        if (rowId > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static HashMap<String, String > hm;
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables("users");
        switch (umar.match(uri)){
            case 1:
                qb.setProjectionMap(hm);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        if ( sortOrder==null || sortOrder=="") sortOrder = id;

        Cursor cursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Database


    static final String CREATE_DB_TABLE = "CREATE TABLE " + "Users"
            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " name TEXT NOT NULL);";

    private static final class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(@Nullable Context context) {
            super(context, "users", null, 11);

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ " UserDB ");
            onCreate(db);
        }
    }
}