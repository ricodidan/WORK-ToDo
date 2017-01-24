package id.sch.smktelkom_mlg.worktodo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Enrico_Didan on 23/01/2017.
 */

public class Main_menu extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.main_layout, container, false);
        return myView;
    }
}
