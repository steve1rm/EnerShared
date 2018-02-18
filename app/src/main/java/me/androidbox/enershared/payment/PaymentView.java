package me.androidbox.enershared.payment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.androidbox.enershared.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentView extends Fragment {
    public static final String TAG = PaymentView.class.getName();

    public PaymentView() {
        // Required empty public constructor
    }

    public static PaymentView newInstance() {
        return new PaymentView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.payment_view, container, false);
    }

}
