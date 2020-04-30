package com.xhino.eden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class CropsActivity extends AppCompatActivity  {

    FirebaseFirestore firebaseFirestore;
    RecyclerView mcropList;
   public  FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crops_list);
        FirebaseApp.initializeApp(this);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mcropList = findViewById(R.id.crop_list);

        Query query = firebaseFirestore.collection("Crops");
        FirestoreRecyclerOptions<CropsModel> options = new FirestoreRecyclerOptions.Builder<CropsModel>().
                setQuery(query, CropsModel.class).
                build();

        adapter = new CropsAdapter(options);

        mcropList.setHasFixedSize(true);
        mcropList.setLayoutManager(new LinearLayoutManager(this));
        mcropList.setAdapter(adapter);




    }





    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }






    }

