package com.example.sustainabilityapp;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private Button regbtn; //reg btn

    EditText LogInUserName,LogInPassword;
    Button LogIn;
    Button btnSignInGoogle;
    FirebaseAuth gAuth;
    FirebaseDatabase gDatabase;
    GoogleSignInClient mGoogleSignInClient;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    @Override
   public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(LoginPage.this,"User Already logged in",Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mAuth = FirebaseAuth.getInstance();

        LogInUserName=findViewById(R.id.editTextText2);
        LogInPassword=findViewById(R.id.editTextTextPassword2);
        LogIn=findViewById(R.id.button3);

        btnSignInGoogle=findViewById(R.id.btnSignInGoogle);
        gAuth=FirebaseAuth.getInstance();
        gDatabase=FirebaseDatabase.getInstance();

        progressDialog=new ProgressDialog(LoginPage.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Creating Account");

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


        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName,Password;

                UserName=String.valueOf(LogInUserName.getText());
                Password=String.valueOf(LogInPassword.getText());

                if (TextUtils.isEmpty(UserName)){
                    Toast.makeText(LoginPage.this,"Enter Username or email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(LoginPage.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(UserName, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
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

                firebaseAuth(account.getIdToken());

            }catch (ApiException e){
                throw new RuntimeException(e);
            }
        }
    }

    private void firebaseAuth(String idToken) {

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
}