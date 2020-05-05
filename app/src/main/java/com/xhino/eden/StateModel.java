package com.xhino.eden;

public class StateModel {

private String StateName, ForestType;
private int erosion_Tendency;

   public StateModel(){



    }



    public StateModel (String StateName, String ForestType, int erosion_Tendency){

        this.StateName=StateName;
        this.ForestType=ForestType;
        this.erosion_Tendency=erosion_Tendency;


    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getForestType() {
        return ForestType;
    }

    public void setForestType(String forestType) {
        ForestType = forestType;
    }


    public int getErosion_Tendency() {
        return erosion_Tendency;
    }

    public void setErosion_Tendency(int erosion_Tendency) {
        this.erosion_Tendency = erosion_Tendency;
    }

}
