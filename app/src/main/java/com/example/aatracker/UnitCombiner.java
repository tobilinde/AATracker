package com.example.aatracker;

import com.example.aatracker.Model.Troops;
import com.example.aatracker.Model.Unit;

import java.util.List;

public class UnitCombiner implements IUnitCombiner {

    private final int InfatryWithArtileryUpgrade = 1;
    private final int TacticalBomnberWithFighterOrTankUpgrade = 1;

    public void AssignBonusesForAttacker(Troops troops){
        AssignInfatryWithArtilery(troops);
        AssignTacticalBomberWithFighterOrTank(troops, CombatType.Attack);
    }

    public void AssignBonusesForDefender(Troops troops){
        AssignTacticalBomberWithFighterOrTank(troops, CombatType.Defense);
    }

    private void AssignInfatryWithArtilery(Troops troops){
        if(troops.Infantries.size() > troops.Artileries.size())
        {
            ChangeCombatValue(troops.Infantries, troops.Artileries.size(), InfatryWithArtileryUpgrade, CombatType.Attack);
        }
        else {
            ChangeCombatValue(troops.Infantries, troops.Infantries.size(), InfatryWithArtileryUpgrade, CombatType.Attack);
        }
    }

    private void AssignTacticalBomberWithFighterOrTank(Troops troops, CombatType combatType)
    {
        if(troops.TacticalBommbers.size() > troops.Fighters.size() + troops.Tanks.size()) {
            ChangeCombatValue(troops.TacticalBommbers, troops.Fighters.size() + troops.Tanks.size(), TacticalBomnberWithFighterOrTankUpgrade, combatType);
        }
        else {
            ChangeCombatValue(troops.TacticalBommbers, troops.TacticalBommbers.size(), TacticalBomnberWithFighterOrTankUpgrade, combatType);
        }
    }

    private void ChangeCombatValue(List<Unit> units, int nUnitsToChange, int change, CombatType combatType){
        for(int i = 0; i < nUnitsToChange; i++){
            if (combatType == CombatType.Attack){
                units.get(i).Attack += change;
            }
            else if (combatType == CombatType.Defense){
                units.get(i).Defense += change;
            }
        }
    }
}

enum CombatType{
    Attack,
    Defense
}
