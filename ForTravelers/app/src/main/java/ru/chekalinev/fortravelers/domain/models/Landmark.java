package ru.chekalinev.fortravelers.domain.models;

public class Landmark {
    private String name;
    private String address;

    public Landmark(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

}
