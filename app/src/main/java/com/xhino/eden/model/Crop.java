package com.xhino.eden.model;

import java.util.List;

 public class Crop {
     //for FireStore Integration

     private String BotanicalName;
     private String CropName;
     private List<Integer> spacing;
     public Double shadeRequirement;

     public Crop(){}
     public Crop(String botanicalName, String name, List<Integer> spacing, Double shadeRequirement) {
         this.BotanicalName = botanicalName;
         this.CropName = name;
         this.spacing = spacing;
         this.shadeRequirement = shadeRequirement;
     }
     public String getCropName() {
         return CropName;
     }

     public void setCropName(String cropName) {
         CropName = cropName;
     }

     public String getBotanicalName() {
         return BotanicalName;
     }

     public void setBotanicalName(String botanicalName) {
         BotanicalName = botanicalName;
     }
     public Double getShadeRequirement() {
         return shadeRequirement;
     }

     public void setShadeRequirement(Double shadeRequirement) {
         this.shadeRequirement = shadeRequirement;
     }

 }


