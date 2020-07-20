package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;

public interface ICombatRunner {

    int Attack(Troops troops);

    int Defense(Troops troops);

    Troops RemoveTroopsByIPCValue(Troops troops, int hits, GameTypes type);

}
