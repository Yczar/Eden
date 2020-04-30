package com.xhino.eden;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class StateActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    RecyclerView mStateList;
    FirestoreRecyclerAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.states_list);
        FirebaseApp.initializeApp(this);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mStateList = findViewById(R.id.state_list);

        Query query = firebaseFirestore.collection("States");
        FirestoreRecyclerOptions<StateModel> options = new FirestoreRecyclerOptions.Builder<StateModel>().
                setQuery(query, StateModel.class).
                build();

        adapter = new StateAdapter(options);
        mStateList.setHasFixedSize(true);
        mStateList.setLayoutManager(new LinearLayoutManager(this));
        mStateList.setAdapter(adapter);

    }


}
