package me.androidbox.enershared.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import di.EnerSharedMainApplication;
import home.HomePresenter;
import home.HomeViewContract;
import me.androidbox.enershared.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeView extends Fragment implements HomeViewContract {
    public static final String TAG = HomeView.class.getName();

    @Inject
    HomePresenter homePresenter;

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
        final View view = inflater.inflate(R.layout.home_view, container, false);

        ((EnerSharedMainApplication)getActivity().getApplication())
                .getApplicationComponent()
                .inject(HomeView.this);

        homePresenter.attachView(HomeView.this);
        
        return view;
    }

    @Override
    public void displayCustomers() {

    }
}
