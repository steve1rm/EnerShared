package me.androidbox.enershared.billing;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import me.androidbox.enershared.R;
import me.androidbox.enershared.core.FragmentRetriever;
import me.androidbox.enershared.core.FragmentRetrieverImp;

public class BillingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_container);

        FragmentRetriever fragmentRetriever = new FragmentRetrieverImp();

        if(fragmentRetriever.getFragment(getSupportFragmentManager(), BillingView.TAG) == null) {
            final FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(
                    R.id.billing_view_container,
                    BillingView.newInstance(),
                    BillingView.TAG);

            fragmentTransaction.commit();
        }
    }
}
