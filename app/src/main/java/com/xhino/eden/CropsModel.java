package com.xhino.eden;

public class CropsModel {

    private String CropName;
    private String BotanicalName;
    public Double shadeRequirement;

    private CropsModel(){}


    public Double getShadeRequirement() {
        return shadeRequirement;
    }

    public void setShadeRequirement(Double shadeRequirement) {
        this.shadeRequirement = shadeRequirement;
    }

    private CropsModel(String CropName, String BotanicalName, double shadeRequirement){

        this.CropName=CropName;
        this.BotanicalName=BotanicalName;
        this.shadeRequirement=shadeRequirement;

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
}
