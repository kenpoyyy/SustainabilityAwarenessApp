package com.example.sustainabilityapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class LoginPage extends AppCompatActivity {

    Button regbtn; //reg btn
    EditText LogInEmail,LogInPassword;
    Button LogIn;
    Button btnSignInGoogle;
    //firebase Google login Auth
    FirebaseAuth gAuth;
    //email and password login Auth
    FirebaseAuth eAuth;
    FirebaseDatabase gDatabase;
    GoogleSignInClient mGoogleSignInClient;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        eAuth=FirebaseAuth.getInstance();

        //sign in with password
        LogInEmail=findViewById(R.id.editTextText2);
        LogInPassword=findViewById(R.id.editTextTextPassword2);
        LogIn=findViewById(R.id.loginbtn);

        //forgot password
        TextView forgotPassword = findViewById(R.id.forgotpassword);

        //sign in with google
        btnSignInGoogle=findViewById(R.id.btnSignInGoogle);
        gAuth=FirebaseAuth.getInstance();
        gDatabase=FirebaseDatabase.getInstance();

        //progress dialog
        progressDialog=new ProgressDialog(LoginPage.this);
        progressDialog.setTitle("Login Account");
        progressDialog.setMessage("Login Account");

        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);

        /* Assignment Statement */
        regbtn = (android.widget.Button) findViewById(R.id.regbtn);

        /* On Click Listener: Defines what happens when the image is clicked */
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegPage();
            }
        });

        btnSignInGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInGoogle();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgotPasswordPage();
            }
        });


        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();

                String email,password;
                email=LogInEmail.getText().toString();
                password=LogInPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginPage.this,"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginPage.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                eAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Intent intent= new Intent(LoginPage.this,HomePage.class);
                            startActivity(intent);
                        } else {
                            // Display error message using Toast
                            Toast.makeText(LoginPage.this, "Login failed! No user found!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    int RC_SIGN_IN=40;
    private void signInGoogle() {

        Intent intent=mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount>task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);

                firebaseAuthGoogle(account.getIdToken());

            }catch (ApiException e){
                throw new RuntimeException(e);
            }
        }
    }

    //sign in with google authentication
    private void firebaseAuthGoogle(String idToken) {

        AuthCredential credential= GoogleAuthProvider.getCredential(idToken,null);

        gAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            FirebaseUser user=gAuth.getCurrentUser();

                            Users users=new Users();
                            users.setUserID(user.getUid());
                            users.setName(user.getDisplayName());
                            users.setProfile(user.getPhotoUrl().toString());

                            gDatabase.getReference().child("Users").child(user.getUid()).setValue(users);

                            Intent intent=new Intent(LoginPage.this,HomePage.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginPage.this,"error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    /* On Click Method */
    public void openRegPage() {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
    //Method to open the Forgot Password activity
    private void openForgotPasswordPage() {
        Intent intent = new Intent(this, ForgotPasswordPage.class);
        startActivity(intent);
    }

}