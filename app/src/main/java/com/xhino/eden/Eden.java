package com.xhino.eden;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xhino.eden.model.Crop;
import com.xhino.eden.model.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Eden {

    private static Double offset = 10.0;

    public Optional<Tree> getBestTreeMatch(FarmerInput farmerInput, List<Tree> trees){
        //throw an exception if tree list is empty
        List<Tree> treesThatMatchForestType = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            treesThatMatchForestType = trees
                    .stream()
                    .filter((t) -> t.Location.equals(States.getForestType(farmerInput.state)))
                    .collect(Collectors.toList());
        }

        Log.e("ForestTypeMatchOutput", treesThatMatchForestType.toString());
        //have a default selection in case no tree will completely meets the criteria below
        Optional<Tree> defaultSelection = null;
        List<Tree> treesSatisfyErosionCriteria = new ArrayList<Tree>();
        if(treesThatMatchForestType.size() > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                defaultSelection = treesThatMatchForestType
                        .stream()
                        .max(Comparator.comparing((Tree t) -> t.NitrogenFixation)
                                .thenComparing(t -> t.Fertility_Improvement)
                                .thenComparing(t -> t.Fodder_Production));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                treesSatisfyErosionCriteria = trees
                        .stream()
                        .filter((t) -> (t.Erosion_Reduction >= (farmerInput.erosionTendency-offset)))
                        .collect(Collectors.toList());
            }
        }

        //a better default selection in case no tree will completely meets the criteria below
        List<Tree> treesSatisfyShadeCriteria = new ArrayList<Tree>();
        if(treesSatisfyErosionCriteria.size() > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                defaultSelection = treesThatMatchForestType
                        .stream()
                        .max(Comparator.comparing((Tree t) -> t.NitrogenFixation)
                                .thenComparing(t -> t.Fertility_Improvement)
                                .thenComparing(t -> t.Fodder_Production));
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                treesSatisfyShadeCriteria = treesSatisfyErosionCriteria
                        .stream()
                        .filter(t -> (t.Shade_Function >= farmerInput.crop.shadeRequirement-offset && t.Shade_Function<=farmerInput.crop.shadeRequirement+offset))
                        .collect(Collectors.toList());
            }
        }

        //return the best out of the remaining trees left
        if(treesSatisfyShadeCriteria.size() > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return treesSatisfyShadeCriteria
                        .stream()
                        .max(Comparator.comparing((Tree t) -> t.NitrogenFixation)
                                .thenComparing(t -> t.Fertility_Improvement)
                                .thenComparing(t -> t.Fodder_Production));
            }
        }

        return defaultSelection;
    }



}
