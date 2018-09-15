package com.google.android.gms.samples.vision.barcodereader.domain;

import java.io.Serializable;
import com.google.android.gms.samples.vision.barcodereader.utils.DataHandler;


public class Meal implements Serializable {

    private int id;
    private String name;
    private float co2;
    private float energy;
    private float water;
    private String alternatives;
    private String quote;

    public Meal() {
    }

    public Meal(int id, String name, float co2, float energy, float water, String alternatives, String quote) {
        this.id = id;
        this.name = name;
        this.co2 = co2;
        this.energy = energy;
        this.water = water;
        this.alternatives = alternatives;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


    @Override
    public String toString() {
        return "Meal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", co2='" + co2 + '\'' +
                ", energy='" + energy + '\'' +
                ", water='" + water + '\'' +
                ", alternatives='" + alternatives + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}