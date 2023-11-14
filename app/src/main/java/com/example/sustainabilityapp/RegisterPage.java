package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RegisterPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_regpage;

    //test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        /* Assignment Statement */
        backbtn_regpage = (android.widget.ImageView) findViewById(R.id.backbtn_regpage);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_regpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }
    /* Method */
    public void openLoginPage() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}