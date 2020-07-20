package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;

public class CombatCalculator implements ICombatCalculator {

    private ICombatRunner CombatRunner;
    private IUnitCombiner UnitCombiner;

    public CombatCalculator(ICombatRunner combatRunner, IUnitCombiner unitCombiner)
    {
        CombatRunner = combatRunner;
        UnitCombiner = unitCombiner;
    }

    public int CalculateCombat(Troops attackerExternal, Troops defenderExternal, GameTypes type)
    {
        Troops attacker = Troops.CopyTroops(attackerExternal, type);
        Troops defender = Troops.CopyTroops(defenderExternal, type);
        while (attacker.NumberOfTroops() > 0 && defender.NumberOfTroops() > 0){
            UnitCombiner.AssignBonusesForAttacker(attacker);
            UnitCombiner.AssignBonusesForDefender(defender);
            int attackHits = CombatRunner.Attack(attacker);
            int defenseHits = CombatRunner.Defense(defender);
            attacker = CombatRunner.RemoveTroopsByIPCValue(attacker, defenseHits, type);
            defender = CombatRunner.RemoveTroopsByIPCValue(defender, attackHits, type);
        }
        return GetCombatOutcome(attacker, defender);
    }

    private int GetCombatOutcome(Troops attacker, Troops defender){
        if (attacker.NumberOfTroops() > 0 && defender.NumberOfTroops() <= 0)
        {
            return 1;
        }
        else if (attacker.NumberOfTroops() <= 0 && defender.NumberOfTroops() > 0)
        {
            return -1;
        }
        else{
            return 0;
        }
    }
}
