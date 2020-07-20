package com.example.aatracker.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Troops {
    public List<Unit> Artileries;
    public List<Unit> Fighters;
    public List<Unit> Infantries;
    public List<Unit> MechanizedInfantries;
    public List<Unit> StrategicalBombers;
    public List<Unit> TacticalBommbers;
    public List<Unit> Tanks;

    private Troops(List<Unit> artileries,
           List<Unit> fighters,
           List<Unit> infantries,
           List<Unit> mechanizedInfantries,
           List<Unit> strategicalBombers,
           List<Unit> tacticalBombers,
           List<Unit> tanks)
    {
        Artileries = artileries;
        Fighters = fighters;
        Infantries = infantries;
        MechanizedInfantries = mechanizedInfantries;
        StrategicalBombers = strategicalBombers;
        TacticalBommbers = tacticalBombers;
        Tanks = tanks;
    }

    public static Troops CreateTroops(int nArtileries,
                               int nFighters,
                               int nInfantries,
                               int nMechanizedInfantries,
                               int nStrategicalBombers,
                               int nTacticalBombers,
                               int nTanks,
                               GameTypes type)
    {
        return new Troops(
                Artilery.CreateArtileries(nArtileries, type),
                Fighter.CreateFighters(nFighters, type),
                Infantry.CreateInfantries(nInfantries, type),
                MechanizedInfantry.CreateMechanizedInfantries(nMechanizedInfantries, type),
                StrategicalBomber.CreateStrategicalBombers(nStrategicalBombers, type),
                TacticalBomber.CreateTacticalBombers(nTacticalBombers, type),
                Tank.CreateTank(nTanks, type));
    }

    public static Troops CopyTroops(Troops troops, GameTypes type)
    {
        return Troops.CreateTroops(troops.Artileries.size(), troops.Fighters.size(), troops.Infantries.size(), troops.MechanizedInfantries.size(), troops.StrategicalBombers.size(), troops.TacticalBommbers.size(), troops.Tanks.size(), type);
    }

    public int NumberOfTroops()
    {
        return Artileries.size()
                + Fighters.size()
                + Infantries.size()
                + MechanizedInfantries.size()
                + StrategicalBombers.size()
                + TacticalBommbers.size()
                + Tanks.size();
    }

    public List<Unit> GetUnitsByIPCCost()
    {
        List<Unit> units = new ArrayList<Unit>();
        units.addAll(Infantries);
        units.addAll(Artileries);
        units.addAll(MechanizedInfantries);
        units.addAll(Tanks);
        units.addAll(Fighters);
        units.addAll(TacticalBommbers);
        units.addAll(StrategicalBombers);

        Collections.sort(units);

        return units;
    }
}
