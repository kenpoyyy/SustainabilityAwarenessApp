package com.example.sustainabilityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {

    /* Variable Declaration */
    ImageView backbtn_regpage;
    EditText editUserName,editPassword,editEmail,editPhone,editCity;
    Button SignUp;
    //TextView alreadyAccount;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        getSupportActionBar().hide();

        // Initialize Firebase Auth
        editUserName=findViewById(R.id.editTextText6);
        editPassword=findViewById(R.id.editTextText7);
        editEmail=findViewById(R.id.editTextText8);
        editPhone=findViewById(R.id.editTextText9);
        editCity=findViewById(R.id.editTextText10);
        SignUp=findViewById(R.id.button);

        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        //progress dialog set up
        progressDialog=new ProgressDialog(RegisterPage.this);
        progressDialog.setTitle("Creating your Account");
        progressDialog.setMessage("Your account is creating");

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();

                String name=editUserName.toString();
                String password=editPassword.toString();
                String email=editEmail.toString();
                String phone=editPhone.toString();
                String city=editCity.toString();

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(RegisterPage.this,"Enter Username",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterPage.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(city)){
                    Toast.makeText(RegisterPage.this,"Enter City",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterPage.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(RegisterPage.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressDialog.dismiss();
                                if(task.isSuccessful()){

                                    UserProfile profile=new UserProfile(name,email,password,phone,city);
                                    String id=task.getResult().getUser().getUid();
                                    database.getReference().child("Users").child(id).setValue(profile);

                                    Intent intent=new Intent(RegisterPage.this,HomePage.class);
                                    startActivity(intent);

                                }
                                else{
                                    Toast.makeText(RegisterPage.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });

        /* Assignment Statement */
        backbtn_regpage = (android.widget.ImageView) findViewById(R.id.backbtn_regpage);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_regpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }
    /* Method */
    public void openLoginPage() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}