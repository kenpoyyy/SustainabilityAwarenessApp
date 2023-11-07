package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EventsPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_eventpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_page);

        /* Assignment Statement */
        backbtn_eventpage = (android.widget.ImageView) findViewById(R.id.backbtn_eventpage);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_eventpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage();
            }
        });
    }
    /* Method */
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}