package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ArticlesPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_articles; //Back Button
    private ImageView homebtn_articles; // Home Button
    private Button article1btn; //Article 1 Button
    private Button article2btn; //Article 2 Button
    private Button article3btn; //Article 3 Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles_page);

        /* Assignment Statement */
        backbtn_articles = (android.widget.ImageView) findViewById(R.id.backbtn_articles); //back btn
        homebtn_articles = (android.widget.ImageView) findViewById(R.id.homebtn_articles); // Home btn
        article1btn = (android.widget.Button) findViewById(R.id.article1btn); //article 1 btn
        article2btn = (android.widget.Button) findViewById(R.id.article2btn); //article 2 btn
        article3btn = (android.widget.Button) findViewById(R.id.article3btn); //article 3 btn

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEduContPage();
            }
        });

        // FOR HOME BUTTON:
        homebtn_articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openHomePage(); }
        });

        article1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticle1Page();
            }
        });
        article2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticle2Page();
            }
        });
        article3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticle3Page();
            }
        });
    }
    /* On Click Method */
    public void openEduContPage() {
        Intent intent = new Intent(this, EducationalContentPage.class);
        startActivity(intent);
    }

    // FOR HOME BUTTON:
    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openArticle1Page() {
        Intent intent = new Intent(this, Article1.class);
        startActivity(intent);
    }
    public void openArticle2Page() {
        Intent intent = new Intent(this, Article2.class);
        startActivity(intent);
    }
    public void openArticle3Page() {
        Intent intent = new Intent(this, Article3.class);
        startActivity(intent);
    }
}