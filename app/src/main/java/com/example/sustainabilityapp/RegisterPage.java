package com.example.sustainabilityapp;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_regpage;
    EditText editUserName,editPassword,editEmail,editPhone,editCity;
    Button SignUp;
    private FirebaseAuth mAuth;

    //test
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(RegisterPage.this,"User Already logged in",Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        editUserName=findViewById(R.id.editTextText6);
        editPassword=findViewById(R.id.editTextText7);
        editEmail=findViewById(R.id.editTextText8);
        editPhone=findViewById(R.id.editTextText9);
        editCity=findViewById(R.id.editTextText10);
        SignUp=findViewById(R.id.button);

        /* Assignment Statement */
        backbtn_regpage = (android.widget.ImageView) findViewById(R.id.backbtn_regpage);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_regpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UserName,Email,City,Password,Phone;

                UserName=String.valueOf(editUserName.getText());
                Email=String.valueOf(editEmail.getText());
                City=String.valueOf(editCity.getText());
                Password=String.valueOf(editPassword.getText());
                Phone=String.valueOf(editPhone.getText());

                if (TextUtils.isEmpty(UserName)){
                    Toast.makeText(RegisterPage.this,"Enter Username",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(RegisterPage.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(City)){
                    Toast.makeText(RegisterPage.this,"Enter City",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(RegisterPage.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Phone)){
                    Toast.makeText(RegisterPage.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }


    /* Method */
    public void openLoginPage() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}