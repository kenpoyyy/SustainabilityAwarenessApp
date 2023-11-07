package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DRGPage1 extends AppCompatActivity {

    /* Variable Declaration */
    TextView drgpage1header2;
    TextView drgpage1header3;
    TextView drgpage1content;
    TextView drgpage1content2;
    TextView drgpage1citation;
    private ImageView backbtn_drgpage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drgpage1);

        /* Assignment Statement */
        drgpage1header2 = findViewById(R.id.drgpage1header2);
        drgpage1header3 = findViewById(R.id.drgpage1header3);
        drgpage1content = findViewById(R.id.drgpage1content);
        drgpage1content2 = findViewById(R.id.drgpage1content2);
        drgpage1citation = findViewById(R.id.drgpage1citation);
        backbtn_drgpage1 = (android.widget.ImageView) findViewById(R.id.backbtn_drgpage1);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_drgpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrgPage();
            }
        });

        /* String Contents "used for TextViews" */
        String header2 = "Recycling repurposes waste, conserves resources, and extends the landfill's lifespan.";

        String header3 = "Singapore's 2023 Recycling Targets";

        String content = "Recycling is a great way to protect the environment. Did you know that: \n\n" +
                            "\u2022 Recycling 1,000kg of paper saves 17 trees. \n\n" +
                            "\u2022 Recycling an aluminium can saves 95% of the energy used to make a new one. \n\n" +
                            "\u2022 Recycling a glass bottle saves 30% of the energy used to make a new one.\n\n";

        String content2 = "Of the waste generated in 2018, more than half - almost 4.63 million tonnes - was recycled. \n\n" +
                            "Singapore has set a national recycling rate target of 70% in 2030, with \n\n" +
                            "\u2022 an increase in domestic recycling rate from 22% in 2018 to 30% in 2030 \n\n" +
                            "\u2022 an increase for non-domestic recycling rate from 74% in 2018 to 81% in 2030. \n\n";

        String citation = "Link: https://www.towardszerowaste.gov.sg/recycle/\n\n";

        /* Method calling */
        drgpage1header2.setText(header2);
        drgpage1header3.setText(header3);
        drgpage1content.setText(content);
        drgpage1content2.setText(content2);
        drgpage1citation.setText(citation);
    }
    /* On Click Method */
    public void openDrgPage() {
        Intent intent = new Intent(this, DRGPage.class);
        startActivity(intent);
    }
}