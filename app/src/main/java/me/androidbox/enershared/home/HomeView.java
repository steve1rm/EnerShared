package me.androidbox.enershared.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.androidbox.enershared.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeView extends Fragment {
    public static String TAG = HomeView.class.getName();

    public HomeView() {
        // Required empty public constructor
    }

    public static HomeView newInstance() {
        return new HomeView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_view, container, false);
    }
}
