package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DRGPage4 extends AppCompatActivity {

    /* Variable Declaration */
    TextView drgpage4header2;
    TextView drgpage4header3;
    TextView drgpage4header4;
    TextView drgpage4content;
    TextView drgpage4content2;
    TextView drgpage4content3;
    TextView drgpage4citation;
    private ImageView backbtn_drgpage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drgpage4);

        /* Assignment Statement */
        drgpage4header2 = findViewById(R.id.drgpage4header2);
        drgpage4header3 = findViewById(R.id.drgpage4header3);
        drgpage4header4 = findViewById(R.id.drgpage4header4);
        drgpage4content = findViewById(R.id.drgpage4content);
        drgpage4content2 = findViewById(R.id.drgpage4content2);
        drgpage4content3 = findViewById(R.id.drgpage4content3);
        drgpage4citation = findViewById(R.id.drgpage4citation);
        backbtn_drgpage4 = (android.widget.ImageView) findViewById(R.id.backbtn_drgpage4);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_drgpage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrgPage();
            }
        });

        /* String Contents "used for TextViews" */
        String header2 = "Where to recycle metal, paper, glass, plastics?";

        String header3 = "Where to recycle e-waste?";

        String header4 = "Donation/Collection";

        String content = "You can recycle metal, paper, glass, and plastic by placing them in blue recycling bins located at regular intervals within public housing estates. \n\n" +
                "Recycling containers are provided to every residence in detached houses, and condominium complexes also include recycling bins within their premises.";

        String content2 = "Please deliver your electronic waste to the specified recycling locations provided by different retailers and our industry collaborators. " +
                "(Please be aware that electronic waste should not be placed in the blue recycling bins.)";

        String content3 = "If the item you intend to recycle is still functioning well, you might want to think about donating or selling it.\n";

        String citation = "Link: https://www.towardszerowaste.gov.sg/recycle/\n\n";

        /* Method calling */
        drgpage4header2.setText(header2);
        drgpage4header3.setText(header3);
        drgpage4header4.setText(header4);
        drgpage4content.setText(content);
        drgpage4content2.setText(content2);
        drgpage4content3.setText(content3);
        drgpage4citation.setText(citation);
    }
    /* On Click Method */
    public void openDrgPage() {
        Intent intent = new Intent(this, DRGPage.class);
        startActivity(intent);
    }
}