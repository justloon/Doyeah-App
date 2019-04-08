package com.justloon.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Tag;

public class LoginAdmin extends AppCompatActivity {

    private final static String TAG = "LoginAdmin";
    private Button btnLogin;
    private EditText mEmail, mPass;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        btnLogin = (Button) findViewById(R.id.btn_masuk);
        mEmail = (EditText) findViewById(R.id.input_Email);
        mPass = (EditText) findViewById(R.id.input_pass);

        auth = FirebaseAuth.getInstance();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                final String password = mPass.getText().toString();

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginAdmin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());

                                if (task.isSuccessful()) {
                                    onAuthSuccess(task.getResult().getUser());
                                } else {
                                    Toast.makeText(LoginAdmin.this, "Sign In Failed",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                }

        });


    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());

        // membuat User admin baru
        // Go to MainActivity
        startActivity(new Intent(LoginAdmin.this, MainActivity.class));
        finish();
    }

}
