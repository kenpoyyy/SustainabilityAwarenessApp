package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Topic3 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_topic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic3);

        /* Assignment Statement */
        backbtn_topic3 = (android.widget.ImageView) findViewById(R.id.backbtn_topic3);
        VideoView videoView = findViewById(R.id.topic3video);
        String videoPath = "android.resource://" +getPackageName() + "/" + R.raw.topic3;
        Uri uri = Uri.parse(videoPath);
        MediaController mediaController = new MediaController(this);

        /* Method calling */
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_topic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTopicPage();
            }
        });
    }
    /* On Click Method */
    public void openTopicPage() {
        Intent intent = new Intent(this, TopicsPage.class);
        startActivity(intent);
    }
}