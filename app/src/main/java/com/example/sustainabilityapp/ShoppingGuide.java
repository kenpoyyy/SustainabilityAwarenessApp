package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ShoppingGuide extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_shopguide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_guide);

        /* Assignment Statement */
        backbtn_shopguide = (android.widget.ImageView) findViewById(R.id.backbtn_shopguide);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_shopguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage();
            }
        });
    }
    /* Method */
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}