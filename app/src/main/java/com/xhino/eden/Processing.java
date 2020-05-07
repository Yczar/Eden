package com.xhino.eden;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.xhino.eden.model.Crop;
import com.xhino.eden.model.Tree;
import com.xhino.eden.utils.LandUtil;

import java.util.ArrayList;
import java.util.List;

public class Processing extends AppCompatActivity {

    //To be used During FireStore UPDATES.

  FirebaseFirestore firebaseFirestore;

    private String TAG;
    private Eden pEden;
    private FarmerInput pFarmerInput;
    TextView selected_state,selected_crop,best_tree,selectedTreeRegion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_screen);
        selected_state=findViewById(R.id.state_select);
        selected_crop=findViewById(R.id.crops_select);
        best_tree=findViewById(R.id.best_tree_Display);
        selectedTreeRegion=findViewById(R.id.Tree_region);

        List<Tree> trees = new Tree().getTreeDataLocally();
        Double erosionTendency = LandUtil.getRandomErosionTendency();

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("FarmerInput", Context.MODE_PRIVATE);
        String state = preferences.getString("state", "");
        String cropString = preferences.getString("cropdata", "");
        Gson gson = new Gson();
        Crop crop = gson.fromJson(cropString, Crop.class); //convert json string back to Crop object


        pFarmerInput = new FarmerInput(crop, state, erosionTendency);
        //populate the `trees` with list of trees from the database
        pEden = new Eden();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Tree selectedTree = pEden.getBestTreeMatch(pFarmerInput, trees).get();
            String FinalStateDisplay=state;
            String  FinalCropName=crop.getCropName();
            String BestTreeDisplayName=selectedTree.name;
           // String BestTreeDisplayForest=selectedTree.Location;
            String BestTreeDisplayRegion=selectedTree.Location;
            selected_state.setText(FinalStateDisplay);
            selected_crop.setText(FinalCropName);
            best_tree.setText(BestTreeDisplayName);
            selectedTreeRegion.setText(BestTreeDisplayRegion);





        }

        //Fetching Trees From FireStore Would be implemented soon.
       // firebaseFirestore =   FirebaseFirestore.getInstance();
       // CollectionReference forest = firebaseFirestore.collection("Forest Trees");
       /* firebaseFirestore.collection("Forest Trees").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            private Object QueryDocumentSnapshot;

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());

                        Toast.makeText(Processing.this,"Success",  Toast.LENGTH_LONG).show();
                        Intent intent = new Intent (Processing.this, CropsActivity.class);
                        startActivity(intent);

                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());


                }

//                String dummy=QueryDocumentSnapshot.toString();
            }
        });*/

    }
        }


