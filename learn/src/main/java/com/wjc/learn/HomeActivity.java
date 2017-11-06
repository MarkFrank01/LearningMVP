package com.wjc.learn;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wjc.learn.ui.first.FirstFragment;
import com.wjc.learn.ui.first.FirstPresenter;
import com.wjc.learn.ui.first.ToFindItemsInteractorImpl;
import com.wjc.learn.ui.second.SecondFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawer;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    private static final String KEY_NAV_ITEM = "CURRENT_NAV_ITEM";

    private int selectedNavItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();


        if (savedInstanceState != null) {
            firstFragment = (FirstFragment) getSupportFragmentManager().getFragment(savedInstanceState, "firstFragment");
            secondFragment = (SecondFragment) getSupportFragmentManager().getFragment(savedInstanceState, "secondFragment");
            selectedNavItem = savedInstanceState.getInt(KEY_NAV_ITEM);
        } else {
            firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.content_main);
            if (savedInstanceState == null) {
                firstFragment = FirstFragment.newInstance();
            }

            secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.content_main);
            if (savedInstanceState == null) {
                secondFragment = SecondFragment.newInstance();
            }
        }

        if (!firstFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, firstFragment, "firstFragment")
                    .commit();
        }

        if (!secondFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, secondFragment, "secondFragment")
                    .commit();
        }

        new FirstPresenter(firstFragment,new ToFindItemsInteractorImpl());


        // Show the default fragment.

        if (selectedNavItem == 0) {
            showFirstFragment();
        } else if (selectedNavItem == 1) {
            showSecondFragment();
        }
    }

    /**
     * Close the drawer when a back click is called.
     */
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.one) {
            showFirstFragment();
        } else if (id == R.id.two) {
            showSecondFragment();
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Store the state when the activity may be recycled.
     * @param outState The state data.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Menu menu = navigationView.getMenu();
        if (menu.findItem(R.id.one).isChecked()) {
            outState.putInt(KEY_NAV_ITEM, 0);
        } else if (menu.findItem(R.id.two).isChecked()) {
            outState.putInt(KEY_NAV_ITEM, 1);
        }
        // Store the fragments' states.
        if (firstFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "PackagesFragment", firstFragment);
        }
        if (secondFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "CompaniesFragment", secondFragment);
        }
    }


    private void showFirstFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(firstFragment);
        fragmentTransaction.hide(secondFragment);
        fragmentTransaction.commit();

        toolbar.setTitle(getResources().getString(R.string.first_frag));
        navigationView.setCheckedItem(R.id.one);
    }

    private void showSecondFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(secondFragment);
        fragmentTransaction.hide(firstFragment);
        fragmentTransaction.commit();

        toolbar.setTitle(getResources().getString(R.string.second_frag));
        navigationView.setCheckedItem(R.id.two);
    }

}
