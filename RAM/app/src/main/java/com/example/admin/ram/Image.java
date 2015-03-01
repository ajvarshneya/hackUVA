package com.example.admin.ram;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.Random;


public class Image extends ActionBarActivity {

    ImageView iv;
    Random randomGenerator = new Random();

    //int min = 1; //To give randomGenerator a range
    //int randomRamInt = randomGenerator.nextInt(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        iv = (ImageView) findViewById(R.id.ram_image);

        Random generator = new Random();
        int rand = generator.nextInt(R.integer.max_rams) + 1;
        loadImage("ram" + rand);

        /*
        //The + 1 is because .nextInt is exclusive
        String randomRamID = "ram" + Integer.toString(randomGenerator.nextInt(max - min + 1) + min);
        loadImage(randomRamID);
        */
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
        Picasso.with(this).load("http://swaha.me/images/" + id + ".jpg").placeholder(R.drawable.ic_launcher).into(iv);
    }
}
