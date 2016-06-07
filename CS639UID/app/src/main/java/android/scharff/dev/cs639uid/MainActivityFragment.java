package android.scharff.dev.cs639uid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String MAIN_ACTIVITY_FRAGMENT = "MainActivityFragment";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnClickMe = (Button)rootView.findViewById(R.id.btnClickMe);
        if (btnClickMe == null){
            Log.i(MAIN_ACTIVITY_FRAGMENT, "The button is null");
        } else{
            Log.i(MAIN_ACTIVITY_FRAGMENT, "The button is not null");
        }
        btnClickMe.setOnClickListener( new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Log.i(MAIN_ACTIVITY_FRAGMENT, "The button is clicked!");
                                      Toast t = Toast.makeText(getActivity().getApplicationContext(), "The button is clicked", Toast.LENGTH_LONG);
                                      t.show();
                                  }
                              }
        );

        return rootView;
    }
}
