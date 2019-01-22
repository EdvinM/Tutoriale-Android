package ro.ramonnastase.tutorialeandroid.NavigationItems.ViewPagerFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.ramonnastase.tutorialeandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {


    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag3, container, false);
    }

}
