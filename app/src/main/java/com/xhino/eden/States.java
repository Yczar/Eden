package com.xhino.eden;

import java.util.HashMap;
import java.util.Map;

class States {
    private static Map<String, String> statesDictionary = new HashMap<String, String>();

    public static String getForestType(String state) {

        //put all states and their forest type here
        statesDictionary.put("Osun", "Savannah");
        statesDictionary.put("Ondo", "Tropical Rainforest");
        statesDictionary.put("Benue", "Tropical Rainforest");
        statesDictionary.put("Lagos", "Mangrove");
        statesDictionary.put("Bauchi", "Savannah");
        statesDictionary.put("Borno", "Savannah");
        statesDictionary.put("Kano", "Savannah");
        statesDictionary.put("Kwara", "Savannah");
        statesDictionary.put("Ogun", "Rainforest");
        statesDictionary.put("Rivers", "Fresh Water Swamp");
        statesDictionary.put("Enugu", "Savannah");
        statesDictionary.put("Kastina", "Savannah");
        statesDictionary.put("Kaduna", "Savannah");
        statesDictionary.put("plateau", "Savannah");
        statesDictionary.put("Kogi", "Savannah");
        statesDictionary.put("Abuja", "Savannah");
        statesDictionary.put("Edo", "Tropical Rainforest");
        statesDictionary.put("Niger", "Savannah");


        return statesDictionary.get(state);
    }
}