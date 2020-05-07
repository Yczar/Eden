package com.xhino.eden.model;

import java.util.ArrayList;
import java.util.List;

//For FireStore Purpose
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
    public Tree(){

    }
    public List<Tree> getTreeDataLocally(){
        List<Tree> trees = new ArrayList<Tree>();
        trees.add(new Tree("Albizia Lebbeck Sepium",85.0,70.0,60.0,"Savannah",10.0,75.0));
        trees.add(new Tree("Gliricidia Sepium",60.0,80.0,60.0,"Tropical Rainforest/Savannah",85.0,55.0));
        trees.add(new Tree("Acacia Mangium",55.0,75.0,40.0,"Tropical Rainforest",70.0,50.0));
        trees.add(new Tree("Cajanus Cajan",50.0,60.0,80.0,"Tropical Rainforest/Savannah",70.0,80.0));
        trees.add(new Tree("Leucaena leucocephala",60.0,75.0,70.0,"Tropical Rainforest/Savannah",85.0,55.0));
        trees.add(new Tree("Sesbania sesban",40.0,65.0,70.0,"Tropical Rainforest/Savannah",85.0,55.0));
        trees.add(new Tree("Senna siamea",70.0,70.0,70.0,"Tropical Rrainforest/Savannah",0.0,55.0));
        trees.add(new Tree("Tectona grandis", 80.0, 70.0,75.0,"Tropical Rainforest/Savannah",50.0,55.0));
        trees.add(new Tree ("Gmelina arborea",80.0,75.0,75.0,"Tropical Rainforest/Savannah",50.0,60.0));
        trees.add(new Tree("Rincoderdrum heudelotii",80.0,70.0,30.0,"Tropical Rainforest/Savannah",50.0,70.0));
        trees.add(new Tree("Elaeis guineensis",80.0,50.0, 60.0,"Tropical Rainforest/Savannah",30.0,65.0));
        trees.add(new Tree("Irvingia gabonensis", 60.0, 60.0,60.0,"Savannah", 30.0,50.0 ));
        trees.add(new Tree("Manifera indica", 75.0,75.0,20.0,"Tropical rainforest/ Savannah",0.0,70.0));
        trees.add(new Tree("Eucalyptus grandis", 60.0,70.0,50.0,"Tropical rainforest/ Savannah",10.0,50.0));
        trees.add(new Tree("Vachellia tortilis", 50.0,65.0,60.0,"Savannah",45.0,50.0));
        trees.add(new Tree("Theobroma cacao", 40.0,70.0,20.0,"Tropical Rainforest",20.0,60.0));
        trees.add(new Tree("Celtis australis", 70.0,60.0,45.0,"Savannah",10.0,50.0));
        trees.add(new Tree("Baphia nitida", 60.0,70.0,50.0,"Savannah",40.0,60.0));
        trees.add(new Tree("Citrus spp.", 60.0,50.0,30.0,"Tropical Rainforest",20.0,40.0));




        return  trees;
    }




    @Override
    public String toString(){
        return String.format("[Name : %1$s\nLocation : %2$s,\nErosion Reduction : %3$.2f,\nFertility Improvement : %4$.2f,\nShade Function: %5$.2f]",
                name,Location,Erosion_Reduction,Fertility_Improvement,Shade_Function);
    }
}