package com.example.aatracker;

import com.example.aatracker.Model.Unit;

import java.util.List;

public class CostCalculator {

    public int CalculateCost(List<Unit> units)
    {
        int cost = 0;
        for(Unit unit : units) {
            cost += unit.Cost;
        }
        return cost;
    }

}
