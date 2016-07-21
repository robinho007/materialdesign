package android.scharff.dev.curvedtransition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Scene scene1, scene2;
    int position = 0;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("test test","test test test");
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final ViewGroup vGroup = (ViewGroup) root.findViewById(R.id.scene_root);
        if (vGroup == null){
            Log.i("vGroup", "null");
        } else
        {
            Log.i("vGroup", "not null " + vGroup.toString());

        }

        Button btn = (Button)root.findViewById(R.id.btnCurve);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test", "test");
                scene1 = Scene.getSceneForLayout(vGroup, R.layout.scene1, getActivity().getApplicationContext());
                if (scene1 == null){
                    Log.i("scene1 ", null);
                }
                Log.i("scene1 ", scene1.toString());
                scene2 = Scene.getSceneForLayout(vGroup, R.layout.scene2, getActivity().getApplicationContext());
                if (scene2 == null){
                    Log.i("scene2", null);
                }
                Log.i("scene 2", scene2.toString());

                if (position == 0) {
                    Transition transition = TransitionInflater.from(getActivity().getApplicationContext()).inflateTransition(R.transition.transition);
                    if (transition == null) {
                        Log.i("transition", null);
                    }
                    TransitionManager.go(scene2, transition);
                    position = 1;
                }
                else {
                    Transition transition2 = TransitionInflater.from(getActivity().getApplicationContext()).inflateTransition(R.transition.transition2);
                    if (transition2 == null) {
                        Log.i("transition2", null);
                    }
                    TransitionManager.go(scene1, transition2);
                    position = 0;
                }

            }
        });

        return root;
    }
}
