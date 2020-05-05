package com.xhino.eden;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Objects;

public class StateActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    private RecyclerView mRecyclerView;
    private StateAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


   // private StateAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.states_list);
        ArrayList<StateModel> stateItem = new ArrayList<>();
        stateItem.add(new StateModel("Lagos", "Mangrove", 30));
        stateItem.add(new StateModel("Bauchi", "Woodland and Tall Grass Savannah", 30));
        stateItem.add(new StateModel("Borno", "Short grass Savannah", 50));
        stateItem.add(new StateModel("Kano", "Short grass Savannah", 50));
        stateItem.add(new StateModel("Kwara", "Woodland and Tall Grass Savannah", 40));
        stateItem.add(new StateModel("Ogun", "Rain Forest", 30));
        stateItem.add(new StateModel("Ondo", "Rain Forest", 30));
        stateItem.add(new StateModel("Oyo", "Rain Forest", 30));
        stateItem.add(new StateModel("Rivers", "Rain Forest", 30));
        stateItem.add(new StateModel("Sokoto", "Short grass Savannah", 30));
        stateItem.add(new StateModel("Taraba", "Woodland and Tall Grass Savannah", 30));


        mRecyclerView = findViewById(R.id.state_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StateAdapter(stateItem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new StateAdapter.OnItemClickedListener() {
            @Override
            public void OnItemClick(int position) {

                final ProgressDialog progressDialog = new ProgressDialog(StateActivity.this);
                progressDialog.setTitle("Loading...");
                progressDialog.show();


                final String s = stateItem.get(position).getStateName().toString();
                final String f = stateItem.get(position).getForestType().toString();
                final int e = stateItem.get(position).getErosion_Tendency();

                Intent intent = new Intent(StateActivity.this, CropsActivity.class);
                intent.putExtra("sendState", s);
                intent.putExtra("sendForest", f);
                intent.putExtra("sendTendency", e);
                startActivity(intent);
               /* Users user =new Users("", s, e);
                FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance()
                        .getCurrentUser())).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

            progressDialog.dismiss();
            Intent intent= new Intent(StateActivity.this, CropsActivity.class);
            intent.putExtra("sendState",s);
            intent.putExtra("sendForest",f);
            intent.putExtra("sendTendency",e);
            startActivity(intent);

                    }
                });
            }
        }

        );
*/

            }


        });
    }
}

