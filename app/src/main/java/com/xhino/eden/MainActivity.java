package com.xhino.eden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
   // DatabaseReference mDatabase;

    ProgressBar progressBar;
    FirebaseAuth mAuth;
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
       // mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        proceed=findViewById(R.id.proceed_Button);
        progressBar=findViewById(R.id.progressBar);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                AuthenticateAnonymously();

            }
        });
    }

    private void AuthenticateAnonymously() {

        mAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Intent intent= new Intent(MainActivity.this, StateActivity.class);
                    startActivity(intent);


                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "oops we cannot get you in Right Now, Check your Network", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
