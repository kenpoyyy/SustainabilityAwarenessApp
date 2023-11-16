package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventsPage2 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_eventpage2; // Back Button
    private Button signUpbtn2; // Sign Up Button
    TextView eventTitle;
    TextView eventDate;
    TextView eventTime;
    TextView eventInfo;
    TextView eventAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_page2);

        /* Assignment Statement */
        backbtn_eventpage2 = (android.widget.ImageView) findViewById(R.id.backbtn_eventpage2); // Back Button
        signUpbtn2 = findViewById(R.id.eventSignUpbtn2); // Event Sign up
        Fragment fragment = new MapFragment2(); // Google Maps Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.mapView2,fragment).commit();
        eventTitle = findViewById(R.id.eventTitle); // Events Title
        eventDate = findViewById(R.id.eventDate1); // Events Date
        eventTime = findViewById(R.id.eventTime1); // Events Time
        eventInfo = findViewById(R.id.eventInfo1); // Events Info
        eventAge = findViewById(R.id.eventAge1); // Events Age

        /* String Contents "used for TextViews" */
        String Title = "CREUSE Wood Upcycling Journey";
        String Date = "Saturday, 8 July - 18 November 2023";
        String Time = "10:00 AM - 12:00 PM";
        String Info = "See how damaged wooden pallets that are seemingly beyond repair can be " +
                "transformed into useful lifestyle products. ";
        String Age = "Recommended Age of 9 years old and above";

        /* On Click Listener: Defines what happens when the image is clicked */
        // FOR BACK BUTTON:
        backbtn_eventpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventPage();
            }
        });
        // FOR SIGN-UP BUTTON:
        signUpbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Define the URL you want to open
                    String url = "https://www.eventbrite.sg/e/creuse-wood-upcycling-journey-tickets-643561809697";

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

        // Call the updateMapWithLocation method with a specific zoom level
        ((MapFragment2) fragment).updateMapWithLocation(1.3255998686515635, 103.68775233108889, "Xcel Industrial Supplies Pte Ltd", 15.0f);
    }
    /* On Click Method */
    public void openEventPage() {
        Intent intent = new Intent(this, EventsPage.class);
        startActivity(intent);
    }
}