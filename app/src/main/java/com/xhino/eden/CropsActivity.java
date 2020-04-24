package com.xhino.eden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CropsActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    RecyclerView mcropList;
    FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crops_list);

        firebaseFirestore=FirebaseFirestore.getInstance();
        mcropList=findViewById(R.id.crop_list);

        Query query=firebaseFirestore.collection("Crops");
        FirestoreRecyclerOptions<CropsModel> options= new FirestoreRecyclerOptions.Builder<CropsModel>().
                setQuery(query, CropsModel.class).
                build();

        adapter= new FirestoreRecyclerAdapter<CropsModel, cropsViewHolder>(options) {
            @NonNull
            @Override
            public cropsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.crops_item_list,parent, false);

                return new  cropsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull cropsViewHolder holder, int position, @NonNull CropsModel model) {
                 holder.crop_name.setText(model.getCropName());
                 holder.botanical_name.setText(model.getBotanicalName());


            }
        };

        mcropList.setHasFixedSize(true);
        mcropList.setLayoutManager(new LinearLayoutManager(this));
        mcropList.setAdapter(adapter);
        }

    private class cropsViewHolder extends RecyclerView.ViewHolder {

        private TextView crop_name;
        private TextView botanical_name;
        public cropsViewHolder(@NonNull View itemView) {
            super(itemView);


            crop_name=findViewById(R.id.crop_name);
            botanical_name=findViewById(R.id.Botanical);
        }
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


