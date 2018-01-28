package me.androidbox.enershared.billing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.androidbox.enershared.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillingView extends Fragment {
    public static final String TAG = BillingView.class.getName();

    public BillingView() {
        // Required empty public constructor
    }

    public static BillingView newInstance() {
        return new BillingView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.billing_view, container, false);
    }

}
