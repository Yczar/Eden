package com.xhino.eden;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Eden extends AppCompatActivity {

    //private static final String TAG=tag;
    TextView textView;
    String selectedTreeName;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_screen);
        textView=findViewById(R.id.crops_names);
     /*   Intent intent=getIntent();
        String nameCrop= intent.getStringExtra("sendCropName");
        String BotanicalName=intent.getStringExtra("sendBotanicalName");
        String nameState=intent.getStringExtra("sendFinalState");
        String nameForest=intent.getStringExtra("sendFinalForest");
      double erosionTendencies=intent.getDoubleExtra("sendFinalTendency",30.0);*/
    getDataFromFireBase();


        Eden eden = new Eden();
        List<Tree> trees = new ArrayList<Tree>();
        trees.add(eden.new Tree("Albizia Lebbeck Sepium",85.0,70.0,60.0,"Savannah",10.0,75.0));
        trees.add(eden.new Tree("Gliricidia Sepium",60.0,80.0,60.0,"Tropical Rainforest/Savannah",85.0,55.0));
        trees.add(eden.new Tree("Acacia Mangium",55.0,75.0,40.0,"Tropical Rainforest",70.0,50.0));
        trees.add(eden.new Tree("Cajanus Cajan",50.0,60.0,80.0,"Tropical Rainforest/Savannah",70.0,80.0));
        trees.add(eden.new Tree("Leucaena leucocephala",60.0,75.0,70.0,"Tropical rainforest/Savannah",85.0,55.0));
        trees.add(eden.new Tree("Sesbania sesban",40.0,65.0,70.0,"Tropical rainforest/Savannah",85.0,55.0));
        trees.add(eden.new Tree("Senna siamea",70.0,70.0,70.0,"Tropical rainforest/Savannah",0.0,55.0));
        trees.add(eden.new Tree("Tectona grandis", 80.0, 70.0,75.0,"Tropical rainforest/Savannah",50.0,55.0));
        trees.add(eden.new Tree ("Gmelina arborea",80.0,75.0,75.0,"Tropical rainforest/Savannah",50.0,60.0));
        trees.add(eden.new Tree("Rincoderdrum heudelotii",80.0,70.0,30.0,"Tropical rainforest/Savannah",50.0,70.0));
        trees.add(eden.new Tree("Elaeis guineensis",80.0,50.0, 60.0,"Tropical rainforest/ Savannah",30.0,65.0));


        List<Integer> spacing = new ArrayList<Integer>();
        spacing.add(3);
        spacing.add(3);

        Crop crop = eden.new Crop("Theobroma Cacao","Cocoa",spacing,60.0);
        String state = "ondo";
        Double erosionTendency = 70.0;

        FarmerInput farmerInput = eden.new FarmerInput(crop,state,erosionTendency);
        //call main method that selects the best tree
        Optional<Tree> selectedTree = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            selectedTree = eden.getBestTreeMatch(farmerInput, trees);

            selectedTreeName=selectedTree.get().name;
            textView.setText(selectedTreeName);
        }

    }



    private static Double offset = 10.0;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Tree> getBestTreeMatch(FarmerInput farmerInput, List<Tree> trees){
        //throw an exception if tree list is empty
        List<Tree> treesThatMatchForestType = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            treesThatMatchForestType = trees
                    .stream()
                    .filter((t) -> t.Location.equals(States.getForestType(farmerInput.state)))
                    .collect(Collectors.toList());
        }

        //have a default selection in case no tree will completely meets the criteria below
        Optional<Tree> defaultSelection = Optional.empty();
        List<Tree> treesSatisfyErosionCriteria = new ArrayList<Tree>();
        if(treesThatMatchForestType.size() > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                defaultSelection = treesThatMatchForestType
                        .stream()
                        .max(Comparator.comparing((Tree t) -> t.NitrogenFixation)
                                .thenComparing(t -> t.Fertility_Improvement)
                                .thenComparing(t -> t.Fodder_Production));
            }
            treesSatisfyErosionCriteria = trees
                    .stream()
                    .filter((t) -> (t.Erosion_Reduction >= (farmerInput.erosionTendency-offset)))
                    .collect(Collectors.toList());
        }

        //a better default selection in case no tree will completely meets the criteria below
        List<Tree> treesSatisfyShadeCriteria = new ArrayList<Tree>();
        if(treesSatisfyErosionCriteria.size() > 0) {
            defaultSelection = treesThatMatchForestType
                    .stream()
                    .max(Comparator.comparing((Tree t) -> t.NitrogenFixation)
                            .thenComparing(t -> t.Fertility_Improvement)
                            .thenComparing(t -> t.Fodder_Production));

            treesSatisfyShadeCriteria = treesSatisfyErosionCriteria
                    .stream()
                    .filter(t -> (t.Shade_Function >= farmerInput.crop.shadeRequirement-offset && t.Shade_Function<=farmerInput.crop.shadeRequirement+offset))
                    .collect(Collectors.toList());
        }

        //return the best out of the remaining trees left
        if(treesSatisfyShadeCriteria.size() > 0) {
            return treesSatisfyShadeCriteria
                    .stream()
                    .max(Comparator.comparing((Tree t) -> t.NitrogenFixation)
                            .thenComparing(t -> t.Fertility_Improvement)
                            .thenComparing(t -> t.Fodder_Production));
        }

        return defaultSelection;
    }



    public class Tree {
        public String name;
        public Double Erosion_Reduction;
        public Double Fertility_Improvement;
        public Double Fodder_Production;
        public String Location;
        public Double NitrogenFixation;
        public Double Shade_Function;

        public Tree(String name, Double Erosion_Reduction, Double Fertility_Improvement, Double Fodder_Production,
                    String Location, Double NitrogenFixation, Double Shade_Function){
            this.name = name;
            this.Erosion_Reduction = Erosion_Reduction;
            this.Fertility_Improvement = Fertility_Improvement;
            this.Fodder_Production = Fodder_Production;
            this.Location = Location;
            this.NitrogenFixation = NitrogenFixation;
            this.Shade_Function = Shade_Function;
        }
        @Override
        public String toString(){
            return String.format("[Name : %1$s\nLocation : %2$s,\nErosion Reduction : %3$.2f,\nFertility Improvement : %4$.2f,\nShade Function: %5$.2f]",
                    name,Location,Erosion_Reduction,Fertility_Improvement,Shade_Function);
        }
    }

    public class Crop {
        public String BotanicalName;
        public String CropName;
        public List<Integer> spacing;
        public Double shadeRequirement;

        public Crop(String BotanicalName, String CropName, List<Integer> spacing, Double shadeRequirement){
            this.BotanicalName = BotanicalName;
            this.CropName = CropName;
            this.spacing = spacing;
            this.shadeRequirement = shadeRequirement;
        }
    }

    public class FarmerInput {
        public Crop crop;
        public String state;
        public Double erosionTendency;

        public FarmerInput(Crop crop, String state, Double erosionTendency){
            this.crop = crop;
            this.state = state;
            this.erosionTendency = erosionTendency;
        }
    }

    public static class States{
        public static Map<String, String> statesDictionary = new HashMap<String, String>();

        public static String getForestType(String state) {
            statesDictionary.put("Osun", "Savannah");
            statesDictionary.put("Ondo", "Tropical Rainforest/Savannah");
            statesDictionary.put("Benue", "Tropical Rainforest");
            statesDictionary.put("Lagos"  , "Mangrove");
            statesDictionary.put("Bauchi","Woodland and Tall Grass Savannah");
            statesDictionary.put("Borno","Short grass Savannah");
            statesDictionary.put("Kano","Short grass Savannah");
            statesDictionary.put("Kwara","Woodland and Tall Grass Savannah");
            statesDictionary.put("Ogun","Tropical Rainforest");
            statesDictionary.put("Rivers","RainForest");

            return statesDictionary.get(state);
        }
    }

    private void getDataFromFireBase() {

    }
}
