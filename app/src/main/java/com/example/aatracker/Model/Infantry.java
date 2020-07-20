package com.example.aatracker.Model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class Infantry extends Unit
{
    public Infantry(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
        Hitpoints = hitpoints;
    }

    public static Infantry Create1940PacificInfantry()
    {
        return new Infantry(3, 1, 2, 1);
    }

    public static Infantry CreateInfantry(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificInfantry();
            default:
                throw new Resources.NotFoundException(String.format("No infantry of type %s found.", type));
        }
    }

    public static List<Unit> CreateInfantries(int nInfantries, GameTypes type)
    {
        List<Unit> infantries = new ArrayList<>();
        for (int i = 0; i < nInfantries; i++)
        {
            infantries.add(CreateInfantry(type));
        }
        return  infantries;
    }
}