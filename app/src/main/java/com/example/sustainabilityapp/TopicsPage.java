package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TopicsPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_topicpage; //Back btn
    private Button topic1btn; //Topic 1 btn
    private Button topic2btn; //Topic 2 btn
    private Button topic3btn; //Topic 3 btn


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics_page);

        /* Assignment Statement */
        backbtn_topicpage = (android.widget.ImageView) findViewById(R.id.backbtn_topicpage); //back btn
        topic1btn = (android.widget.Button) findViewById(R.id.topic1btn); //topic 1 btn
        topic2btn = (android.widget.Button) findViewById(R.id.topic2btn); //topic 2 btn
        topic3btn = (android.widget.Button) findViewById(R.id.topic3btn); //topic 3 btn

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_topicpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEduContPage();
            }
        });
        topic1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTopic1Page();
            }
        });
        topic2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTopic2Page();
            }
        });
        topic3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTopic3Page();
            }
        });
    }
    /* Method */
    public void openEduContPage() {
        Intent intent = new Intent(this, EducationalContentPage.class);
        startActivity(intent);
    }
    public void openTopic1Page() {
        Intent intent = new Intent(this, Topic1.class);
        startActivity(intent);
    }
    public void openTopic2Page() {
        Intent intent = new Intent(this, Topic2.class);
        startActivity(intent);
    }public void openTopic3Page() {
        Intent intent = new Intent(this, Topic3.class);
        startActivity(intent);
    }
}