package com.xhino.eden;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class StateAdapter extends FirestoreRecyclerAdapter<StateModel, StateAdapter.StateHolder> {



    public StateAdapter(@NonNull FirestoreRecyclerOptions<StateModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull StateHolder holder, int position, @NonNull StateModel model) {
        holder.states_Name.setText(model.getStateName());
        holder.forest_Type.setText(model.getForestType());


    }

    @NonNull
    @Override
    public StateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.states_item_list,parent, false);

        return new  StateHolder(v);
    }

    class StateHolder extends RecyclerView.ViewHolder{

        private TextView states_Name;
        private TextView forest_Type;


        public StateHolder(@NonNull View itemView) {
            super(itemView);

           states_Name= itemView.findViewById(R.id.state_name);
           forest_Type = itemView.findViewById(R.id.Forest);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
        }
    }
}
