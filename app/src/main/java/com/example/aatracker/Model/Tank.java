package com.example.aatracker.Model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class Tank extends Unit {

    public Tank(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
        Hitpoints = 1;
    }

    public static Tank Create1940PacificTank()
    {
        return new Tank(6, 3, 3, 1);
    }

    public static Tank CreateTank(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificTank();
            default:
                throw new Resources.NotFoundException(String.format("No tank of type %s found.", type));
        }
    }

    public static List<Unit> CreateTank(int nTanks, GameTypes type)
    {
        List<Unit> tanks = new ArrayList<>();
        for (int i = 0; i < nTanks; i++)
        {
            tanks.add(CreateTank(type));
        }
        return  tanks;
    }
}
