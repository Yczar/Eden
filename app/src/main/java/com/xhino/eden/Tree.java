package com.xhino.eden;
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
    @Override
    public String toString(){
        return String.format("[Name : %1$s\nLocation : %2$s,\nErosion Reduction : %3$.2f,\nFertility Improvement : %4$.2f,\nShade Function: %5$.2f]",
                name,Location,Erosion_Reduction,Fertility_Improvement,Shade_Function);
    }
}