package com.xhino.eden;

public class Tree {
    public String name;
    public Double erosionReduction;
    public Double fertilityImprovement;
    public Double fodderProduction;
    public String location;
    public Double nitrogenFixation;
    public Double shadeFunction;

    public Tree(String name, Double erosionReduction, Double fertilityImprovement, Double fodderProduction,
                String location, Double nitrogenFixation, Double shadeFunction) {
        this.name = name;
        this.erosionReduction = erosionReduction;
        this.fertilityImprovement = fertilityImprovement;
        this.fodderProduction = fodderProduction;
        this.location = location;
        this.nitrogenFixation = nitrogenFixation;
        this.shadeFunction = shadeFunction;
    }
}
