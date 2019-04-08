package com.justloon.myapplication;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class InputPelanggan extends AppCompatActivity {

    private Button mSaveBtn;
    private EditText mInput;
    private TextView mText;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pelanggan);

        mInput = (EditText) findViewById(R.id.inputNama);
        mSaveBtn = (Button) findViewById(R.id.btnInput);
        mText = (TextView) findViewById(R.id.btnAdmin);

        firebaseFirestore = FirebaseFirestore.getInstance();

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputPelanggan.this,MainActivity.class));

                String nName = mInput.getText().toString();

                Map<String, String> userMap = new HashMap<>();
                userMap.put("nama", nName);

                firebaseFirestore.collection("Daftar Pelanggan").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(InputPelanggan.this, "Input Berhasil", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(InputPelanggan.this, "Input Error"+error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(InputPelanggan.this,LoginAdmin.class));
            }
        });
    }

}
