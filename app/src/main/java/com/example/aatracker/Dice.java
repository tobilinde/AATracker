package com.example.aatracker;

import com.example.aatracker.IDice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice implements IDice {

    private Random Random;

    public Dice()
    {
        Random = new Random();
    }

    @Override
    public int RollDice(int min, int max) {
        return Random.nextInt((max - min) + 1) + min;
    }

    @Override
    public List<Integer> RollDice(int min, int max, int rolls) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < rolls; i++)
        {
            results.add(RollDice(min, max));
        }
        return results;
    }
}
