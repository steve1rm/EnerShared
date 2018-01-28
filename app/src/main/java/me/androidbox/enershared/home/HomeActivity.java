package me.androidbox.enershared.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import me.androidbox.enershared.R;
import me.androidbox.enershared.billing.BillingView;
import me.androidbox.enershared.trading.TradingView;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.homeDrawerLayout);
        navigationView = findViewById(R.id.nvHome);
        setupDrawerContent(navigationView);

/*
        if(savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction
                    = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.home_view_container, HomeView.newInstance(), HomeView.TAG);
            fragmentTransaction.commit();
        }
*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                item -> {
                    selectDrawerItem(item);
                    return true;
                }
        );
    }

    public void selectDrawerItem(final MenuItem menuItem) {
        Fragment fragment;

        switch(menuItem.getItemId()) {
            case R.id.menuBilling:
                fragment = BillingView.newInstance();
                break;

            case R.id.menuTrading:
                fragment = TradingView.newInstance();
                break;

            default:
                fragment = HomeView.newInstance();
                break;
        }

        final FragmentTransaction fragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_view_container, fragment, fragment.getTag());
        fragmentTransaction.commit();

        menuItem.setCheckable(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }
}
