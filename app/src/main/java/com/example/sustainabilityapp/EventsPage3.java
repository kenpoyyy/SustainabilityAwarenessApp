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

public class EventsPage3 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_eventpage3; // Back Button
    private ImageView homebtn_eventpage3; // Home Button
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
        homebtn_eventpage3 = (android.widget.ImageView) findViewById(R.id.homebtn_eventpage3); // Home Button
        signUpbtn3 = findViewById(R.id.eventSignUpbtn3); // Event Sign up
        Fragment fragment = new MapFragment3(); // Google Maps Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.mapView3,fragment).commit();
        eventTitle = findViewById(R.id.eventTitle); // Events Title
        eventDate = findViewById(R.id.eventDate1); // Events Date
        eventTime = findViewById(R.id.eventTime1); // Events Time
        eventInfo = findViewById(R.id.eventInfo1); // Events Info
        eventAge = findViewById(R.id.eventAge1); // Events Age

        /* String Contents "used for TextViews" */
        String Title = "Where Singapore’s waste goes: A tour of Semakau Landfill";
        String Date = "Saturday, 22 July - 30 November 2023";
        String Time = "9:30 AM - 4:30 PM";
        String Info = "A remarkable feat of engineering and a sanctuary for diverse wildlife, " +
                "seize the unique chance to explore Semakau, Singapore's offshore landfill.";
        String Age = "Minimum Age of 7 years old";

        /* On Click Listener: Defines what happens when the image is clicked */

        // FOR BACK BUTTON:
        backbtn_eventpage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventPage();
            }
        });

        // FOR HOME BUTTON:
        homebtn_eventpage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openHomePage(); }
        });

        // FOR SIGN-UP BUTTON:
        signUpbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Define the URL you want to open
                    String url = "https://www.eventbrite.sg/e/where-singapores-waste-goes-a-tour-of-semakau-landfill-tickets-643575831637";

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
        ((MapFragment3) fragment).updateMapWithLocation(1.2701833381781908, 103.79598791551251, "Pasir Panjang Ferry Terminal", 15.0f);
    }
    /* On Click Method */

    // FOR BACK BUTTON
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