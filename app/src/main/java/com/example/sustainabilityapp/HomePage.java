package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {

    private ImageView editprofbtn; //Profile btn
    private Button eventsbtn; //Event Btn
    private Button educontentbtn; //Edu content btn
    private Button shopguidebtn; //Shopping guide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        /* Assignment Statement */
        editprofbtn = (android.widget.ImageView) findViewById(R.id.editprofbtn); //profile btn
        eventsbtn = (android.widget.Button) findViewById(R.id.eventsbtn); //event btn
        educontentbtn = (android.widget.Button) findViewById(R.id.educontentbtn); //edu content btn
        shopguidebtn = (android.widget.Button) findViewById(R.id.shopguidebtn); //shopping guide btn

        /* On Click Listener: Defines what happens when the image is clicked */
        editprofbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditProfPage();
            }
        });

        eventsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventsPage();
            }
        });
        educontentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEduContPage();
            }
        });
        shopguidebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopGuidePage();
            }
        });
    }
    /* Method */
    public void openEditProfPage() {
        Intent intent = new Intent(this, EditProfilePage.class);
        startActivity(intent);
    }
    public void openEventsPage() {
        Intent intent = new Intent(this, EventsPage.class);
        startActivity(intent);
    }
    public void openEduContPage() {
        Intent intent = new Intent(this, EducationalContentPage.class);
        startActivity(intent);
    }
    public void openShopGuidePage() {
        Intent intent = new Intent(this, ShoppingGuide.class);
        startActivity(intent);
    }
}