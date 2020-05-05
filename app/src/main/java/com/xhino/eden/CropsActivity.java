package com.xhino.eden;

import android.content.Intent;
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
   private CropsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crops_list);
        Intent intents=getIntent();
        String receivedState=intents.getStringExtra("sendState");
        String receivedForest=intents.getStringExtra("sendForest");
        double receivedTendency=intents.getDoubleExtra("sendTendency",30.00);
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
        adapter.setOnItemClickListener(new CropsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(DocumentSnapshot documentSnapshot, int position) {
                CropsModel crops=documentSnapshot.toObject(CropsModel.class);
                String selectedCropName=crops.getCropName().toString();
              //  double SelectedCropShade=crops.getShadeRequirement();
                String SelectedCropBotanical=crops.getBotanicalName();

                Toast.makeText(CropsActivity.this,selectedCropName,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(CropsActivity.this, Eden.class);
                intent.putExtra("sendCropName", selectedCropName);
                intent.putExtra("sendBotanicalName", SelectedCropBotanical);
                intent.putExtra("sendFinalState",receivedState);
                intent.putExtra("sendFinalForest",receivedForest);
                intent.putExtra("sendFinalTendency",receivedTendency);
                startActivityForResult(intent, 0);



            }
        });
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

