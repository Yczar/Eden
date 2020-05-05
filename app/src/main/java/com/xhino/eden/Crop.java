package com.xhino.eden;

import java.util.List;

 public class Crop {
     //for FireStore Integration

     public String botanicalName;
     public String name;
     public List<Integer> spacing;
     public Double shadeRequirement;

     public Crop(String botanicalName, String name, List<Integer> spacing, Double shadeRequirement) {
         this.botanicalName = botanicalName;
         this.name = name;
         this.spacing = spacing;
         this.shadeRequirement = shadeRequirement;
     }


 }


