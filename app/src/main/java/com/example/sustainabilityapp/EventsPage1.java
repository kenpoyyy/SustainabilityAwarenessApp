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

public class EventsPage1 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_eventpage1; // Back Button
    private ImageView homebtn_eventpage1; // Home Button
    private Button signUpbtn; // Sign Up Button
    TextView eventTitle;
    TextView eventDate;
    TextView eventTime;
    TextView eventInfo;
    TextView eventAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_page1);

        /* Assignment Statement */
        backbtn_eventpage1 = (android.widget.ImageView) findViewById(R.id.backbtn_eventpage1); // Back Button
        homebtn_eventpage1 = (android.widget.ImageView) findViewById(R.id.homebtn_eventpage1); // Home Button
        signUpbtn = findViewById(R.id.eventSignUpbtn1); // Event Sign up
        Fragment fragment = new MapFragment1(); // Google Maps Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.mapView1,fragment).commit();
        eventTitle = findViewById(R.id.eventTitle); // Events Title
        eventDate = findViewById(R.id.eventDate1); // Events Date
        eventTime = findViewById(R.id.eventTime1); // Events Time
        eventInfo = findViewById(R.id.eventInfo1); // Events Info
        eventAge = findViewById(R.id.eventAge1); // Events Age

        /* String Contents "used for TextViews" */
        String Title = "Race on Sunshine - Discovering Solar Energy";
        String Date = "Saturday, 1 July - 26 November 2023";
        String Time = "3:00 PM - 5:00 PM";
        String Info = "Learn more about solar energy and make your own solar-powered car!";
        String Age = "Recommended Age of 8 years old and above";

        /* On Click Listener: Defines what happens when the image is clicked */

        // FOR BACK BUTTON:
        backbtn_eventpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventPage();
            }
        });

        // FOR HOME BUTTON:
        homebtn_eventpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });


        // FOR SIGN-UP BUTTON:
        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Define the URL you want to open
                    String url = "https://www.defencecollectivesg.com/shop/product/ros01adusingle-race-on-sunshine-26314#attr=";

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
        ((MapFragment1) fragment).updateMapWithLocation(1.334653051844768, 103.68144441541662, "Singapore Discovery Center", 15.0f);
    }
    /* On Click Method */

    // FOR BACK BUTTON:
    public void openEventPage() {
        Intent intent = new Intent(this, EventsPage.class);
        startActivity(intent);
    }

    // FOR HOME BUTTON:
    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}