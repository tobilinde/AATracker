package com.example.aatracker.Model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class Artilery extends Unit {

    public Artilery(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
        Hitpoints = hitpoints;
    }

    public static Artilery Create1940PacificArtilery()
    {
        return new Artilery(4, 2, 2, 1);
    }

    public static Artilery CreateArtilery(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificArtilery();
            default:
                throw new Resources.NotFoundException(String.format("No artilery of type %s found.", type));
        }
    }

    public static List<Unit> CreateArtileries(int nArtileries, GameTypes type)
    {
        List<Unit> artileries = new ArrayList<>();
        for (int i = 0; i < nArtileries; i++)
        {
            artileries.add(CreateArtilery(type));
        }
        return  artileries;
    }
}