package com.example.aatracker;

import com.example.aatracker.Model.Troops;

public interface IUnitCombiner {
    void AssignBonusesForAttacker(Troops troops);

    void AssignBonusesForDefender(Troops troops);
}
