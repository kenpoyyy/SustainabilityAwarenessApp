package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EventsPage extends AppCompatActivity implements SelectListener{

    /* Variable Declaration */
    ImageView backbtn_eventpage;
    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    List<EventItem> eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_page);

        displayItem();

        /* Assignment Statement */
        backbtn_eventpage = (android.widget.ImageView) findViewById(R.id.backbtn_eventpage);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_eventpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage();
            }
        });

    }

    private void displayItem() {
        //initialize the recyclerView
        recyclerView=findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        eventList=new ArrayList<>();
        eventList.add(new EventItem("Race on Sunshine-Discovering Solar Energy", "Singapore Discovery Center", "01 July - 26 November 2023","EventsPage1"));
        eventList.add(new EventItem("Turning waste to energy: TuasOne Waste-To-Energy Plant Tour", "TuasOne Waste-To-Energy Plant", "11 July - 28 November 2023","EventsPage2"));
        eventList.add(new EventItem("Where Singapore’s waste goes: A tour of Semakau Landfill","Semakau Landfill","22 July - 30 November 2023","EventsPage3"));
        eventAdapter=new EventAdapter(eventList,this,this);
        recyclerView.setAdapter(eventAdapter);
    }


    /* Method */
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }


    @Override
    public void onItemClicked(int position) {
        //***Updated Code to link to other Event Pages.***
        EventItem clickedEvent = eventList.get(position);

        // Determine which event was clicked based on the position
        if (position == 0) {
            Intent intent = new Intent(EventsPage.this, EventsPage1.class);
            // You can also pass data to the next activity if needed using intent.putExtra()
            startActivity(intent);
        } else if (position == 1) {
            Intent intent = new Intent(EventsPage.this, EventsPage2.class);
            startActivity(intent);
        } else if (position == 2) {
            Intent intent = new Intent(EventsPage.this, EventsPage3.class);
            startActivity(intent);
        }
    }

}