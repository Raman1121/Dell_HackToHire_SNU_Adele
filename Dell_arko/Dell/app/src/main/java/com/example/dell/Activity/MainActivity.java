package com.example.dell.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.dell.Adapter.ItemsAdapter;
import com.example.dell.Class.Items;
import com.example.dell.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int maxHeight = getMaxWindowHeight(getApplicationContext());

        int position = 0;
        Intent intent = getIntent();
        if(intent != null){
            position = intent.getIntExtra("position",0);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setImageDrawable(getDrawable(R.drawable.chatbot));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Chatbot.class);
                startActivity(intent1);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayList<Items> itemsArrayList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        itemsArrayList.add(new Items("LG Electronics G Watch", "LG G Smart Watch for select Android devices. Bluetooth 4.0 technology lets you easily sync with your compatible Android device to this LG G Watch, so you can receive and view important mobile notifications"
                , "110.99","3.8", R.drawable.wearable1));
        itemsArrayList.add(new Items("Fossil Q Wander Silicone Touchscreen Smartwatch", "Q Wander is our newest digital display watch that connects seamlessly to your phone."
                , "255","4.5", R.drawable.wearable2));
        itemsArrayList.add(new Items("Apple Watch Nike", "Like all Apple Watch Series 2 models, Apple Watch Nike+ has built-in GPS to track your pace, distance, and route — even if you don’t have your iPhone with you"
                , "439.99","5", R.drawable.wearable3));
        itemsArrayList.add(new Items("SAMSUNG Gear Fit2 SM-R360", "When you’re looking for motivation to stay at your best, the Samsung Gear Fit2 keeps you going. It automatically recognizes whatever you’re doing—from walking up a flight of stairs to working out at the gym"
                , "119.99","4", R.drawable.wearable4));
        itemsArrayList.add(new Items("Motorola Moto 360", "The Motorola Moto 360 Smartwatch comes with a 22mm black leather strap, runs on the Android Wear operating system and connects to your Android smartphone via Bluetooth to give you the information you need"
                , "99.99","3.5", R.drawable.wearable5));
        itemsArrayList.add(new Items("LONSUN TW64", "LONSUN TW64 Smart Watch TopBest Bluetooth Bracelet Call Remind Remote self-timer Smart band Calorie Counter Wireless Pedometer Sport Sleep Monitor Activity Tracker For Android IOS Phone (Black)"
                , "13.99","2", R.drawable.wearable6));
        itemsArrayList.add(new Items("LEMFO LEM5", "Frequency Band: 2G: GSM 850 900 1900 2100/ 3G: WCDMA 850 1900 2100 SIM: NANO SIM Operating system: Android 5.1 RAM: 1GB ROM: 8GB CPU: MTK6580 CPU SPEED: 1.3G Quad core SCREEN SIZE: 1.39\" IPS OLED Touc"
                , "129.99","3.8", R.drawable.wearable7));
        itemsArrayList.add(new Items("Luxsure Uwatch", "Luxsure Uwatch Smart Watch with Heart Rate Monitor Android Smart Watch Phone Sports Bluetooth Wristwatch With 3G magsensor gravity sensor Compatible With IOS & Android (Silver)"
                , "68.99","3.4", R.drawable.wearable8));
        ItemsAdapter itemsAdapter = new ItemsAdapter(MainActivity.this, itemsArrayList, false);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        if (position != 0){
            recyclerView.scrollToPosition(position);
        }
        recyclerView.setAdapter(itemsAdapter);



    }

    private int getMaxWindowHeight(Context context) {
        WindowManager windowmanager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dimension = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(dimension);
        final int height = dimension.heightPixels;
        return height;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();

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
        if (id == R.id.analytics) {
            openAnalytics();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openAnalytics(){
        Intent i = new Intent(MainActivity.this, analytics.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.order) {
            // Handle the camera action
        } else if (id == R.id.recommendation) {

            Intent intent = new Intent(MainActivity.this, Recommend.class);
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.auto_reorder) {
            Intent intent = new Intent(MainActivity.this, Reorder.class);
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
