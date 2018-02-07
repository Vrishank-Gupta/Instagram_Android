package com.vrishankgupta.instaclone.Login;

import android.content.Context;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vrishankgupta.instaclone.R;
import com.vrishankgupta.instaclone.Utils.FirebaseMethods;

/**
 * Created by vrishankgupta on 01/02/18.
 */

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    private Context context;
    private String email,password,username;
    private EditText eMail,mPassword,mUsername;
    private TextView loadingPleaseWait;
    private Button btnReg;
    private ProgressBar mProgressBar;
    private FirebaseMethods firebaseMethods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=RegisterActivity.this;
        setContentView(R.layout.activity_register);
        firebaseMethods = new FirebaseMethods(context);
        Log.d(TAG, "onCreate: ");
        initWidgets();
        setupFirebaseAuth();
        init();
    }
    private void initWidgets()
    {
        Log.d(TAG, "initWidgets: ");
        mUsername = findViewById(R.id.input_username);
        btnReg = findViewById(R.id.btnRegister);
        mProgressBar = findViewById(R.id.progressBar);
        loadingPleaseWait = findViewById(R.id.loadingPleaseWait);
        eMail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_password);
        context = RegisterActivity.this;
        mProgressBar.setVisibility(View.GONE);
        loadingPleaseWait.setVisibility(View.GONE);

    }

    private boolean checkInputs(String email,String username,String password)
    {
        Log.d(TAG, "checkInputs: check null values");
        if(email.equals("") || username.equals("") || password.equals("")){
            Toast.makeText(context, "Empty Fields!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void init()
    {
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = eMail.getText().toString();
                password = mPassword.getText().toString();
                username=mUsername.getText().toString();

                if(checkInputs(email,username,password))
                {
                    mProgressBar.setVisibility(View.VISIBLE);
                    loadingPleaseWait.setVisibility(View.VISIBLE);
                    firebaseMethods.regNewEmail(email,password,username);
                }
            }
        });
    }

    private Boolean isStringNull(String string)
    {
        Log.d(TAG, "isStringNull: ");
        if(string.equals(""))
            return true;
        return false;
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
