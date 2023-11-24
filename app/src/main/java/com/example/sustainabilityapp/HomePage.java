package com.example.sustainabilityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePage extends AppCompatActivity {

    private CircleImageView editprofbtn; //Profile btn
    private Button eventsbtn; //Event Btn
    private Button educontentbtn; //Edu content btn
    private Button shopguidebtn; //Shopping guide

    private TextView userName;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        userName=findViewById(R.id.Username);
        if(currentUser!=null){
            LoadUserData();
        }


        /* Assignment Statement */
        editprofbtn = findViewById(R.id.editprofbtn);; //profile btn
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

    private void LoadUserData() {
        String userID = currentUser.getUid();
        databaseReference.child("Users").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile userProfile = snapshot.getValue(UserProfile.class);
                if (userProfile != null) {
                    userName.setText(userProfile.getName());
                    if (userProfile.getProfileImg() != null) {
                        Glide.with(HomePage.this).load(userProfile.getProfileImg()).into(editprofbtn);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomePage.this, "Failed to load User Data", Toast.LENGTH_SHORT).show();
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