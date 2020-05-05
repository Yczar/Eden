package com.xhino.eden;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Processing extends AppCompatActivity {

    //To be used During FireStore UPDATES.

  FirebaseFirestore firebaseFirestore;

    private String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_screen);
        Processing process= new Processing();
        List<Tree> trees = new ArrayList<Tree>();


       firebaseFirestore =   FirebaseFirestore.getInstance();

       // CollectionReference forest = firebaseFirestore.collection("Forest Trees");
        firebaseFirestore.collection("Forest Trees").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            private Object QueryDocumentSnapshot;

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());

                        Toast.makeText(Processing.this,"Sucess",  Toast.LENGTH_LONG).show();
                        Intent intent = new Intent (Processing.this, CropsActivity.class);
                        startActivity(intent);

                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());


                }

                String dummy=QueryDocumentSnapshot.toString();
            }
        });

    }
        }


