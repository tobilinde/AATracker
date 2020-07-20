package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;

import java.util.ArrayList;
import java.util.List;

public class CombatSimulator {

    private ICombatCalculator CombatCalculator;

    public CombatSimulator(ICombatCalculator combatCalculator)
    {
        CombatCalculator = combatCalculator;
    }

    public List<Double> SimulateCombat(Troops attacker, Troops defender, int roundsOfCombat, GameTypes type)
    {
        double nAttackerVictories = 0;
        double nDraws = 0;
        double nDefenderVictories = 0;
        for(int i = 0; i < roundsOfCombat; i++)
        {
            int combatResult = CombatCalculator.CalculateCombat(attacker, defender, type);
            if (combatResult == 1) {
                nAttackerVictories++;
            }
            else if(combatResult == -1) {
                nDefenderVictories++;
            }
            else {
                nDraws++;
            }
        }
        ArrayList<Double> results = new ArrayList<Double>();
        results.add(nAttackerVictories / roundsOfCombat);
        results.add(nDefenderVictories / roundsOfCombat);
        results.add(nDraws / roundsOfCombat);
        return results;
    }
}
