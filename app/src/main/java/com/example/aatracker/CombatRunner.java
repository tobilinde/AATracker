package com.example.aatracker;

import com.example.aatracker.Model.Artilery;
import com.example.aatracker.Model.Fighter;
import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Infantry;
import com.example.aatracker.Model.MechanizedInfantry;
import com.example.aatracker.Model.StrategicalBomber;
import com.example.aatracker.Model.TacticalBomber;
import com.example.aatracker.Model.Tank;
import com.example.aatracker.Model.Troops;
import com.example.aatracker.Model.Unit;

import java.util.List;

public class CombatRunner implements ICombatRunner {

    private IDice Dice;

    public CombatRunner(IDice dice)
    {
        Dice = dice;
    }

    public Troops RemoveTroopsByIPCValue(Troops troops, int hits, GameTypes type)
    {
        if (troops.NumberOfTroops() <= hits)
        {
            return Troops.CreateTroops(0, 0, 0, 0, 0, 0, 0, type);
        }
        else if (hits == 0) {
            return SetupUnitsForNextRound(troops.GetUnitsByIPCCost(), type);
        }
        else
        {
            List<Unit> unitsByCost = troops.GetUnitsByIPCCost();
            List<Unit> survivors = unitsByCost.subList(hits , unitsByCost.size());
            return SetupUnitsForNextRound(survivors, type);
        }
    }

    private Troops SetupUnitsForNextRound(List<Unit> survivors, GameTypes type) {
        int nInfantry = 0;
        int nArtilery = 0;
        int nMechanizedInfantry = 0;
        int nTank = 0;
        int nFighter = 0;
        int nTacticalBomber = 0;
        int nStrategicBomber = 0;
        for (Unit u: survivors) {
            if (u instanceof Infantry)
            {
                nInfantry++;
            }
            if (u instanceof Artilery)
            {
                nArtilery++;
            }
            if (u instanceof MechanizedInfantry)
            {
                nMechanizedInfantry++;
            }
            if (u instanceof Tank)
            {
                nTank++;
            }
            if (u instanceof Fighter)
            {
                nFighter++;
            }
            if (u instanceof TacticalBomber)
            {
                nTacticalBomber++;
            }
            if (u instanceof StrategicalBomber)
            {
                nStrategicBomber++;
            }
        }
        return Troops.CreateTroops(nArtilery, nFighter, nInfantry, nMechanizedInfantry, nStrategicBomber, nTacticalBomber, nTank, type);
    }

    public int Attack(Troops troops)
    {
        int hits = 0;
        hits += CalculateOffensiveHits(troops.Artileries);
        hits += CalculateOffensiveHits(troops.Fighters);
        hits += CalculateOffensiveHits(troops.Infantries);
        hits += CalculateOffensiveHits(troops.MechanizedInfantries);
        hits += CalculateOffensiveHits(troops.StrategicalBombers);
        hits += CalculateOffensiveHits(troops.TacticalBommbers);
        hits += CalculateOffensiveHits(troops.Tanks);

        return hits;
    }

    public int Defense(Troops troops)
    {
        int hits = 0;
        hits += CalculateDefensiveHits(troops.Artileries);
        hits += CalculateDefensiveHits(troops.Fighters);
        hits += CalculateDefensiveHits(troops.Infantries);
        hits += CalculateDefensiveHits(troops.MechanizedInfantries);
        hits += CalculateDefensiveHits(troops.StrategicalBombers);
        hits += CalculateDefensiveHits(troops.TacticalBommbers);
        hits += CalculateDefensiveHits(troops.Tanks);

        return hits;
    }

    private int CalculateOffensiveHits(List<Unit> units) {
        int hits = 0;
        for (Unit unit : units) {
            if (Hit(unit.Attack))
            {
                hits++;
            }
        }
        return hits;
    }

    private int CalculateDefensiveHits(List<Unit> units) {
        int hits = 0;
        for (Unit unit : units) {
            if (Hit(unit.Defense))
            {
                hits++;
            }
        }
        return hits;
    }

    private boolean Hit(int strength)
    {
        int roll = Dice.RollDice(1, 6);
        if (roll <= strength)
        {
            return true;
        }
        return false;
    }
}
