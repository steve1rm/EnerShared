package me.androidbox.enershared.billing;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import me.androidbox.enershared.R;
import me.androidbox.enershared.core.FragmentManagerRetriever;
import me.androidbox.enershared.core.FragmentManagerRetrieverImp;
import timber.log.Timber;

public class BillingActivity extends AppCompatActivity {
    FragmentManagerRetriever fragmentRetriever = new FragmentManagerRetrieverImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_container);

        final FragmentManager fragmentManager = fragmentRetriever.getFragmentManager(BillingActivity.this);

        if(fragmentManager.findFragmentByTag(BillingView.TAG) == null) {
            final FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();

            fragmentTransaction.add(
                    R.id.billing_view_container,
                    BillingView.newInstance(),
                    BillingView.TAG);

            fragmentTransaction.commit();
        }
        else {
            Timber.w("Already attached");
        }
    }
}
