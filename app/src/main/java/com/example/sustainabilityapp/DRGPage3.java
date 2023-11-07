package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DRGPage3 extends AppCompatActivity {

    /* Variable Declaration */
    TextView drgpage3description;
    TextView drgpage3header2;
    TextView drgpage3header3;
    TextView drgpage3header4;
    TextView drgpage3header5;
    TextView drgpage3subheader;
    TextView drgpage3subheader2;
    TextView drgpage3subheader3;
    TextView drgpage3subheader4;
    TextView drgpage3subheader5;
    TextView drgpage3subheader6;
    TextView drgpage3subheader7;
    TextView drgpage3subheader8;
    TextView drgpage3content;
    TextView drgpage3content2;
    TextView drgpage3content3;
    TextView drgpage3content4;
    TextView drgpage3content5;
    TextView drgpage3content6;
    TextView drgpage3content7;
    TextView drgpage3content8;
    TextView drgpage3citation;
    private ImageView backbtn_drgpage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drgpage3);

        /* Assignment Statement */
        drgpage3description = findViewById(R.id.drgpage3description);
        drgpage3header2 = findViewById(R.id.drgpage3header2);
        drgpage3header3 = findViewById(R.id.drgpage3header3);
        drgpage3header4 = findViewById(R.id.drgpage3header4);
        drgpage3header5 = findViewById(R.id.drgpage3header5);
        drgpage3subheader = findViewById(R.id.drgpage3subheader);
        drgpage3subheader2 = findViewById(R.id.drgpage3subheader2);
        drgpage3subheader3 = findViewById(R.id.drgpage3subheader3);
        drgpage3subheader4 = findViewById(R.id.drgpage3subheader4);
        drgpage3subheader5 = findViewById(R.id.drgpage3subheader5);
        drgpage3subheader6 = findViewById(R.id.drgpage3subheader6);
        drgpage3subheader7 = findViewById(R.id.drgpage3subheader7);
        drgpage3subheader8 = findViewById(R.id.drgpage3subheader8);
        drgpage3content = findViewById(R.id.drgpage3content);
        drgpage3content2 = findViewById(R.id.drgpage3content2);
        drgpage3content3 = findViewById(R.id.drgpage3content3);
        drgpage3content4 = findViewById(R.id.drgpage3content4);
        drgpage3content5 = findViewById(R.id.drgpage3content5);
        drgpage3content6 = findViewById(R.id.drgpage3content6);
        drgpage3content7 = findViewById(R.id.drgpage3content7);
        drgpage3content8 = findViewById(R.id.drgpage3content8);
        drgpage3citation = findViewById(R.id.drgpage3citation);
        backbtn_drgpage3 = (android.widget.ImageView) findViewById(R.id.backbtn_drgpage3);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_drgpage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrgPage();
            }
        });

        /* String Contents "used for TextViews" */
        String description = "Not sure what you can or cannot recycle?";

        String header2 = "Paper";

        String header3 = "Plastic";

        String header4 = "Glass";

        String header5 = "Metal/Others";

        String subheader = "Can be recycled:";

        String subheader2 = "Cannot be recycled:";

        String subheader3 = "Can be recycled:";

        String subheader4 = "Cannot be recycled:";

        String subheader5 = "Can be recycled:";

        String subheader6 = "Cannot be recycled:";

        String subheader7 = "Can be recycled:";

        String subheader8 = "Cannot be recycled:";

        String content = "\u2022 Office paper \n\n" +
                "\u2022 Newspaper \n\n" +
                "\u2022 Magazines \n\n" +
                "\u2022 Cardboard (corrugated and flat cardboard) \n\n" +
                "\u2022 Cardboard boxes \n\n" +
                "\u2022 Phone books \n\n" +
                "\u2022 Envelopes (with and without windows) \n\n" +
                "\u2022 Junk mail \n\n" +
                "\u2022 Paper bags \n";

        String content2 = "\u2022 Soiled or greasy paper (e.g., pizza boxes with food residue). \n\n" +
                "\u2022 Tissue paper and paper towels \n\n" +
                "\u2022 Shredded paper \n\n" +
                "\u2022 Paper coated with wax, plastic, or foil \n\n" +
                "\u2022 Laminated or thermal paper (e.g., thermal fax paper) \n\n";

        String content3 = "\u2022 Bottles (PETE and HDPE plastics, typically labeled with a recycling number 1 or 2) \n\n" +
                "\u2022 Plastic containers (such as yogurt cups and margarine tubs) \n\n" +
                "\u2022 Plastic jugs and jars \n\n" +
                "\u2022 Plastic lids and caps \n\n" +
                "\u2022 Plastic bags and films \n";

        String content4 = "\u2022 Plastic utensils and straws \n\n" +
                "\u2022 Styrofoam (polystyrene) \n\n" +
                "\u2022 PVC (recycling symbol 3) and other less common plastic types \n\n" +
                "\u2022 Plastic toys, hangers, or other non-container plastics \n\n";

        String content5 = "\u2022 Glass bottles \n\n" +
                "\u2022 Glass jars \n";

        String content6 = "\u2022 Window glass \n\n" +
                "\u2022 Ceramics or dishes \n\n" +
                "\u2022 Pyrex or other heat-resistant glass \n\n" +
                "\u2022 Mirrors \n\n";

        String content7 = "\u2022 Aluminum cans \n\n" +
                "\u2022 Steel cans (e.g., food cans) \n\n" +
                "\u2022 Aluminum foil and pie tins \n\n" +
                "\u2022 Empty aerosol cans (without hazardous contents) \n\n" +
                "\u2022 Metal lids and caps \n\n" +
                "\u2022 Certain scrap metals (such as copper, brass, and stainless steel) \n";

        String content8 = "\u2022 Metal items with hazardous materials (e.g., paint cans with leftover paint) \n\n" +
                "\u2022 Mixed-material items (e.g., metal-coated plastic) \n\n" +
                "\u2022 Non-metalic objects (e.g., wood, plastic, glass) mixed with metal \n\n";

        String citation = "Link: https://www.towardszerowaste.gov.sg/recycle/\n\n";

        /* Method calling */
        drgpage3description.setText(description);
        drgpage3header2.setText(header2);
        drgpage3header3.setText(header3);
        drgpage3header4.setText(header4);
        drgpage3header5.setText(header5);
        drgpage3subheader.setText(subheader);
        drgpage3subheader2.setText(subheader2);
        drgpage3subheader3.setText(subheader3);
        drgpage3subheader4.setText(subheader4);
        drgpage3subheader5.setText(subheader5);
        drgpage3subheader6.setText(subheader6);
        drgpage3subheader7.setText(subheader7);
        drgpage3subheader8.setText(subheader8);
        drgpage3content.setText(content);
        drgpage3content2.setText(content2);
        drgpage3content3.setText(content3);
        drgpage3content4.setText(content4);
        drgpage3content5.setText(content5);
        drgpage3content6.setText(content6);
        drgpage3content7.setText(content7);
        drgpage3content8.setText(content8);
        drgpage3citation.setText(citation);
    }
    /* On Click Method */
    public void openDrgPage() {
        Intent intent = new Intent(this, DRGPage.class);
        startActivity(intent);
    }
}