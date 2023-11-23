package com.example.sustainabilityapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordPage extends AppCompatActivity {

    //Back button
    ImageView backbtn_fppage;

    // Email input field
    EditText fpemail;

    // Firebase Authentication
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_page);

        /* Initialization */
        backbtn_fppage = findViewById(R.id.backbtn_fppage);
        fpemail = findViewById(R.id.fpemail);
        Button fpbutton = findViewById(R.id.fpbutton);

        // Firebase Authentication instance
        firebaseAuth = FirebaseAuth.getInstance();

        /* Assignment Statement */
        backbtn_fppage = (android.widget.ImageView) findViewById(R.id.backbtn_fppage);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_fppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });

        // On Click Listener for Reset Password Button
        fpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }
    /* Method */
    /* Method to open Login Page */
    public void openLoginPage() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
    /* Method to reset password */
    private void resetPassword() {
        String email = fpemail.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Enter your registered email", Toast.LENGTH_SHORT).show();
            return;
        }

        // Use Firebase Authentication to send a password reset email
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(ForgotPasswordPage.this,
                                "Password reset email sent. Check your email inbox.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ForgotPasswordPage.this,
                                "Failed to send reset email. Check your email address.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}