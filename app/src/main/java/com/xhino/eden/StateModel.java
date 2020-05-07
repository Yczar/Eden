package com.xhino.eden;

public class StateModel {

private String StateName, ForestType;


   public StateModel(){



    }



    public StateModel (String StateName, String ForestType){

        this.StateName=StateName;
        this.ForestType=ForestType;


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



}
