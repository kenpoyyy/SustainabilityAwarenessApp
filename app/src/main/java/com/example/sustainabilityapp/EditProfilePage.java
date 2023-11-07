package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EditProfilePage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_editpage; //Back btn
    private Button logoutbtn; //Logout btn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_page);

        /* Assignment Statement */
        backbtn_editpage = (android.widget.ImageView) findViewById(R.id.backbtn_editpage);
        logoutbtn = (android.widget.Button) findViewById(R.id.logoutbtn);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_editpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage();
            }
        });
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }
    /* On Click Method */
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void openLoginPage() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}