package com.example.aatracker.Model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class Fighter extends Unit {

    public Fighter(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
        Hitpoints = hitpoints;
    }

    public static Fighter Create1940PacificFighter()
    {
        return new Fighter(10, 3, 4, 1);
    }

    public static Fighter CreateFighter(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificFighter();
            default:
                throw new Resources.NotFoundException(String.format("No fighter of type %s found.", type));
        }
    }

    public static List<Unit> CreateFighters(int nFighters, GameTypes type)
    {
        List<Unit> artileries = new ArrayList<>();
        for (int i = 0; i < nFighters; i++)
        {
            artileries.add(CreateFighter(type));
        }
        return  artileries;
    }
}
