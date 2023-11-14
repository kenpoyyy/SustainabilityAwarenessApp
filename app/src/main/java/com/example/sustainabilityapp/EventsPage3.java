package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventsPage3 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_eventpage3; // Back Button
    private Button signUpbtn3; // Sign Up Button
    TextView eventTitle;
    TextView eventDate;
    TextView eventTime;
    TextView eventInfo;
    TextView eventAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_page3);

        /* Assignment Statement */
        backbtn_eventpage3 = (android.widget.ImageView) findViewById(R.id.backbtn_eventpage3); // Back Button
        signUpbtn3 = findViewById(R.id.eventSignUpbtn3); // Event Sign up
        eventTitle = findViewById(R.id.eventTitle); // Events Title
        eventDate = findViewById(R.id.eventDate1); // Events Date
        eventTime = findViewById(R.id.eventTime1); // Events Time
        eventInfo = findViewById(R.id.eventInfo1); // Events Info
        eventAge = findViewById(R.id.eventAge1); // Events Age

        /* String Contents "used for TextViews" */
        String Title = "Turning Waste To Energy: Tuasone Waste-To-Energy Plant Tour";
        String Date = "Tuesday, 11 July - 28 November 2023";
        String Time = "1:30 PM - 4:30 PM";
        String Info = "Discover how Singapore efficiently manages its daily waste, reducing solid " +
                "waste by 90% while simultaneously generating power.";
        String Age = "Minimum Age of 13 years old";

        /* On Click Listener: Defines what happens when the image is clicked */
        // FOR BACK BUTTON:
        backbtn_eventpage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventPage();
            }
        });
        // FOR SIGN-UP BUTTON:
        signUpbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Define the URL you want to open
                    String url = "https://www.eventbrite.sg/e/turning-waste-to-energy-tuasone-waste-to-energy-plant-tour-tickets-643582170597";

                    // Create an Intent with ACTION_VIEW and the URL
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    // Start the activity with the Intent
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /* Method calling */
        eventTitle.setText(Title);
        eventDate.setText(Date);
        eventTime.setText(Time);
        eventInfo.setText(Info);
        eventAge.setText(Age);
    }
    /* On Click Method */
    public void openEventPage() {
        Intent intent = new Intent(this, EventsPage.class);
        startActivity(intent);
    }
}