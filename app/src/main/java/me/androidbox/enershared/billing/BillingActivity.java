package me.androidbox.enershared.billing;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.androidbox.enershared.R;
import timber.log.Timber;

public class BillingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_container);

        if(getSupportFragmentManager().findFragmentByTag(BillingView.TAG) == null) {
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
