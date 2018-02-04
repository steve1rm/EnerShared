package me.androidbox.enershared.home;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_container);

        toolbar = findViewById(R.id.tbHome);
        toolbar.setTitle(R.string.home);
        setSupportActionBar(toolbar);

        final NavigationView navigationView = findViewById(R.id.nvHome);
        setupDrawerContent(navigationView);

        drawerLayout = findViewById(R.id.homeDrawerLayout);
        actionBarDrawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        commitFragmentTransaction(HomeView.newInstance(), HomeView.TAG);
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

    public void selectDrawerItem(final MenuItem menuItem) {
        Fragment fragment;
        String tag;

        switch(menuItem.getItemId()) {
            case R.id.menuBilling:
                fragment = BillingView.newInstance();
                tag = BillingView.TAG;
                break;

            case R.id.menuTrading:
                fragment = TradingView.newInstance();
                tag = TradingView.TAG;
                break;

            default:
                fragment = HomeView.newInstance();
                tag = HomeView.TAG;
                break;
        }

        commitFragmentTransaction(fragment, tag);

        menuItem.setCheckable(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }

    private void commitFragmentTransaction(final Fragment fragment, final String tag) {
        final FragmentTransaction fragmentTransaction
                = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.home_view_container, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                item -> {
                    selectDrawerItem(item);
                    return true;
                });
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(
                HomeActivity.this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
    }
}
