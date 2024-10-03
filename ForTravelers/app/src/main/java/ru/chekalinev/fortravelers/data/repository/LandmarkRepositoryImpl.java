package ru.chekalinev.fortravelers.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ru.chekalinev.fortravelers.domain.models.Landmark;
import ru.chekalinev.fortravelers.domain.repository.LandmarkRepository;

public class LandmarkRepositoryImpl implements  LandmarkRepository{

    private List<Landmark> landmarks;

    public LandmarkRepositoryImpl(){
        Landmark landmark1 = new Landmark("landmark1", "address1");
        Landmark landmark2 = new Landmark("landmark2", "address2");
        Landmark landmark3 = new Landmark("landmark3", "address3");
        landmarks = Arrays.asList(landmark1, landmark2, landmark3);
    }
    public String GetLandmarks(){
        String result = "";
        for(Landmark landmark : landmarks){
            result += landmark.getName()+" "+landmark.getAddress()+"\n";
        }
        return result;
    }
}
