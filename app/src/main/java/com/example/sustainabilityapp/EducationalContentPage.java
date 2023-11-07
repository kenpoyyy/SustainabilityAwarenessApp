package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EducationalContentPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_educont; //Back btn
    private Button topicsbtn; //Topics Btn
    private Button articlesbtn; //Articles Btn
    private Button drgbtn; //Disposal and Recycling Guideline Btn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.educational_content_page);

        /* Assignment Statement */
        backbtn_educont = (android.widget.ImageView) findViewById(R.id.backbtn_educont);
        topicsbtn = (android.widget.Button) findViewById(R.id.topicsbtn); //topics btn
        articlesbtn = (android.widget.Button) findViewById(R.id.articlesbtn); //articles btn
        drgbtn = (android.widget.Button) findViewById(R.id.drgbtn); //drg btn

        /* On Click Listener: Defines what happens when the image is clicked */
        //Back btn
        backbtn_educont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage();
            }
        });
        //Topics btn
        topicsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTopicsPage();
            }
        });
        //Articles btn
        articlesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticlesPage();
            }
        });
        //Drg btn
        drgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDRGPage();
            }
        });

    }
    /* Method */
    //Back btn
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    //Topics btn
    public void openTopicsPage() {
        Intent intent = new Intent(this, TopicsPage.class);
        startActivity(intent);
    }
    //Articles btn
    public void openArticlesPage() {
        Intent intent = new Intent(this, ArticlesPage.class);
        startActivity(intent);
    }
    //Topics btn
    public void openDRGPage() {
        Intent intent = new Intent(this, DRGPage.class);
        startActivity(intent);
    }
}