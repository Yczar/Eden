package com.xhino.eden;

public class CropsModel {

    private String CropName;
    private String BotanicalName;

    private CropsModel(){}


    private CropsModel(String CropName, String BotanicalName){

        this.CropName=CropName;
        this.BotanicalName=BotanicalName;

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
