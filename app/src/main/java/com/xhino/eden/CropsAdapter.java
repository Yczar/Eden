package com.xhino.eden;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
public class CropsAdapter extends FirestoreRecyclerAdapter<CropsModel, CropsAdapter.CropsHolder> {


    public CropsAdapter(@NonNull FirestoreRecyclerOptions<CropsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CropsHolder holder, int position, @NonNull CropsModel model) {
        holder.crop.setText(model.getCropName());
        holder.botanical_name.setText(model.getBotanicalName());
    }

    @NonNull
    @Override
    public CropsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.crops_item_list,parent, false);
        return new CropsHolder(v) ;
    }

    class CropsHolder extends RecyclerView.ViewHolder{


        private TextView crop;
        private TextView botanical_name;

        public CropsHolder(@NonNull View itemView) {
            super(itemView);
            crop = itemView.findViewById(R.id.crop_name);
            botanical_name = itemView.findViewById(R.id.Botanical);
        }
    }


}
