package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EventsPage2 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_eventpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_page2);

        /* Assignment Statement */
        backbtn_eventpage2 = (android.widget.ImageView) findViewById(R.id.backbtn_eventpage2);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_eventpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventPage();
            }
        });
    }
    /* On Click Method */
    public void openEventPage() {
        Intent intent = new Intent(this, EventsPage.class);
        startActivity(intent);
    }
}