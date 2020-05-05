package com.xhino.eden;

public class FarmerInput {
    public Crop crop;
    public String state;
    public Double erosionTendency;

    public FarmerInput(Crop crop, String state, Double erosionTendency){
        this.crop = crop;
        this.state = state;
        this.erosionTendency = erosionTendency;
    }
}
