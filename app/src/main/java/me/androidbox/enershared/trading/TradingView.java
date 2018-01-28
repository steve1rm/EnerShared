package me.androidbox.enershared.trading;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.androidbox.enershared.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TradingView extends Fragment {
    public static final String TAG = TradingView.class.getName();

    public TradingView() {
        // Required empty public constructor
    }

    public static TradingView newInstance() {
        return new TradingView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
