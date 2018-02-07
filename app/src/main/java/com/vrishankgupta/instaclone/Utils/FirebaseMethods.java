package com.vrishankgupta.instaclone.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vrishankgupta.instaclone.R;

/**
 * Created by vrishankgupta on 08/02/18.
 */

public class FirebaseMethods {

    private static final String TAG = "FirebaseMethods";
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private Context mContext;
    private String userId;
    public FirebaseMethods(Context context){
        auth = FirebaseAuth.getInstance();
        mContext = context;
        if(auth.getCurrentUser() != null)
        {
            userId = auth.getCurrentUser().getUid();

        }
    }

    public void regNewEmail(String email, String password, final String username)
    {

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(mContext, R.string.auth_success, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            userId = auth.getCurrentUser().getUid();
                            Log.d(TAG, "onComplete: authstate changed "+ userId);
                        }

                        // ...
                    }
                });
    }

}
