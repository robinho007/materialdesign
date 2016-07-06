package cs639.pace.com.cs639sqlite;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

// adb devices
// adb -s num shell
//run-as package
//cd /data/data/package/databases

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            StudentDatabaseHelper dbHelper = new StudentDatabaseHelper(this.getActivity());
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Insert data in student1
            db.execSQL("INSERT INTO student1(name) VALUES ('john')");
            db.execSQL("INSERT INTO student1(name) VALUES ('bill')");

            // select * from student1
            // Retrieving data and print them in Log.i
            Log.i("MyActivity", "select * from student1");
            Cursor cur;
            cur = db.query("student1", null, null, null, null, null, null);
           // this.getActivity().startManagingCursor(cur);
            cur.moveToFirst();
            while (!cur.isAfterLast()) {
                Log.i("AndroidSQLiteHelperDemo",
                        cur.getString(0) + " " + cur.getString(1));
                cur.moveToNext();
            }
            cur.close();

            // select id from student1 where name = 'john'
            // Retrieving data and print them in Log.i
            Log.i("MyActivity", "select * from student1 where name = 'john'");
            Cursor cur1;
            // Retrieving data
            String[] idArray = {"id"};
            cur1 = db.query("student1", idArray, "name='john'", null, null, null, null);
            // this.getActivity().startManagingCursor(cur);
            cur1.moveToFirst();
            while (!cur1.isAfterLast()) {
                Log.i("AndroidSQLiteHelperDemo", "id : " + cur1.getString(0));
                cur1.moveToNext();
            }
            cur1.close();

            return rootView;
        }
    }
}
