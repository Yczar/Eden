package com.xhino.eden.utils;

import java.util.Random;

public class LandUtil {

    public static Double getRandomErosionTendency(){
        int value = new Random().nextInt(100);
        return Double.valueOf(value);
    }
}
