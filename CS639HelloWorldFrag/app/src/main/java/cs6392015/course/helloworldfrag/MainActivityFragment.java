package cs6392015.course.helloworldfrag;

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

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button b = (Button)rootView.findViewById(R.id.btn);
        if (b == null){
            Log.i("MainActivityFragment", "The button is null");
        } else{
            Log.i("MainActivityFragment", "The button is not null");
        }
        b.setOnClickListener( new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Log.i("MainActivityFragment", "The button is clicked!");
                                      Toast t = Toast.makeText(getActivity().getApplicationContext(), "The button is clicked", Toast.LENGTH_LONG);
                                      t.show();
                                  }
                              }
        );
        return rootView;
    }
}
