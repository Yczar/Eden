package com.xhino.eden;

public class StateModel {


private String StateName, ForestType;

    private StateModel(){

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
