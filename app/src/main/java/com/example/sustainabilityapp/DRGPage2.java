package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DRGPage2 extends AppCompatActivity {

    /* Variable Declaration */
    TextView drgpage2description;
    TextView drgpage2header2;
    TextView drgpage2header3;
    TextView drgpage2header4;
    TextView drgpage2header5;
    TextView drgpage2content;
    TextView drgpage2content2;
    TextView drgpage2content3;
    TextView drgpage2content4;
    TextView drgpage2citation;
    private ImageView backbtn_drgpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drgpage2);

        /* Assignment Statement */
        drgpage2description = findViewById(R.id.drgpage2description);
        drgpage2header2 = findViewById(R.id.drgpage2header2);
        drgpage2header3 = findViewById(R.id.drgpage2header3);
        drgpage2header4 = findViewById(R.id.drgpage2header4);
        drgpage2header5 = findViewById(R.id.drgpage2header5);
        drgpage2content = findViewById(R.id.drgpage2content);
        drgpage2content2 = findViewById(R.id.drgpage2content2);
        drgpage2content3 = findViewById(R.id.drgpage2content3);
        drgpage2content4 = findViewById(R.id.drgpage2content4);
        drgpage2citation = findViewById(R.id.drgpage2citation);
        backbtn_drgpage2 = (android.widget.ImageView) findViewById(R.id.backbtn_drgpage2);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_drgpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrgPage();
            }
        });

        /* String Contents "used for TextViews" */
        String description = "Roughly 40% of items in blue recycling bins aren't recyclable due to contamination or non-recyclable materials.";

        String header2 = "1. Use a bag or box to store all your recyclables";

        String header3 = "2. Know what can or cannot be recycled";

        String header4 = "3. Make sure your items are not contaminated with food or liquids";

        String header5 = "4. Recycle your items!";

        String content = "\u2022 There is no need to sort the recyclables as they will be sorted centrally after collection.\n\n";


        String content2 = "\u2022 Check the blue bin label to confirm that your items are suitable for recycling.\n\n" +
                "\u2022 Common materials that can be recycled include glass, paper, plastic and metal.\n\n" +
                "\u2022 Single-use packaging such as disposable containers and cups often cannot be recycled as they are contaminated with food.\n\n" +
                "\u2022 While food waste and e-waste can be recycled, they cannot be placed inside the blue recycling bins. " +
                "Please refer to the respective waste stream pages to find out how they can recycled.\n\n" +
                "\u2022 Separate reusables (clothes, shoes, stuffed toys) from recyclables. " +
                "Reusables that are in good condition should be donated. You can give them away through online sites or donate them!\n\n" +
                "\u2022 Do not throw trash or bulky items like furniture and renovation waste into blue recycling bins.\n\n";

        String content3 = "\u2022 For example, items such as shampoo/detergent bottles, canned/bottled drinks, " +
                "cosmetic jars, jam jars need to be clean before they can be recycled.\n\n" +
                "\u2022 If containers are wet, greasy or contain food, they will contaminate the rest of the items in the recycling bin. " +
                "Give these containers a simple rinse before you put them into the blue bin.\n\n";

        String content4 = "\u2022 Unsure whether something can be recyclable or not? Please contact NEA at 1800-CALL NEA (1800-2255 632)!\n\n";

        String citation = "Link: https://www.towardszerowaste.gov.sg/recycle/\n\n";

        /* Method calling */
        drgpage2description.setText(description);
        drgpage2header2.setText(header2);
        drgpage2header3.setText(header3);
        drgpage2header4.setText(header4);
        drgpage2header5.setText(header5);
        drgpage2content.setText(content);
        drgpage2content2.setText(content2);
        drgpage2content3.setText(content3);
        drgpage2content4.setText(content4);
        drgpage2citation.setText(citation);
    }
    /* On Click Method */
    public void openDrgPage() {
        Intent intent = new Intent(this, DRGPage.class);
        startActivity(intent);
    }
}