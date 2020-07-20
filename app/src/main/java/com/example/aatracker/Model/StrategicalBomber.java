package com.example.aatracker.Model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class StrategicalBomber extends Unit {

    public StrategicalBomber(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
        Hitpoints = hitpoints;
    }

    public static StrategicalBomber Create1940PacificStrategicBomber()
    {
        return new StrategicalBomber(12, 4, 1, 1);
    }

    public static StrategicalBomber CreateStrategicalBomber(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificStrategicBomber();
            default:
                throw new Resources.NotFoundException(String.format("No strategical bomber of type %s found.", type));
        }
    }

    public static List<Unit> CreateStrategicalBombers(int nStrategicalBombers, GameTypes type)
    {
        List<Unit> strategicalBombers = new ArrayList<>();
        for (int i = 0; i < nStrategicalBombers; i++)
        {
            strategicalBombers.add(CreateStrategicalBomber(type));
        }
        return  strategicalBombers;
    }
}
