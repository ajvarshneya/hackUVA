package com.example.admin.ram;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class Image extends ActionBarActivity {

    ImageView iv;

    //int min = 1; //To give randomGenerator a range
    //int randomRamInt = randomGenerator.nextInt(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        iv = (ImageView) findViewById(R.id.ram_image);

        int max = getResources().getInteger(R.integer.max_rams);

        Random generator = new Random();
        int rand = generator.nextInt(max) + 1;
        loadImage("ram" + rand);

        //TextView textView = (TextView) findViewById(R.id.tv_image);

        //textView.setText("" + max);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
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

    // loads specified image into image view
    public void loadImage(String id) {
        Picasso.with(this).load("http://swaha.me/images/" + id + ".jpg").fit().into(iv);
    }
}
