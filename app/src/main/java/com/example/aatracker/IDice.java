package com.example.aatracker;

import java.util.List;

public interface IDice {

    int RollDice(int min, int max);

    List<Integer> RollDice(int min, int max, int rolls);
}
