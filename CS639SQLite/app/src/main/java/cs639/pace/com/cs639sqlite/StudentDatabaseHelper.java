package cs639.pace.com.cs639sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cscharff on 10/29/2014.
 * Creation of the table CREATE TABLE student1(id INTEGER PRIMARY KEY AUTOINCREMENT,
 * name TEXT); in the database student1.db
 */
public class StudentDatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASENAME = "student1.db";
    private static int DATABASEVERSION = 1;

    public StudentDatabaseHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("test1", "test1");
        db.execSQL("CREATE TABLE student1(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");
        Log.i("test2", "test2");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
