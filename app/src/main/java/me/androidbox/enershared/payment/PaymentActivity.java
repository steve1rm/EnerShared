package me.androidbox.enershared.payment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.androidbox.enershared.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_container);

        if(getSupportFragmentManager().findFragmentByTag(PaymentView.TAG) == null) {
            final FragmentTransaction fragmentTransaction
                    = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(
                    R.id.payment_view_container,
                    PaymentView.newInstance(),
                    PaymentView.TAG);

            fragmentTransaction.commit();
        }
    }
}
