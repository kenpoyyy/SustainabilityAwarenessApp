package com.example.sustainabilityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfilePage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_editpage; //Back btn
    private Button logoutbtn; //Logout btn

    private FirebaseAuth auth;
    private DatabaseReference databaseReference;
    private FirebaseUser currentUser;

    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private EditText userPhone;
    private EditText userCity;

    private Button cancel;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_page);

        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference();

        // Initialize UI elements from firebase
        userName=findViewById(R.id.editusername);
        userEmail=findViewById(R.id.editemail);
        userPassword=findViewById(R.id.editpassword);
        userPhone=findViewById(R.id.editphone);
        userCity=findViewById(R.id.editcity);

        if(currentUser!=null){
            LoadUserProfile();
        }

        /* Assignment Statement */
        backbtn_editpage = (android.widget.ImageView) findViewById(R.id.backbtn_editpage);
        logoutbtn = (android.widget.Button) findViewById(R.id.logoutbtn);

        cancel=findViewById(R.id.canceleditbtn);
        save=findViewById(R.id.saveeditbtn);


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
                auth.signOut();
                openLoginPage();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadUserProfile();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserProfile();
            }

        });
    }


    private void saveUserProfile(){
        String updatedName=userName.getText().toString();
        String updatedEmail=userEmail.getText().toString();
        String updatedPassword=userPassword.getText().toString();
        String updatedPhone=userPhone.getText().toString();
        String updatedCity=userCity.getText().toString();

        UserProfile updatedProfile =new UserProfile(updatedName, updatedEmail, updatedPassword, updatedPhone, updatedCity);

        if(currentUser!=null){
            databaseReference.child("Users").child(currentUser.getUid()).setValue(updatedProfile)
                    .addOnSuccessListener(aVoid -> Toast.makeText(EditProfilePage.this, "Profile Updated", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(EditProfilePage.this, "Failed to update profile", Toast.LENGTH_SHORT).show());
        }
    }

    private void LoadUserProfile() {
        String userID= currentUser.getUid();
        databaseReference.child("Users").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile userProfile= snapshot.getValue(UserProfile.class);
                if(userProfile!=null){
                    userName.setText(userProfile.getName());
                    userEmail.setText(userProfile.getEmail());
                    userPassword.setText(userProfile.getPassword());
                    userPhone.setText(userProfile.getPhone());
                    userCity.setText(userProfile.getCity());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EditProfilePage.this,"Failed to load user profile",Toast.LENGTH_SHORT).show();
            }
        });

    }

    /* On Click Method */
    //Go back to homepage
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    //User logs out
    public void openLoginPage() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}