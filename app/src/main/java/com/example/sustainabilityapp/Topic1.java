package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Topic1 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_topic1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic1);

        /* Assignment Statement */
        backbtn_topic1 = (android.widget.ImageView) findViewById(R.id.backbtn_topic1);

        /* Video View for the youtube video to play...*/
        VideoView videoView = findViewById(R.id.topic1video);
        String videoPath = "android.resource://" +getPackageName() + "/" + R.raw.topic1;
        Uri uri = Uri.parse(videoPath);
        MediaController mediaController = new MediaController(this);

        /* Method calling */
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_topic1.setOnClickListener(new View.OnClickListener() {
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