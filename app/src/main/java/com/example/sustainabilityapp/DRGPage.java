package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DRGPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_drgpage; //Back btn
    private Button drg1btn; //DRG 1 btn
    private Button drg2btn; //DRG 2 btn
    private Button drg3btn; //DRG 3 btn
    private Button drg4btn; //DRG 4 btn
    private Button drg5btn; //DRG 5 btn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drgpage);

        /* Assignment Statement */
        backbtn_drgpage = (android.widget.ImageView) findViewById(R.id.backbtn_drgpage); //back btn
        drg1btn = (android.widget.Button) findViewById(R.id.drg1btn); //drg 1 btn
        drg2btn = (android.widget.Button) findViewById(R.id.drg2btn); //drg 2 btn
        drg3btn = (android.widget.Button) findViewById(R.id.drg3btn); //drg 3 btn
        drg4btn = (android.widget.Button) findViewById(R.id.drg4btn); //drg 4 btn
        drg5btn = (android.widget.Button) findViewById(R.id.drg5btn); //drg 5 btn

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_drgpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEduContPage();
            }
        });
        drg1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDRG1Page();
            }
        });
        drg2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDRG2Page();
            }
        });
        drg3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDRG3Page();
            }
        });
        drg4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDRG4Page();
            }
        });
        drg5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDRG5Page();
            }
        });
    }
    /* On Click Method */
    public void openEduContPage() {
        Intent intent = new Intent(this, EducationalContentPage.class);
        startActivity(intent);
    }
    public void openDRG1Page() {
        Intent intent = new Intent(this, DRGPage1.class);
        startActivity(intent);
    }
    public void openDRG2Page() {
        Intent intent = new Intent(this, DRGPage2.class);
        startActivity(intent);
    }
    public void openDRG3Page() {
        Intent intent = new Intent(this, DRGPage3.class);
        startActivity(intent);
    }
    public void openDRG4Page() {
        Intent intent = new Intent(this, DRGPage4.class);
        startActivity(intent);
    }
    public void openDRG5Page() {
        Intent intent = new Intent(this, DRGPage5.class);
        startActivity(intent);
    }
}