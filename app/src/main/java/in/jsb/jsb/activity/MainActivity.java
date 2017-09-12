package in.jsb.jsb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import in.jsb.jsb.R;
import in.jsb.jsb.util.AppConnectivity;
import in.jsb.jsb.util.IdentifyDevice;
import in.jsb.jsb.util.UtilShare;
import in.jsb.jsb.util.UtilsPhone;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feedbackMessage= "Device Info:-"+"\n \n "+"Operator Name:-"+AppConnectivity.operatorName(MainActivity.this)  +"\n"+"Network Type:-"+
                        AppConnectivity.getNetworkClass(MainActivity.this)+"\n"+"Device ID:-"+ IdentifyDevice.getDeviceId(MainActivity.this)
                        +"\n"+"Device Name:-"+ UtilsPhone.getDeviceName()
                        +"\n"+"App Version:-"+UtilsPhone.getApplicationVersionCode(MainActivity.this)+"\n"
                        +"Carrier Name:-"+UtilsPhone.getDeviceCarrier(MainActivity.this)
                        +"\n"+"Device Model:-"+UtilsPhone.getDeviceModel()+"\n"
                        +"Device Country:-"+UtilsPhone.getCountryDesplayName(MainActivity.this);

                UtilShare.sendFeedBackEmail(MainActivity.this, feedbackMessage, "Feedback Caaring app");


                /*Snackbar.make(view, "Work in progress", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        findViewById(R.id.tv_action_gr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GRGenerationActivity.class));
            }
        });
        findViewById(R.id.tv_action_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GRGenerationActivity.class));
            }
        });
        findViewById(R.id.tv_action_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GRGenerationActivity.class));
            }
        });
        findViewById(R.id.tv_action_gr1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GRGenerationActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
