package com.vrishankgupta.instaclone.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vrishankgupta.instaclone.R;

/**
 * Created by vrishankgupta on 01/02/18.
 */

public class LoginActivity  extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private Context mContext;
    private ProgressBar progressBar;
    private EditText eMail,password;
    private TextView pleaseWait;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = findViewById(R.id.progressBar);
        pleaseWait = findViewById(R.id.pleaseWait);
        eMail = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        mContext = LoginActivity.this;
        pleaseWait.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        setupFirebaseAuth();
        init();
    }

    private Boolean isStringNull(String string)
    {
        Log.d(TAG, "isStringNull: ");
        if(string.equals(""))
            return true;
        return false;
    }

    //---------------//
    private void init()
    {
        Button button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: log in butn");
                String email = eMail.getText().toString();
                String mpassword = password.getText().toString();
                if(isStringNull(email) && isStringNull(mpassword))
                    Toast.makeText(mContext, "Enter Fields Please", Toast.LENGTH_SHORT).show();

                else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    pleaseWait.setVisibility(View.VISIBLE);

                    auth.signInWithEmailAndPassword(email, mpassword)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                                    if (!task.isSuccessful()) {
                                        Log.w(TAG, "signInWithEmail:failed", task.getException());

                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed),
                                                Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        pleaseWait.setVisibility(View.GONE);
                                    }
                                    else{
                                        Log.d(TAG, "signInWithEmail: successful login");
                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_success),
                                                Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        pleaseWait.setVisibility(View.GONE);
                                    }
                                }
                            });

                }
            }
        });
    }

    private void setupFirebaseAuth()
    {
        Log.d(TAG, "setupFirebaseAuth: setting up firbase auth");
        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null)
                {
                    Log.d(TAG, "onAuthStateChanged: signed In" + user.getUid());
                }
                else
                {
                    Log.d(TAG, "onAuthStateChanged: SignedOut");
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);

    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authStateListener);
    }


}
