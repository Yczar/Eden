package com.xhino.eden;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateHolder>{
    private OnItemClickedListener mListener;

    private ArrayList<StateModel> mStateList;

  public interface OnItemClickedListener{
      void OnItemClick(int position);
  }

  public void setOnItemClickListener(OnItemClickedListener listener){
      mListener=listener;
  }

    @NonNull
    @Override
    public StateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.states_item_list, parent, false);

       StateHolder stateHolder=new StateHolder(v, mListener);
        return  stateHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StateHolder holder, int position) {
       StateModel currentState = mStateList.get(position);

        holder.mTextView1.setText(currentState.getStateName());
        holder.mTextView2.setText(currentState.getForestType());




    }

    @Override
    public int getItemCount() {
        return mStateList.size();
    }

    public static class StateHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public TextView mTextView2;


        public StateHolder(@NonNull View itemView, OnItemClickedListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.state_name);
            mTextView2 = itemView.findViewById(R.id.Forest);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }


                }
            });
        }
    }
    public StateAdapter(ArrayList<StateModel> stateItem) {
        mStateList= stateItem;
    }

}
