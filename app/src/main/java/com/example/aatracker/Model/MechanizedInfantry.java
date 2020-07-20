package com.example.aatracker.Model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class MechanizedInfantry extends Unit {

    public MechanizedInfantry(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
        Hitpoints = hitpoints;
    }

    public static MechanizedInfantry Create1940PacificMechanizedInfantry()
    {
        return new MechanizedInfantry(4, 1, 2, 1);
    }

    public static MechanizedInfantry CreateMechanizedInfantry(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificMechanizedInfantry();
            default:
                throw new Resources.NotFoundException(String.format("No mechanized infantry of type %s found.", type));
        }
    }

    public static List<Unit> CreateMechanizedInfantries(int nMechanizedInfantries, GameTypes type)
    {
        List<Unit> mechanizedInfantries = new ArrayList<>();
        for (int i = 0; i < nMechanizedInfantries; i++)
        {
            mechanizedInfantries.add(CreateMechanizedInfantry(type));
        }
        return  mechanizedInfantries;
    }
}
