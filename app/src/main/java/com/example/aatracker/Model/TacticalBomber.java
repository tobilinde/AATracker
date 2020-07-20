package com.example.aatracker.Model;

import android.content.res.Resources;

import androidx.appcompat.view.StandaloneActionMode;

import java.util.ArrayList;
import java.util.List;

public class TacticalBomber extends Unit {

    public TacticalBomber(int cost, int attack, int defense, int hitpoints)
    {
        Cost = cost;
        Attack = attack;
        Defense = defense;
    }

    public static TacticalBomber Create1940PacificTacticalBomber()
    {
        return new TacticalBomber(11, 3, 3, 1);
    }

    public static TacticalBomber CreateTacticalBomber(GameTypes type) {
        switch (type) {
            case Pacific1940:
                return Create1940PacificTacticalBomber();
            default:
                throw new Resources.NotFoundException(String.format("No tactical bomber of type %s found.", type));
        }
    }

    public static List<Unit> CreateTacticalBombers(int nTacticalBombers, GameTypes type)
    {
        List<Unit> tacticalBombers = new ArrayList<>();
        for (int i = 0; i < nTacticalBombers; i++)
        {
            tacticalBombers.add(CreateTacticalBomber(type));
        }
        return  tacticalBombers;
    }
}
