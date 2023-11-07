package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DRGPage5 extends AppCompatActivity {

    /* Variable Declaration */
    TextView drgpage5header;
    TextView drgpage5content;
    TextView drgpage5content2;
    TextView drgpage5citation;
    private ImageView backbtn_drgpage5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drgpage5);

        /* Assignment Statement */
        drgpage5header = findViewById(R.id.drgpage5header);
        drgpage5content = findViewById(R.id.drgpage5content);
        drgpage5content2 = findViewById(R.id.drgpage5content2);
        drgpage5citation = findViewById(R.id.drgpage5citation);
        backbtn_drgpage5 = (android.widget.ImageView) findViewById(R.id.backbtn_drgpage5);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_drgpage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrgPage();
            }
        });

        /* String Contents "used for TextViews" */
        String header = "The Recycling Collection Process";

        String content = "As part of the National Recycling Programme (NRP) initiated in April 2001, " +
                "licensed public waste collectors (PWCs) under the NEA must offer recycling bins and collection services for HDB estates, " +
                "private landed properties, and condos/apartments participating in the public waste collection program.\n\n" +
                "The NRP employs a collection method where paper, plastic, glass, and metal recyclables are placed together in a single " +
                "blue recycling bin for pickup by the licensed public waste collectors (PWCs).";

        String content2 = "1. Recyclable materials are collected with a dedicated recycling truck and taken to a Materials Recovery Facility (MRF) for processing. \n\n" +
                "2. Recyclables at the MRF will be separated into paper, glass, metal, and plastic categories \n\n" +
                "3. Each waste category is organized and then compacted into bundles. \n\n" +
                "4. The bundles are subsequently transported to recycling facilities for the purpose of recycling.";

        String citation = "Link: https://www.towardszerowaste.gov.sg/recycle/\n\n";

        /* Method calling */
        drgpage5header.setText(header);
        drgpage5content.setText(content);
        drgpage5content2.setText(content2);
        drgpage5citation.setText(citation);
    }
    /* On Click Method */
    public void openDrgPage() {
        Intent intent = new Intent(this, DRGPage.class);
        startActivity(intent);
    }
}