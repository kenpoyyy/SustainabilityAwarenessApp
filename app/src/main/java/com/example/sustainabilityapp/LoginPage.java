package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {

    private Button regbtn; //reg btn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        /* Assignment Statement */
        regbtn = (android.widget.Button) findViewById(R.id.regbtn);

        /* On Click Listener: Defines what happens when the image is clicked */
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegPage();
            }
        });
    }
    /* On Click Method */
    public void openRegPage() {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
}