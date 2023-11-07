package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ShoppingGuidePage2 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_shopguide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_guide_page2);

        /* Assignment Statement */
        backbtn_shopguide2 = (android.widget.ImageView) findViewById(R.id.backbtn_shopguide2);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_shopguide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopGuide();
            }
        });
    }
    /* Method */
    public void openShopGuide() {
        Intent intent = new Intent(this, ShoppingGuide.class);
        startActivity(intent);
    }
}