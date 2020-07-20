package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;

public interface ICombatCalculator {

    int CalculateCombat(Troops attacker, Troops defender, GameTypes type);

}
