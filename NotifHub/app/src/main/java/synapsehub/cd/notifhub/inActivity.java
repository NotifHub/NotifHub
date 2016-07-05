package synapsehub.cd.notifhub;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

import synapsehub.cd.notifhub.fragment.AnnoncesFragment;
import synapsehub.cd.notifhub.fragment.CompteFragment;
import synapsehub.cd.notifhub.fragment.HomeFragment;
import synapsehub.cd.notifhub.fragment.LoginFragment;

import static java.security.AccessController.getContext;


public class inActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar tbr;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private static FragmentManager fragmentManager;
    private String user_id;
    TextView headerTxtUsern;
    TextView headerTxtMail;

    private FirebaseAnalytics mAFirebaseAnalytics;
    private FirebaseAuth fireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        fireAuth=FirebaseAuth.getInstance();

        user_id = NothifHubApplication.prefs.getString(Config.PREFS_USERIDentity, null);


        setContentView(R.layout.activity_in);

        //Setup de la toolbar

       /* tbr = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(tbr);

        //Drawer View setup
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        nvDrawer = (NavigationView) findViewById(R.id.slider_menu);
        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });*/

        initViews();

        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });

        //Setup the header view
        setUpHeaderView();
        headerTxtMail.setText(user_id);



    }

    //Setup the header view
    private void setUpHeaderView() {

        View headerView = nvDrawer.inflateHeaderView(R.layout.nvheader);
        headerTxtUsern = (TextView) headerView.findViewById(R.id.username);
        headerTxtMail = (TextView) headerView.findViewById(R.id.email_address);
    }

    /*  Init all views  */
    private void initViews() {
        tbr = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(tbr);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.slider_menu);
        fragmentManager = getSupportFragmentManager();
        drawerToggle = new ActionBarDrawerToggle(this,
                mDrawer, tbr, // nav menu toggle icon
                R.string.drawer_open, // nav drawer open - description for
                // accessibility
                R.string.drawer_close // nav drawer close - description for
                // accessibility
        ) {
            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View drawerView) {

            }
        };
        mDrawer.setDrawerListener(drawerToggle);

    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, tbr, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

/*
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
*/

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }


    //Selection d'un menu de la navigation drawer
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_account:
                fragment = new CompteFragment();
                break;
            case R.id.nav_announce:
                fragment = new AnnoncesFragment();
                break;
            case R.id.nav_all_announces:
                fragment = new HomeFragment();
                break;
            case R.id.nav_mes_annonces:
                fragment = new HomeFragment();
                break;
            case R.id.nav_about:
                fragment = new HomeFragment();
                break;
            case R.id.nav_search:
                fragment = new CompteFragment();
                break;
            case R.id.nav_settings:
                fragment = new CompteFragment();
                break;
            /*
            case R.id.nav_exit:
                fireAuth.signOut();
                String emptyPrefs="";
                NothifHubApplication.prefs.edit().putString(Config.PREFS_USERIDentity,emptyPrefs.toString()).commit();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
                */
            default:
                fragment = new HomeFragment();
        }


        if (fragment != null) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.flContent, fragment).commit();

            // Highlight the selected item has been done by NavigationView
            menuItem.setChecked(true);
            // Set action bar title
            setTitle(menuItem.getTitle());
            // Close the navigation drawer
            mDrawer.closeDrawers();
        } else {
            Log.e("inActivity", "Error in creating the fragment");
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // s'applique lors de n'importe quel changement sur le drawer
        drawerToggle.onConfigurationChanged(newConfig);
    }
}